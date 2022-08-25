package org.apache.dubbo.compiler;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.TypeParameter;
import com.thoughtworks.qdox.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        ClassOrInterfaceDeclaration coid = addInterface(cu,javaClass,"org.apache.dubbo.Interface",javaClass.getName() + "Interface");

        addMethods(coid,javaClass);

        this.generator.addImports(cu);

        saveInterface(cu,javaClass);

        return cu;
    }

    protected ClassOrInterfaceDeclaration addInterface(CompilationUnit cu, JavaClass javaClass, String packageName, String interfaceName) {
        cu.setPackageDeclaration(packageName);

        ClassOrInterfaceDeclaration coid = cu.addInterface(interfaceName);

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
            coid.addExtendedType(this.generator.dealType(javaType));
        }

        for (JavaType implement : javaClass.getImplements()) {
            coid.addExtendedType(this.generator.dealType(implement));
        }
    }



    public void addMethods(ClassOrInterfaceDeclaration coid,JavaClass javaClass) {
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

            if (!javaClass.isInterface()) {
                this.generator.getSourthCodeChanger().addMethod(method,parserMethodDeclaration);

            }
        }
    }


    void saveInterface(CompilationUnit cu,JavaClass javaClass) {
        this.generator.saveContent(cu.toString(),this.interfaceDir + javaClass.getName() + "Interface.java");
    }

    private void createInterfaceDir() {
        this.interfaceDir = this.generator.getInterfaceOutPutDir() + "org/apache/dubbo/Interface/";

        File file = new File(this.interfaceDir);

        file.mkdirs();
    }
}

/*
1. 用javaclass做数据支撑，用javaparser生成相关
2.
 */
