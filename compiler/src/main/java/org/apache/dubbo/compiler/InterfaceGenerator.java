package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaType;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    CompilationUnit generateInterface(JavaClass javaClass) {
        CompilationUnit cu = null;

        try {
            cu = StaticJavaParser.parse(new File(this.name2path.get(javaClass.getFullyQualifiedName())));
            visit(cu,javaClass);
            save(cu,javaClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        importPackages.clear();

        return cu;
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

    private void addImport(Set<String> importPackages, JavaClass javaClass) {
        if (javaClass.getFullyQualifiedName().startsWith("org.apache.dubbo")) {
            importPackages.add("org.apache.dubbo.Interface." + javaClass.getName() + "Interface");
        }

        if (javaClass.isPrimitive()) {
            return;
        }

        if (javaClass.getFullyQualifiedName().startsWith("java.lang")) {
            return;
        }

        if (javaClass.getName().length() == 1) {
            return;
        }

        importPackages.add(javaClass.getFullyQualifiedName());
    }

    private String addInterface(String s) {
        if (!s.startsWith("org.apache.dubbo")) {
            return shortName(s);
        }

        if (isPrimitive(s)) {
            return s;
        }

        if (s.length() == 1) {
            return s;
        }

        if (!this.generator.getExportClasses().contains(s)) {
            this.generator.getExtraExports().add(s);
        }

        return shortName(s) + "Interface";
    }

    boolean isPrimitive(String name)
    {
        return "void".equals( name ) || "boolean".equals( name ) || "byte".equals( name ) || "char".equals( name )
                || "short".equals( name ) || "int".equals( name ) || "long".equals( name ) || "float".equals( name )
                || "double".equals( name );
    }

    String shortName(String oldName) {

        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
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
            n.setAbstract(false);


            return n;
        }

        @Override
        public Visitable visit(ConstructorDeclaration n, JavaClass arg) {
            super.visit(n, arg);
            n.remove();
            return n;
        }

        @Override
        public Visitable visit(ClassOrInterfaceDeclaration n, JavaClass arg) {
            super.visit(n, arg);
            n.setInterface(true);
            n.setName(n.getName() + "Interface");
            n.setAbstract(false);

            // TODO
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

    String getFullyName() {
        return null;
    }

}

/*
1. 用javaclass做数据支撑，用javaparser生成相关
2.
 */
