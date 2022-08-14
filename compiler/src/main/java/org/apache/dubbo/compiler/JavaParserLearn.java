package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
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
    public void ModifierVisitorTest() {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/compiler/src/main/java/org/apache/dubbo/compiler/Parameter.java"));
            ModifierVisitor visitor = new MethodModefile();
            visitor.visit(cu,null);
            System.out.println(cu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void MethodNamePrinterTest() {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/dubbo/dubbo-remoting/dubbo-remoting-api/src/main/java/org/apache/dubbo/remoting/zookeeper/AbstractZookeeperClient.java"));

            VoidVisitor visitor = new MethodNamePrinter();
            visitor.visit(cu,null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private class MethodNamePrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            System.out.println(n.getName());
        }
    }

    private class MethodModefile extends ModifierVisitor<Void> {

        @Override
        public Visitable visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
//            return n.removeBody();
            n.remove();
            return n;
        }
    }

}
