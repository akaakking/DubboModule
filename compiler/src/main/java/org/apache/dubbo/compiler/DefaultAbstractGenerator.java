package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.thoughtworks.qdox.model.JavaAnnotation;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/19 下午12:30
 */
public class DefaultAbstractGenerator extends AbstractGenerator {
    private String exportPackageInfoPath;

    public DefaultAbstractGenerator() {
        this.sourthCodeChanger = new SourthCodeChanger(this);
    }

    // 提供不方便用包表示的javaclasses
    @Override
    protected Set<String> provideExportClasses() {
        Set<String> classNames = new HashSet<>();
        for (JavaClass aClass : jpb.getClasses()) {
            if (aClass.isInterface()) {
                if (isSPIExtensionPoint(aClass)) {
                    classNames.add(aClass.getBinaryName());
                }
            }
        }

        return classNames;
    }

    @Override
    protected Set<String> provideExportPackages() {
        return readConfig(this.exportPackageInfoPath);
    }

    @Override
    protected void dealInnerClass(JavaClass javaClass) {
        // TODO
    }

    @Override
    protected void dealAnnotation(JavaClass javaClass) {
        directExport(javaClass);
    }

    @Override
    protected void dealEnum(JavaClass javaClass) {
        directExport(javaClass);
    }

    @Override
    protected void dealPublicClass(JavaClass javaClass) {
        CompilationUnit cu = interfaceGenerator.generateInterface(javaClass);
        ClassOrInterfaceDeclaration newClass = classGenerator.generateClass(javaClass,cu);
        this.sourthCodeChanger.setNewClass(newClass);
        this.sourthCodeChanger.changeSourceCode(javaClass);
    }

    // class和interface的生成策略不同在class会先生成一个interface。在生成class，而interface不会
    // directexport主要存将来DubboclassLoad要委托给appclassLoad加载的Dubbo内部的类。、
    // 分为三部分
    // 1. interface
    // 2. 直接暴露的Annotation
    // 3. 直接暴露的Enum
    // 4. 间接直接暴露的Interface
    @Override
    protected void dealPublicInterface(JavaClass javaClass) {
        String classPath = getName2path().get(javaClass.getFullyQualifiedName());
        CompilationUnit cu;
        try {
            cu = StaticJavaParser.parse(new File(classPath));
            ClassOrInterfaceDeclaration coid = cu.getInterfaceByName(javaClass.getName()).get();

            coid.getMethods().stream().forEach(m -> m.remove());

            this.interfaceGenerator.addMethods(coid,javaClass);

            this.addImports(cu);

            saveInterface(cu,javaClass.getFullyQualifiedName(),javaClass);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveInterface(CompilationUnit cu,String className,JavaClass javaClass) {
        this.classGenerator.checkDirExists(javaClass);

        String path = this.classOutPutDir + className.replaceAll("\\.","/") + ".java";
        this.directExportclasses.add(className);
        FileUtils.saveContent(cu.toString(),path);
    }

    public void setExportPackageInfoPath(String exportPackageInfoPath) {
        this.exportPackageInfoPath = exportPackageInfoPath;
    }

    public boolean isSPIExtensionPoint(JavaClass javaClass) {
        for (JavaAnnotation annotation : javaClass.getAnnotations()) {
            if (annotation.getType().toString().equals("org.apache.dubbo.common.extension.SPI")) {
                return true;
            }
        }
        return  false;
    }
}