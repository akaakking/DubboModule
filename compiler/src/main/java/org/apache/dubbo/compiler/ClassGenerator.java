package org.apache.dubbo.compiler;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
    private String baseDir;

    public ClassGenerator(Generator generator) {
        this.generator = generator;
        this.baseDir = generator.getOutputDir();
    }

    void generateClass(JavaClass javaClass,CompilationUnit cu) {
        ClassOrInterfaceDeclaration coid = changeClass(javaClass,cu);

        methodGenerator.visit(cu,null);

        addField(javaClass,coid);
        save(javaClass,cu);
    }

    private void addField(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        coid.addField(javaClass.getName() + "Interface","instance", Modifier.Keyword.PRIVATE);
    }

    private ClassOrInterfaceDeclaration changeClass(JavaClass  javaClass,CompilationUnit cu) {
        cu.setPackageDeclaration(javaClass.getPackageName());
        cu.addImport("org.apache.dubbo.DubboClassLoader");
        cu.addImport("org.apache.dubbo.Interface.*");
        ClassOrInterfaceDeclaration coid = cu.getInterfaceByName(javaClass.getName() + "Interface").get();

        coid.setName(javaClass.getName());
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

            blockStmt.addStatement(methodCallExpr);
            n.setBody(blockStmt);
            return n;
        }
    }

}
