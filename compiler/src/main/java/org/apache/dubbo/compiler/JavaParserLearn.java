package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
