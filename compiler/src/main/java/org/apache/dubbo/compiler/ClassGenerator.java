package org.apache.dubbo.compiler;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/16 上午11:08
 */
public class ClassGenerator {
    private Generator generator;
    private Set<String> existsDirs = new HashSet<>();
    private MethodGenerator methodGenerator  = new MethodGenerator();
    private InterfaceGenerator interfaceGenerator;
    private String baseDir;

    public ClassGenerator(Generator generator) {
        this.generator = generator;
        this.baseDir = generator.getOutputDir();
    }

    void generateClass(JavaClass javaClass,CompilationUnit cu) {
        ClassOrInterfaceDeclaration coid = interface2Class(javaClass,cu);
        addField(javaClass,coid);

        methodGenerator.visit(cu,null);

        addStaticMethod(javaClass,coid);

        addConstruct(javaClass,coid);

        save(javaClass,cu);
    }

    private void addStaticMethod(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        for (JavaMethod method : javaClass.getMethods()) {
            if (method.isPublic() && method.isStatic()) {
                MethodDeclaration methodDeclaration = coid.addMethod(method.getName(), Modifier.Keyword.PUBLIC);
                methodDeclaration.setStatic(true);
                BlockStmt blockStmt = new BlockStmt();
                methodDeclaration.setBody(blockStmt);

                NameExpr getMethodnameExpr = new NameExpr();
                getMethodnameExpr.setName("Method method = instance.getClass()");
                MethodCallExpr getMethodnameCallExpr = new MethodCallExpr(getMethodnameExpr,"getMethod");
                for (JavaParameter parameter : method.getParameters()) {
                    if (this.interfaceGenerator.checkName(parameter.getJavaClass())) {
                        getMethodnameCallExpr.addArgument(this.interfaceGenerator.addInterface(parameter.getType().getValue()));
                    } else {
                        getMethodnameCallExpr.addArgument(parameter.getType().getValue());
                    }
                }
                blockStmt.addStatement(getMethodnameCallExpr);

                NameExpr invokeNameExpr = new NameExpr();
                if (method.getReturns().isVoid()) {
                    invokeNameExpr.setName("method");
                } else {
                    invokeNameExpr.setName("return method");
                }
                MethodCallExpr invokeCall = new MethodCallExpr(invokeNameExpr,"invoke");
                for (JavaParameter parameter : method.getParameters()) {
                    invokeCall.addArgument(parameter.getName());
                }
                blockStmt.addStatement(invokeNameExpr);
                
                
            }
        }
    }

    // 不给interface,abstact加construct
    private void addConstruct(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        if (javaClass.isInterface() || javaClass.isAbstract()) {
            return;
        }

        for (JavaConstructor constructor : javaClass.getConstructors()) {
            if (!constructor.isPublic()) {
                continue;
            }

            ConstructorDeclaration parserCd = coid.addConstructor();
            parserCd.setPublic(true);
            List<String> params = new ArrayList<>();
            List<String> args = new ArrayList<>();

            for (JavaParameter parameter : constructor.getParameters()) {
                Parameter parserParameter = new Parameter();
                parserParameter.setName(parameter.getName());
                args.add(parameter.getName());

                if (this.interfaceGenerator.checkName(parameter.getType().getBinaryName())) {
                    parserParameter.setType(this.interfaceGenerator.addInterface(
                                            this.interfaceGenerator.shortName(parameter.getType().getGenericValue())));
                } else {
                    parserParameter.setType(parameter.getType().getGenericValue());
                }
                parserCd.addParameter(parserParameter);

                params.add(replaceGeneric(parserParameter.getType().asString()) + ".class");
            }

            BlockStmt blockStmt = new BlockStmt();
            parserCd.setBody(blockStmt);

            String className = javaClass.getSimpleName();

            if (params.size() != 0) {
                String paramsString = "new Class[]" + params.toString().replace("[","{")
                        .replace("]","}");
                String argsString  = "new Object[]" + args.toString().replace("[","{")
                        .replace("]","}");

                VariableDeclarator paramsDeclarator = new VariableDeclarator();
                paramsDeclarator.setName("params");
                paramsDeclarator.setType("Class[]");
                paramsDeclarator.setInitializer(paramsString);
                blockStmt.addStatement(new ExpressionStmt(new VariableDeclarationExpr(paramsDeclarator)));

                VariableDeclarator argsDeclarator = new VariableDeclarator();
                argsDeclarator.setName("args");
                argsDeclarator.setType("Object[]");
                argsDeclarator.setInitializer(argsString);
                blockStmt.addStatement(new ExpressionStmt(new VariableDeclarationExpr(argsDeclarator)));

                NameExpr nameExpr = new NameExpr();
                nameExpr.setName("instance = (" +className +  "Interface) DubboClassLoader");
                MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getInstance");
                methodCallExpr.addArgument(className + ".class.getName()");
                methodCallExpr.addArgument("params");
                methodCallExpr.addArgument("args");
                blockStmt.addStatement(new ExpressionStmt(methodCallExpr));
            } else {
                NameExpr nameExpr = new NameExpr();
                nameExpr.setName("instance = (" +className +  "Interface) DubboClassLoader");
                MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getInstance");
                methodCallExpr.addArgument(className + ".class.getName()");
                blockStmt.addStatement(new ExpressionStmt(methodCallExpr));
            }
        }
    }

