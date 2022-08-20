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
import java.util.*;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/16 上午11:08
 */
public class ClassGenerator {
    private AbstractGenerator generator;
    private Set<String> existsDirs = new HashSet<>();
    private MethodGenerator methodGenerator  = new MethodGenerator();
    private String baseDir;

    public ClassGenerator(AbstractGenerator generator) {
        this.generator = generator;
        this.baseDir = generator.getOutputDir();
    }

    void generateClass(JavaClass javaClass,CompilationUnit cu) {
        ClassOrInterfaceDeclaration coid = interface2Class(javaClass,cu);

        methodGenerator.visit(cu,null);

        addStaticMethod(javaClass,coid);

        addGetInstanceMethod(javaClass,coid);

        addGetInstanceMethod(javaClass,coid);

        addConstruct(javaClass,coid);

        this.generator.addImports(cu);

        saveClass(javaClass,cu);
    }

    public void addGetInstanceMethod(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        MethodDeclaration methodDeclaration = coid.addMethod("getInternalInstance", Modifier.Keyword.PUBLIC);
        BlockStmt blockStmt = new BlockStmt();
        methodDeclaration.setBody(blockStmt);
        methodDeclaration.setType(javaClass.getName() + "Interface");

        blockStmt.addStatement(new ReturnStmt(new NameExpr("instance")));
    }

    private void addStaticMethod(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        for (JavaMethod method : javaClass.getMethods()) {
            if (method.isPublic() && method.isStatic()) {
                MethodDeclaration methodDeclaration = coid.addMethod(method.getName(), Modifier.Keyword.PUBLIC);
                methodDeclaration.setStatic(true);
                BlockStmt blockStmt = new BlockStmt();
                methodDeclaration.setBody(blockStmt);

                NameExpr klassNameExpr = new NameExpr();
                klassNameExpr.setName("Class klass = DubboClassLoader");
                MethodCallExpr klassMethodCallExpr = new MethodCallExpr(klassNameExpr,"getKlass");
                klassMethodCallExpr.addArgument(javaClass.getName() + ".class.getName()");
                blockStmt.addStatement(klassNameExpr);

                NameExpr getMethodnameExpr = new NameExpr();
                getMethodnameExpr.setName("Method method = klass");
                MethodCallExpr getMethodnameCallExpr = new MethodCallExpr(getMethodnameExpr,"getMethod");
                getMethodnameCallExpr.addArgument(method.getName());
                for (JavaParameter parameter : method.getParameters()) {
                    if (this.generator.checkName(parameter.getJavaClass())) {
                        getMethodnameCallExpr.addArgument(this.generator.addInterface(parameter.getType().getValue()) + ".class");
                    } else {
                        getMethodnameCallExpr.addArgument(parameter.getType().getValue() + ".class");
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
                blockStmt.addStatement(invokeCall);

                this.generator.addReturnType(methodDeclaration,method);

                for (JavaParameter parameter : method.getParameters()) {
                    this.generator.addParams(methodDeclaration,parameter);
                }

                this.generator.addMethodGeneric(methodDeclaration,method);
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

                if (this.generator.checkName(parameter.getType().getBinaryName())) {
                    parserParameter.setType(this.generator.addInterface(
                                            this.generator.shortName(parameter.getType().getGenericValue())));
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
        if (javaClass.getSuperJavaClass() == null
                        || javaClass.getSuperJavaClass().getFullyQualifiedName().equals("java.lang.Object")) {
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

        if (javaClass.getSuperJavaClass() != null && !javaClass.getSuperJavaClass().getFullyQualifiedName().startsWith("java.lang.Object")) {
            coid.addExtendedType(javaClass.getSuperClass().getGenericValue());
            this.generator.importList.add(javaClass.getSuperJavaClass().getBinaryName());
        } else {
            addField(javaClass,coid);
        }

        coid.addImplementedType(classOrInterfaceType);
        return coid;
    }

    void saveClass(JavaClass javaClass,CompilationUnit cu) {
        if (!this.existsDirs.contains(javaClass.getPackageName())) {
            createDir(javaClass);
            this.existsDirs.add(javaClass.getPackageName());
        }

        String path = this.baseDir + javaClass.getFullyQualifiedName().replaceAll("\\.", "/") + ".java";

        this.generator.saveContent(cu.toString(),path);
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
                    if (parameter.getType().toString().endsWith("Interface")) {
                        methodCallExpr.addArgument(parameter.getNameAsString() + ".getInternalInstance()");
                    }
                    methodCallExpr.addArgument(parameter.getNameAsString());
                }
            }

            if (!n.getType().isVoidType()) {
                blockStmt.addStatement(new ReturnStmt(methodCallExpr));
            } else {
                blockStmt.addStatement(methodCallExpr);
            }
            n.setBody(blockStmt);
            return n;
        }
    }

}
