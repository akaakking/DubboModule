package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/16 下午2:56
 */
public class InterfaceGenerator {
    private Generator generator;
    private String outputDir;
    private String InterfaceDir;
    private Map<String,String> name2path;
    private List<String> importPackages = new ArrayList<>();

    private FiedsModifier fiedsModifier = new FiedsModifier();
    private MethodModifier methodModifier = new MethodModifier();
    private PackageNameModifier packageNameModifier = new PackageNameModifier();


    public InterfaceGenerator(Generator generator) {
        this.generator = generator;
        this.outputDir = generator.getOutputDir();
        this.name2path = generator.getName2path();
        creatInterfaceDir();
    }

    void generateInterface(JavaClass javaClass) {

        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(this.name2path.get(javaClass.getFullyQualifiedName())));
            visit(cu,javaClass);
            save(cu,javaClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void visit(CompilationUnit cu,JavaClass javaClass) {
        packageNameModifier.visit(cu,javaClass);
        fiedsModifier.visit(cu,javaClass);
        methodModifier.visit(cu,javaClass);
    }

    private void creatInterfaceDir() {
        this.InterfaceDir = this.outputDir + "org/apache/dubbo/Interface/";
        File outputDir = new File(this.InterfaceDir);
        outputDir.mkdirs();
    }

    private class FiedsModifier extends ModifierVisitor<JavaClass> {
        // dealFields
        @Override
        public Visitable visit(FieldDeclaration n, JavaClass javaClass) {
            super.visit(n, javaClass);
            n.remove();
            return n;
        }
    }

    private class MethodModifier extends ModifierVisitor<JavaClass> {

        // dealMethods
        @Override
        public Visitable visit(MethodDeclaration n, JavaClass javaClass) {
            super.visit(n, javaClass);

            if (!n.isPublic()){
                n.remove();
                return n;
            }

            n.removeBody();

            return n;
        }

        @Override
        public Visitable visit(ConstructorDeclaration n, JavaClass arg) {
            super.visit(n, arg);
            n.remove();
            return n;
        }


        @Override
        public Visitable visit(InitializerDeclaration n, JavaClass arg) {
            super.visit(n, arg);
            n.remove();
            return n;
        }
    }

    public List<String> getImportPackages() {
        return importPackages;
    }

    private class PackageNameModifier extends ModifierVisitor<JavaClass> {
        // dealPackageName
        @Override
        public Visitable visit(PackageDeclaration n, JavaClass javaClass) {
            super.visit(n, javaClass);
            n.setName("org.apache.dubbo.Interface");
            return n;
        }
    }

    private void save(CompilationUnit cu,JavaClass javaClass) {
        String path = this.InterfaceDir + javaClass.getName() + "Interface.java";

        File file = new File(path);

        PrintWriter pw = null;

        try {
            file.createNewFile();
            pw = new PrintWriter(file);
            pw.print(cu.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }


//    private class ParamterModifier extends ModifierVisitor {
//        @Override
//        public Visitable visit(Parameter n, Object arg) {
//            System.out.println(n.getName());
//            return super.visit(n, arg);
//        }
//    }
//
//    private class MethodModifier extends ModifierVisitor {
//
//    }

}