    private String replaceGeneric(String param) {
        return param.replaceAll("\\<[^\\>]+\\>",param);
    }

    private void addField(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        if (javaClass.getSuperJavaClass() != null
                        && !javaClass.getSuperJavaClass().getFullyQualifiedName().equals("java.lang.Object")) {
            coid.addField(javaClass.getName() + "Interface","instance", Modifier.Keyword.PROTECTED);
        }
    }

    private ClassOrInterfaceDeclaration interface2Class(JavaClass  javaClass,CompilationUnit cu) {
        cu.setPackageDeclaration(javaClass.getPackageName());
        cu.addImport("org.apache.dubbo.DubboClassLoader");
        cu.addImport("org.apache.dubbo.Interface.*");
        ClassOrInterfaceDeclaration coid = cu.getInterfaceByName(javaClass.getName() + "Interface").get();

        coid.setName(javaClass.getName());
        coid.setPublic(true);
        coid.setInterface(false);
        for (ClassOrInterfaceType implementedType : new ArrayList<>(coid.getImplementedTypes())) {
            implementedType.remove();
        }

        ClassOrInterfaceType classOrInterfaceType = new ClassOrInterfaceType();
        classOrInterfaceType.setName(javaClass.getName() + "Interface");

        if (coid.getTypeParameters() != null && !coid.getTypeParameters().isEmpty()) {
            NodeList nodeList = new NodeList();
            classOrInterfaceType.setTypeArguments(nodeList);

            for (TypeParameter typeParameter : coid.getTypeParameters()) {
                nodeList.add(new TypeParameter().setName(typeParameter.getName()));
            }
        }

        coid.addImplementedType(classOrInterfaceType);
        return coid;
    }

    private void save(JavaClass javaClass,CompilationUnit cu) {
        if (!this.existsDirs.contains(javaClass.getPackageName())) {
            createDir(javaClass);
            this.existsDirs.add(javaClass.getPackageName());
        }

        String path = this.baseDir + javaClass.getFullyQualifiedName().replaceAll("\\.", "/") + ".java";

        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(file);
            printWriter.print(cu.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    void createDir(JavaClass javaClass) {
        File dir  = new File(baseDir + javaClass.getPackageName().replaceAll("\\.","/"));
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setInterfaceGenerator(InterfaceGenerator interfaceGenerator) {
        this.interfaceGenerator = interfaceGenerator;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    private class MethodGenerator extends ModifierVisitor {
        @Override
        public Visitable visit(MethodDeclaration n, Object arg) {
            super.visit(n, arg);
            n.setPublic(true);
            BlockStmt  blockStmt = new BlockStmt();

            NameExpr nameExpr = new NameExpr("instance");
            MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,n.getName());

            if (n.getParameters() != null && !n.getParameters().isEmpty()) {
                for (Parameter parameter : n.getParameters()) {
                    methodCallExpr.addArgument(parameter.getNameAsString());
                }
            }

            if (!n.getType().isVoidType()) {
                ReturnStmt returnStmt = new ReturnStmt();
                NameExpr returnNameExpr = new NameExpr();
                returnNameExpr.setName("anyVariableName");
                returnStmt.setExpression(returnNameExpr);
                blockStmt.addStatement(new ReturnStmt(methodCallExpr));
            } else {
                blockStmt.addStatement(methodCallExpr);
            }
            n.setBody(blockStmt);
            return n;
        }
    }

}
