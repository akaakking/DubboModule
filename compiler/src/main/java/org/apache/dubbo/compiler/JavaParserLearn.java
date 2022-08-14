package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

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
            CompilationUnit cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/dubbo/dubbo-common/src/main/java/org/apache/dubbo/config/RegistryConfig.java"));
            cu.setPackageDeclaration("org.apache.dubbo.Interface");

            RemoveFileds removeFileds = new RemoveFileds();
            InterfaceMethod interfaceMethod = new InterfaceMethod();
            removeFileds.visit(cu,null);
            interfaceMethod.visit(cu,null);
            System.out.println(cu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
