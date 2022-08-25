package org.apache.dubbo.compiler;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.AssignExpr;
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
        this.baseDir = generator.getClassOutPutDir();
    }

    ClassOrInterfaceDeclaration generateClass(JavaClass javaClass,CompilationUnit cu) {
        ClassOrInterfaceDeclaration coid = interface2Class(javaClass,cu);

        methodGenerator.visit(cu,null);

        addStaticMethod(javaClass,coid);

        addGetInstanceMethod(javaClass,coid);

        addConstruct(javaClass,coid);

        this.generator.addImports(cu);

        saveClass(javaClass,cu);
        return coid;
    }

    public void addGetInstanceMethod(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        MethodDeclaration methodDeclaration = coid.addMethod("getInternalInstance", Modifier.Keyword.PUBLIC);
        BlockStmt blockStmt = new BlockStmt();
        methodDeclaration.setBody(blockStmt);
        methodDeclaration.setType(javaClass.getName() + "Interface");

        blockStmt.addStatement(new ReturnStmt(new NameExpr("this.instance")));
    }

    private void addStaticMethod(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        for (JavaMethod method : javaClass.getMethods()) {
            if (method.isPublic() && method.isStatic()) {
                this.generator.importList.add("java.lang.reflect.Method");
                this.generator.importList.add("java.lang.reflect.InvocationTargetException");
                MethodDeclaration methodDeclaration = coid.addMethod(method.getName(), Modifier.Keyword.PUBLIC);
                methodDeclaration.setStatic(true);
                BlockStmt blockStmt = new BlockStmt();
                methodDeclaration.setBody(blockStmt);
                this.generator.addReturnType(methodDeclaration,method);

                NameExpr klassNameExpr = new NameExpr();
                klassNameExpr.setName("try { \n          Class klass = DubboClassLoader");
                MethodCallExpr klassMethodCallExpr = new MethodCallExpr(klassNameExpr,"getKlass");
                klassMethodCallExpr.addArgument(javaClass.getName() + ".class.getName()");
                blockStmt.addStatement(klassMethodCallExpr);

                NameExpr getMethodnameExpr = new NameExpr();
                getMethodnameExpr.setName("Method method = klass");
                MethodCallExpr getMethodnameCallExpr = new MethodCallExpr(getMethodnameExpr,"getMethod");
                getMethodnameCallExpr.addArgument("\"" + method.getName() + "\"");
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
                    MethodCallExpr invokeCall = new MethodCallExpr(invokeNameExpr,"invoke");
                    invokeCall.addArgument("null");
                    for (JavaParameter parameter : method.getParameters()) {
                        invokeCall.addArgument(parameter.getName());
                    }
                    blockStmt.addStatement(invokeCall);
                    blockStmt.addStatement(new NameExpr("        } catch (NoSuchMethodException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        } catch (InvocationTargetException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        } catch (IllegalAccessException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        }"));

                } else {
                    invokeNameExpr.setName("(" + methodDeclaration.getType().toString() + ")method");
                    MethodCallExpr invokeCall = new MethodCallExpr(invokeNameExpr,"invoke");
                    invokeCall.addArgument("null");
                    for (JavaParameter parameter : method.getParameters()) {
                        invokeCall.addArgument(parameter.getName());
                    }
                    blockStmt.addStatement(new ReturnStmt(invokeCall));
                    blockStmt.addStatement(new NameExpr("        } catch (NoSuchMethodException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        } catch (InvocationTargetException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        } catch (IllegalAccessException e) {\n" +
                            "            e.printStackTrace();\n" +
                            "        }"));
                    blockStmt.addStatement(new ReturnStmt("null"));
                }


                for (JavaParameter parameter : method.getParameters()) {
                    this.generator.addParams(methodDeclaration,parameter);
                }

                this.generator.addMethodGeneric(methodDeclaration,method);

                if (!javaClass.isInterface()) {
                    this.generator.getSourthCodeChanger().addMethod(method,methodDeclaration);
                }
            }
        }
    }

    private void addConstruct(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        if (javaClass.isAbstract()) {
            addEmptyConstruct(javaClass,coid.addConstructor(Modifier.Keyword.PROTECTED));
            return;
        }

        boolean hasEmptyConstruct = false;
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

                String typeName = parameter.getType().getValue();
                if (typeName.endsWith("Interface")) {
                    args.add("((" + typeName.substring(0,typeName.length() - "Interface".length())
                            + ")" + parameter.getName() + ").getInternalInterface()");
                } else {
                    args.add(parameter.getName());
                }

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
                nameExpr.setName("this.instance = (" +className +  "Interface) DubboClassLoader");
                MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getInstance");
                methodCallExpr.addArgument(className + ".class.getName()");
                methodCallExpr.addArgument("params");
                methodCallExpr.addArgument("args");
                blockStmt.addStatement(new ExpressionStmt(methodCallExpr));
                assigninstance(javaClass,blockStmt);
            } else {
                hasEmptyConstruct = true;
                addEmptyConstruct(javaClass,parserCd);
            }
        }

        if (!hasEmptyConstruct) {
            ConstructorDeclaration constructor = coid.addConstructor();
            constructor.setProtected(true);
            addEmptyConstruct(javaClass,constructor);
        }
    }

    // super.instance = instance
    private void assigninstance(JavaClass javaClass,BlockStmt blockStmt) {
        if (javaClass.getSuperJavaClass() == null
                || javaClass.getSuperJavaClass().getFullyQualifiedName().equals("java.lang.Object")) {
            return;
        }

        AssignExpr assignExpr = new AssignExpr(new NameExpr("super.instance"),new NameExpr("this.instance"), AssignExpr.Operator.ASSIGN);
        blockStmt.addStatement(new ExpressionStmt(assignExpr));
    }

    private void addEmptyConstruct(JavaClass javaClass,ConstructorDeclaration methodDeclaration) {
        BlockStmt blockStmt = new BlockStmt();
        methodDeclaration.setBody(blockStmt);
        String className = javaClass.getSimpleName();
        NameExpr nameExpr = new NameExpr();
        nameExpr.setName("this.instance = (" +className +  "Interface) DubboClassLoader");
        MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getInstance");
        methodCallExpr.addArgument(className + ".class.getName()");
        blockStmt.addStatement(new ExpressionStmt(methodCallExpr));
        assigninstance(javaClass,blockStmt);
    }

    private String replaceGeneric(String param) {
        return param.replaceAll("\\<[^\\>]+\\>",param);
    }

    private void addField(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
            coid.addField(javaClass.getName() + "Interface","instance", Modifier.Keyword.PROTECTED);
    }

    private ClassOrInterfaceDeclaration interface2Class(JavaClass  javaClass,CompilationUnit cu) {
        cu.setPackageDeclaration(javaClass.getPackageName());
        cu.addImport("org.apache.dubbo.DubboClassLoader");
        cu.addImport("org.apache.dubbo.Interface.*");
        ClassOrInterfaceDeclaration coid = cu.getInterfaceByName(javaClass.getName() + "Interface").get();

        coid.setName(javaClass.getName());
        coid.setPublic(true);
        coid.setInterface(false);
        for (ClassOrInterfaceType extendsType : new ArrayList<>(coid.getExtendedTypes())) {
            extendsType.remove();
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
        }

        addField(javaClass,coid);

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
        File dir  = new File(this.baseDir + javaClass.getPackageName().replaceAll("\\.","/"));
        if (!dir.exists()) {
            dir.mkdirs();
        }
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
                    String typeName = parameter.getType().toString();
                    if (typeName.endsWith("Interface")) {
                        methodCallExpr.addArgument("((" + typeName.substring(0,typeName.length() - "Interface".length()) + ")"
                                + parameter.getNameAsString()  + ").getInternalInstance()");
                    } else {
                        methodCallExpr.addArgument(parameter.getNameAsString());
                    }
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
