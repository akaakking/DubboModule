package org.apache.dubbo.compilerPro;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;
import org.apache.dubbo.compiler.FileUtils;

import java.io.File;
import java.util.*;

/**
 * 对于源码的修改主要修改以下部分
 * 1. 参数传进来的interface要强制转换为非interface,主要是考虑有可能会调用interface没有的方法
 * 2. 内部调用由于方法的返回值更改所以要强制类型转换。这些都好弄，
 */
public abstract class AbstactGenerator {
    private String projectBase    = "/home/wfh/tem/dubbo";
    private String javaFilesBase  = "/home/wfh/DubboModule/java";
    private String targetPath     = "/home/wfh/tem/dubboTem";

    private final List<File> javafiles = new ArrayList<>();
    private final JavaProjectBuilder JPB = new JavaProjectBuilder();
    private final Set<JavaClass> exportClassesJ = new HashSet<>();
    private final Set<String> exportClassesS = new HashSet<>();

    public void generate() throws Exception {
        initEnvironment();
    }

    private void initEnvironment() throws Exception {
        FileUtils.copyFolder(projectBase,targetPath);
        initJPB();
        initSymbolResolver();

        Set<String> exportPackagesInfo = provideExportPackagesInfo();
        Set<JavaClass> exportClassesInfo = provideExportClassesInfo();
        addToExportClasses(exportPackagesInfo,exportClassesInfo);

    }

    protected abstract Set<String> provideExportPackagesInfo();
    protected abstract Set<JavaClass> provideExportClassesInfo();

    public void addToExportClasses(Set<String> exportPackagesInfo,Set<JavaClass> exportClassesInfo) {
        if (exportPackagesInfo != null) {
            exportPackagesInfo.forEach(packageName -> {
                JavaPackage javaPackage = JPB.getPackageByName(packageName);
                Collection<JavaClass> javaClasses0 = javaPackage.getClasses();
                Collection<JavaClass> javaClasses = new HashSet<>(javaClasses0);
                javaClasses.forEach(javaClass -> {
                    if (javaClass.getNestedClasses().isEmpty() && !javaClass.isInner()) {
                        exportClassesJ.add(javaClass);
                        //  这里有点不太确定在jps中是..(FullyQuanlified) 还是$(Binray) ,
                        exportClassesS.add(javaClass.getFullyQualifiedName());
                    }
                });
            });
        }

        if (exportClassesInfo != null) {
            exportClassesJ.addAll(exportClassesInfo);
        }
    }

    public void initSymbolResolver() {
        group();
        TypeSolver solver = new JavaParserTypeSolver(javaFilesBase);
        TypeSolver typeSolver = new ReflectionTypeSolver();
        TypeSolver combine = new CombinedTypeSolver(solver,typeSolver);

        StaticJavaParser.getConfiguration().setSymbolResolver(new JavaSymbolSolver(combine));
    }

    public void group() {
        javafiles.forEach(file -> {
            try {
                FileUtils.copyFolder(file.getAbsolutePath(),javaFilesBase);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void initJPB() {
        File baseFile = new File(this.projectBase);
        inOrNot(baseFile);
    }

    public void inOrNot(File file) {
        if (file.getName().equals("java")) {
            this.javafiles.add(file);
            return;
        } else if (file.getName().equals("test") || file.getName().equals("resources")) {
            return;
        }

        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                inOrNot(f);
            }
        }
    }
}
