package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.model.*;
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
    // TODO 未清空
    private List<String> importList = new ArrayList<>();
    private String interfaceDir;

    public InterfaceGenerator(Generator generator) {
        this.generator = generator;
        createInterfaceDir();
    }

    CompilationUnit generateInterface(JavaClass javaClass) {
        CompilationUnit cu = new CompilationUnit();
        ClassOrInterfaceDeclaration coid = addClass(cu,javaClass);

        addMethods(coid,javaClass);

        addImports(cu);
        save(cu,javaClass);

        importList.clear();
        return cu;
    }


    private ClassOrInterfaceDeclaration addClass(CompilationUnit cu, JavaClass javaClass) {
        cu.setPackageDeclaration("org.apache.dubbo.Interface");

        ClassOrInterfaceDeclaration coid = cu.addInterface(javaClass.getName() + "Interface");
        coid.setInterface(true);

        // deal class generic
        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
            TypeParameter parserTypeParameter = new TypeParameter();
            parserTypeParameter.setName(typeParameter.getName());

            if (typeParameter.getBounds() != null) {
                NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
                for (JavaType bound : typeParameter.getBounds()) {
                    ClassOrInterfaceType coit = new ClassOrInterfaceType();
                    if (checkName(bound.getFullyQualifiedName())) {
                        coit.setName(addInterface(shortName(bound.getGenericValue())));
                    } else {
                        coit.setName(bound.getGenericValue());
                    }
                    nodeList.add(coit);
                }

                if (!nodeList.isEmpty()) {
                    parserTypeParameter.setTypeBound(nodeList);
                }
            }

            coid.addTypeParameter(parserTypeParameter);
        }

        addImpls(coid,javaClass);

        return coid;
    }

    private void addImpls(ClassOrInterfaceDeclaration coid, JavaClass javaClass) {
        JavaType javaType = javaClass.getSuperClass();
        if (javaType != null && !javaType.getFullyQualifiedName().equals("java.lang.Object")) {
            if (checkName(javaType.getFullyQualifiedName())) {
                coid.addImplementedType(addInterface(shortName(javaType.getGenericValue())));
            } else {
                coid.addImplementedType(javaType.getGenericValue());
            }
        }

        for (JavaType implement : javaClass.getImplements()) {
            if (checkName(implement.getFullyQualifiedName())) {
                coid.addImplementedType(addInterface(shortName(implement.getGenericValue())));
            } else {
                coid.addImplementedType(implement.getGenericValue());
            }
        }
    }

    private void addImports(CompilationUnit cu) {
        for (String importName : this.importList) {
            cu.addImport(importName);
        }
    }

    private void addMethods(ClassOrInterfaceDeclaration coid,JavaClass javaClass) {
        for (JavaMethod method : javaClass.getMethods()) {
            MethodDeclaration parserMethodDeclaration = coid.addMethod(method.getName());
            parserMethodDeclaration.removeBody();

            JavaType javaType = method.getReturnType();

            if (checkName(javaType.getBinaryName())) {
                parserMethodDeclaration.setType(addInterface(shortName(javaType.getGenericValue())));
            } else {
                parserMethodDeclaration.setType(javaType.getGenericValue());
            }

            for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : method.getTypeParameters()) {
                TypeParameter parserTypeParameter = new TypeParameter();
                parserTypeParameter.setName(typeParameter.getName());

                if (typeParameter.getBounds() != null) {
                    NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
                    for (JavaType bound : typeParameter.getBounds()) {
                        ClassOrInterfaceType coit = new ClassOrInterfaceType();
                        if (checkName(bound.getFullyQualifiedName())) {
                            coit.setName(addInterface(shortName(bound.getGenericValue())));
                        } else {
                            coit.setName(bound.getGenericValue());
                        }
                        nodeList.add(coit);
                    }

                    if (!nodeList.isEmpty()) {
                        parserTypeParameter.setTypeBound(nodeList);
                    }
                }

                parserMethodDeclaration.addTypeParameter(parserTypeParameter);
            }


            for (JavaParameter parameter : method.getParameters()) {
                addParams(parserMethodDeclaration,parameter);
            }
        }
    }

    private void addParams(MethodDeclaration parserMethodDeclaration,JavaParameter javaParameter) {
        Parameter  parameter = new Parameter();
        parameter.setName(javaParameter.getName());

        if (checkName(javaParameter.getType().getBinaryName())) {
            parameter.setType(addInterface(shortName(javaParameter.getType().getGenericValue())));
        } else {
            parameter.setType(javaParameter.getType().getGenericValue());
        }

        parserMethodDeclaration.addParameter(parameter);
    }

    // 检查全限定名并做相应处理 不加[ < 在包内的话返回true
    private boolean checkName(String name) {
        if (isPrimitive(name) || name.startsWith("java.lang")) {
            return false;
        }

        if (name.startsWith("org.apache.dubbo") || name.startsWith("com.alibab.dubbo")) {
            // 在想要暴露的包中
            if (!this.generator.getExportClasses().contains(name)) {
                this.generator.getExtraExports().add(name);
            }

            return true;
        }

        if (name.length() == 1) {
            return false;
        }

        if (!name.contains(".")) {
            return true;
        } else {
            this.importList.add(name);
            return false;
        }
    }

    private String addInterface(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (s.contains("<")) {
            sb.insert(sb.lastIndexOf("<"),"Interface");
            return sb.toString();
        }

        if (s.contains("[")) {
            sb.insert(sb.lastIndexOf("["),"Interface");
            return sb.toString();
        }

        return s + "Interface";
    }

    boolean isPrimitive(String name) {
        return "void".equals( name ) || "boolean".equals( name ) || "byte".equals( name ) || "char".equals( name )
                || "short".equals( name ) || "int".equals( name ) || "long".equals( name ) || "float".equals( name )
                || "double".equals( name );
    }

    // 外部来的有可能有相关问题
    private String shortName(String oldName) {

        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
    }

    private void createInterfaceDir() {
        this.interfaceDir = this.generator.getOutputDir() + "org/apache/dubbo/Interface/";

        File file = new File(this.interfaceDir);

        file.mkdirs();
    }

    private void save(CompilationUnit cu,JavaClass javaClass) {
        String path = this.interfaceDir + javaClass.getName() + "Interface" + ".java";

        File file = new File(path);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.print(cu.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}

/*
1. 用javaclass做数据支撑，用javaparser生成相关
2.
 */
