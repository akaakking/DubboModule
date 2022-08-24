package org.apache.dubbo.compiler;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;

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
        this.exportPackageInfoPath = exportPackageInfoPath;
        this.sourthCodeChanger = new SourthCodeChanger(this);
    }

    // 提供不方便用包表示的javaclasses
    @Override
    protected Set<String> provideExportClasses() {
        return null;
    }

    @Override
    protected Set<String> provideExportPackages() {
        return readConfig(this.exportPackageInfoPath);
    }

    @Override
    protected void dealInnerClass(JavaClass javaClass) {
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
        CompilationUnit cu = new CompilationUnit();


        ClassOrInterfaceDeclaration coid = this.interfaceGenerator.addInterface(cu,javaClass,"org.apache.dubbo.Interface",javaClass.getName() + "Interface");

        this.interfaceGenerator.addMethods(coid,javaClass);

        this.addImports(cu);

        overrideinterface(cu);
    }

    /**
     * 需要区分的是将来是有两个输出目录的。
     * 首先我们得将原来的代码copy一份这是内部的。将来嵌套在jar里   inner OutPutDir
     * 还有一份是外部的 outwardoutputdir
     * 可以就是说都做成tem的但是，这样不方便我查看。
     * 可以将direct的暴露都理解为覆盖。但其实这种内外都有一份也行。
     * 这就牵扯到对源码的修改部分。要不先把那个功能一做？
     * ok 开干
     *
     * @param cu
     */
    private void overrideinterface(CompilationUnit cu) {
        // todo cu save
    }

    public void setExportPackageInfoPath(String exportPackageInfoPath) {
        this.exportPackageInfoPath = exportPackageInfoPath;
    }
}
