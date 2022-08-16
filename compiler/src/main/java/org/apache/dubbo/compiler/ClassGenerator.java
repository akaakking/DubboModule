package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.io.IOException;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/16 上午11:08
 */
public class ClassGenerator {
    private Generator generator;
    private String baseDir;

    public ClassGenerator(Generator generator) {
        this.generator = generator;
        this.baseDir = generator.getOutputDir();
    }

    void generateClass(JavaClass javaClass) {
        File file = creatClassFile(javaClass);
        CompilationUnit cu = new CompilationUnit();
    }

    File creatClassFile(JavaClass javaClass) {
        File dir  = new File(baseDir + javaClass.getPackageName());
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File classFile = new File(baseDir + javaClass.getPackageName().replaceAll("\\.","/") + javaClass.getName());

        if (!classFile.exists()) {
            try {
                classFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return classFile;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

}
