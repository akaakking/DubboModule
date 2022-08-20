package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
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
    private AbstractGenerator generator;
    private String interfaceDir;

    public InterfaceGenerator(AbstractGenerator generator) {
        this.generator = generator;
        createInterfaceDir();
    }

    CompilationUnit generateInterface(JavaClass javaClass) {
        CompilationUnit cu = new CompilationUnit();

        ClassOrInterfaceDeclaration coid = addClass(cu,javaClass);

        addMethods(coid,javaClass);

        this.generator.addImports(cu);

        saveInterface(cu,javaClass);

        return cu;
    }

    private ClassOrInterfaceDeclaration addClass(CompilationUnit cu, JavaClass javaClass) {
        cu.setPackageDeclaration("org.apache.dubbo.Interface");

        ClassOrInterfaceDeclaration coid = cu.addInterface(javaClass.getName() + "Interface");
        coid.setInterface(true);

        // deal class generic
        dealClassGeneric(coid,javaClass);

        addImpls(coid,javaClass);

        return coid;
    }

    private void dealClassGeneric(ClassOrInterfaceDeclaration coid,JavaClass javaClass) {
        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
            TypeParameter parserTypeParameter = this.generator.stuffTypeParameter(typeParameter);
            coid.addTypeParameter(parserTypeParameter);
        }
    }

    private void addImpls(ClassOrInterfaceDeclaration coid, JavaClass javaClass) {
        JavaType javaType = javaClass.getSuperClass();
        if (javaType != null && !javaType.getFullyQualifiedName().equals("java.lang.Object")) {
            if (this.generator.checkName(javaType.getBinaryName())) {
                coid.addExtendedType(this.generator.addInterface(this.generator.shortName(javaType.getGenericValue())));
            } else {
                coid.addExtendedType(javaType.getGenericValue());
            }
        }

        for (JavaType implement : javaClass.getImplements()) {
            if (this.generator.checkName(implement.getFullyQualifiedName())) {
                coid.addExtendedType(this.generator.addInterface(this.generator.shortName(implement.getGenericValue())));
            } else {
                coid.addExtendedType(implement.getGenericValue());
            }
        }
    }



    private void addMethods(ClassOrInterfaceDeclaration coid,JavaClass javaClass) {
        for (JavaMethod method : javaClass.getMethods()) {
            if (method.isStatic() || !method.isPublic()) {
                continue;
            }

            MethodDeclaration parserMethodDeclaration = coid.addMethod(method.getName());
            parserMethodDeclaration.removeBody();

            this.generator.addReturnType(parserMethodDeclaration,method);

            this.generator.addMethodGeneric(parserMethodDeclaration,method);

            for (JavaParameter parameter : method.getParameters()) {
                this.generator.addParams(parserMethodDeclaration,parameter);
            }
        }
    }


    void saveInterface(CompilationUnit cu,JavaClass javaClass) {
        this.generator.saveContent(cu.toString(),this.interfaceDir + javaClass.getName() + "Interface.java");
    }

    private void createInterfaceDir() {
        this.interfaceDir = this.generator.getOutputDir() + "org/apache/dubbo/Interface/";

        File file = new File(this.interfaceDir);

        file.mkdirs();
    }
}

/*
1. 用javaclass做数据支撑，用javaparser生成相关
2.
 */
