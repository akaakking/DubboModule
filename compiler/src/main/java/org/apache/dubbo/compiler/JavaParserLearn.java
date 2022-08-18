package org.apache.dubbo.compiler;

import com.github.javaparser.JavaToken;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.google.common.collect.Sets;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 最多看到5点注意搞清楚一件事
 * 能不能帮我们生成代码和改代码
 *
 * @Author wfh
 * @Date 2022/8/14 下午2:43
 */
public class JavaParserLearn {

    @Test
    public void tesgg() {
        Set<String> set = new HashSet<>();
        Set<String> set1 = new HashSet<>();
        File file = new File("/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfos");
        File file1 = new File("/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfo.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
            String str = null;
            do {
                str = bufferedReader.readLine();
                set.add(str);
            } while (str != null);

            do {
                str = bufferedReader1.readLine();
                set1.add(str);
            } while (str != null);

            System.out.println(Sets.difference(set, set1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fds() {


        JavaProjectBuilder jpb = new JavaProjectBuilder();

        try {
            jpb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/ConfigScopeModelInitializer.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                for (JavaMethod method : aClass.getMethods()) {
//                    System.out.println(method); // 只有方法签名没有函数体
                    for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : method.getTypeParameters()) {
                        typeParameter.getName();
                        typeParameter.getBounds();
                    } // method 泛型

                    for (JavaParameter parameter : method.getParameters()) {
//                        System.out.println(parameter); //FrameworkModel frameworkModel ,ApplicationModel applicationModel,ModuleModel moduleMode, List a
                        JavaType javaType =parameter.getType();
//                        System.out.println(parameter.getCanonicalName()); // java.util.List java.lang.String[]
//                        System.out.println(javaType.getFullyQualifiedName()); //java.util.List java.lang.String[]
//                        System.out.println(javaType.getGenericFullyQualifiedName()); // java.util.List<java.lang.String>  java.lang.String[]
//                        System.out.println(javaType.getGenericValue());  // List<String> String[]
//                        System.out.println(javaType.getGenericCanonicalName()); // java.util.List<java.lang.String> java.lang.String[]
//                        System.out.println(javaType.toGenericString()); //java.util.List<java.lang.String> java.lang.String[]
//                        System.out.println(javaType.getBinaryName()); // java.util.List java.lang.String
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void gsdfs() {
        CompilationUnit cu = new CompilationUnit();

        NameExpr nameExpr = new NameExpr();
        nameExpr.setName("return method = instance.getClass()");
        MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getMethod");
    }

    @Test
    public void fsdbnvcf() {
        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat() {} public A(){}}");
        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();
        for (MethodDeclaration method : coid.getMethods()) {
            BlockStmt blockStmt = new BlockStmt();
            method.setBody(blockStmt);
            NameExpr nameExpr = new NameExpr("return method");
            MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"invoke");
            methodCallExpr.addArgument("fdsfd");
            blockStmt.addStatement(methodCallExpr);
        }

        System.out.println(cu);
    }

    @Test
    public void fsd() {
        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat() {}}");
        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();
        FieldDeclaration fieldDeclaration = coid.addField("List<String>","strs", Modifier.Keyword.PRIVATE);

        for (MethodDeclaration method : coid.getMethods()) {
            BlockStmt blockStmt = method.getBody().get();
            ExpressionStmt expressionStmt = new ExpressionStmt();

            VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
            VariableDeclarator variableDeclarator = new VariableDeclarator();
            variableDeclarator.setName("anyVariableName");
            variableDeclarator.setType(new ClassOrInterfaceType("AnyVariableType"));
            variableDeclarator.setInitializer("new AnyVariableType()");
            NodeList<VariableDeclarator> variableDeclarators = new NodeList<>();
            variableDeclarators.add(variableDeclarator);
            variableDeclarationExpr.setVariables(variableDeclarators);
            expressionStmt.setExpression(variableDeclarationExpr);

            NameExpr nameExpr = new NameExpr("FUf");
            MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr, "anyMethodName");
            methodCallExpr.addArgument("anyArgument");
            blockStmt.addStatement(methodCallExpr);

            ReturnStmt returnStmt = new ReturnStmt();
            NameExpr returnNameExpr = new NameExpr();
            returnNameExpr.setName("anyVariableName");
            returnStmt.setExpression(returnNameExpr);
            blockStmt.addStatement(returnStmt);

            blockStmt.addStatement(expressionStmt);
        }

        System.out.println(cu);
    }

    @Test
    public void gfsdf() {
        CompilationUnit cu = null;
        try {
            cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/bootstrap/builders/AbstractInterfaceBuilder.java"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ClassOrInterfaceDeclaration coid = cu.getClassByName("AbstractInterfaceBuilder").get();

        for (MethodDeclaration method : coid.getMethods()) {
            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getNameAsString());
            }
        }
    }

    @Test
    public void fsdf() {
        try {
            JavaProjectBuilder javaProjectBuilder= new JavaProjectBuilder();
            javaProjectBuilder.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/bootstrap/builders/AbstractMethodBuilder.java"));
            for (JavaClass aClass : javaProjectBuilder.getClasses()) {
                JavaClass javaClass = aClass.getSuperJavaClass();
                JavaType javaType = aClass.getSuperClass();

                System.out.println(javaType.getFullyQualifiedName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void addClass(CompilationUnit cu, JavaClass javaClass) {
        cu.setPackageDeclaration("org.apache.dubbo.Interface");

        ClassOrInterfaceDeclaration coid = cu.addClass("chilema");
        coid.setInterface(true);

        TypeParameter typeParameter = new TypeParameter();
        typeParameter.setName("T");
        ClassOrInterfaceType classOrInterfaceType = new ClassOrInterfaceType();
        classOrInterfaceType.setName("AbstactConfig");
        NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
        nodeList.add(classOrInterfaceType);
        typeParameter.setTypeBound(nodeList);

        coid.addTypeParameter(typeParameter);

        MethodDeclaration methodDeclaration = coid.addMethod("chifan");

        methodDeclaration.addParameter("List<String>","strs");
        methodDeclaration.setType("List"); // return type

        System.out.println(methodDeclaration.getBody());

        NodeList<TypeParameter> nodeList1 = new NodeList<>();
        TypeParameter typeParameter1 = new TypeParameter();
        nodeList1.add(typeParameter1);
        typeParameter1.setName("T");
        methodDeclaration.setTypeParameters(nodeList1); // 泛型
        System.out.println(cu);
    }

    @Test
    public void gene() {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-spring/src/main/java/org/apache/dubbo/config/spring/context/DubboInfraBeanRegisterPostProcessor.java"));

            ClassOrInterfaceDeclaration coid = cu.getClassByName("DubboInfraBeanRegisterPostProcessor").get();

            for (ClassOrInterfaceType implementedType : coid.getImplementedTypes()) {
            }

//            for (TypeParameter typeParameter : coid.getTypeParameters()) {
//                System.out.println(typeParameter.getName());
//                System.out.println(typeParameter.getTypeBound());
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gener() {
        CompilationUnit compilationUnit = new CompilationUnit();
        compilationUnit.addImport("org.springframework.boot.SpringApplication");
        compilationUnit.setPackageDeclaration("com.abc.def");
        ClassOrInterfaceDeclaration classDeclaration = compilationUnit.addClass("AnyClassName").setPublic(true);
        classDeclaration.addAnnotation("AnyAnnotation");
        compilationUnit.addClass("Wang").setPublic(true);
        System.out.println(compilationUnit);
    }

    private class RemoveFileds extends ModifierVisitor<Void> {
        @Override
        public Visitable visit(FieldDeclaration n, Void arg) {
            super.visit(n, arg);
            n.remove();
            return n;
        }
    }

    private class InterfaceMethod extends ModifierVisitor<Void> {

        @Override
        public Visitable visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            if (n.isPublic()) {
                n.removeBody();
            } else {
                n.remove();
            }
            return n;
        }
    }

}

// 今天看能不能重新做一下，顺便把class也一搞，生成代码用模板，实在不是个好办法。
