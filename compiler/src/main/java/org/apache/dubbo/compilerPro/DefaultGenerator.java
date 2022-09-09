package org.apache.dubbo.compilerPro;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.thoughtworks.qdox.model.JavaClass;
import org.apache.dubbo.compiler.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/9 下午12:00
 */
public class DefaultGenerator extends AbstactGenerator{
    private String configPath = "/home/wfh/tem/dubbo/dubbo-compiler/src/main/resources/exportpackage";

    private String classOutPutDir = targetPath +  "/dubbo-compiler/src/main/java/";
    private ClassGenerator classGenerator;
    private InterfaceGenerator interfaceGenerator;
    private SourthCodeChanger sourthCodeChanger;

    public DefaultGenerator() {
        interfaceGenerator = new InterfaceGenerator(this);
    }

    @Override
    protected Set<String> provideExportPackagesInfo() {
        return FileUtils.readConfig(configPath);
    }

    @Override
    protected Set<JavaClass> provideExportClassesInfo() {
        return null;
    }

    @Override
    protected void dealEnum(JavaClass javaClass) {
    }

    @Override
    protected void dealClass(JavaClass javaClass) {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(javaClass.getSource().getURL().getPath()));
            this.interfaceGenerator.generateInterface(cu,javaClass.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void dealAnnotation(JavaClass javaClass) {
    }

    @Override
    protected void dealInterface(JavaClass javaClass) {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(javaClass.getSource().getURL().getPath()));
            this.interfaceGenerator.generateInterface(cu,javaClass.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
