package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * 最多看到5点注意搞清楚一件事
 * 能不能帮我们生成代码和改代码
 *
 * @Author wfh
 * @Date 2022/8/14 下午2:43
 */
public class JavaParserLearn {

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
        JavaProjectBuilder jpb = new JavaProjectBuilder();
        try {
            jpb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/bootstrap/builders/AbstractBuilder.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : aClass.getTypeParameters()) {
                    System.out.println(typeParameter.getName());
                    for (JavaType bound : typeParameter.getBounds()) {
                        System.out.println(bound);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void gfsdf() {
        addClass(new CompilationUnit(),null);
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
