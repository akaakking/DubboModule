package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaAnnotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;
import com.thoughtworks.qdox.model.JavaSource;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/2 下午8:49
 */
public class Generator {
    private String sourthCodePath = "/home/wfh/tem/dubbo";
    private String outputBaseDir =  "/home/wfh/tem/dubboTem";
    private String configPath = this.outputBaseDir + "/dubbo-compiler/src/main/resources/exportpackage";
    private String skinClassOutDir = this.outputBaseDir + "/dubbo-compiler/src/main/java/";
    private final List<String> exportClasses = new ArrayList<>();

    private final JavaProjectBuilder  jpb = new JavaProjectBuilder();
    private final List<File> sourceFile = new ArrayList<>();
    private final Set<String> createdDirs = new HashSet<>();

    public void generate() {
        initEnvirenment();

        addClass();
        addPackage();
        System.out.println(this.exportClasses.size());
        expand();

        export();

        System.out.println(this.exportClasses.size());
    }


    private void export() {
        for (String exportClass : this.exportClasses) {
            String packageName = exportClass.substring(0,exportClass.lastIndexOf("."));
            String className = exportClass.substring(exportClass.lastIndexOf(".") + 1);

            String newClassPath = this.skinClassOutDir + getOutPutDir(packageName) + "/"  + className + ".java";

            String oldClassPath = this.jpb.getClassByName(exportClass).getSource().getURL().getPath();

            FileUtils.copyFile(oldClassPath,newClassPath);
        }
    }

    private String getOutPutDir(String packageName) {
        String packagePath = packageName.replaceAll("\\.","/");
        if (!this.createdDirs.contains(packagePath)) {
            creatDir(packagePath);
        }
        return packagePath;
    }

    private void creatDir(String packagePath) {
        String path = this.skinClassOutDir + packagePath;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    private void expand() {
        Set<String> extra = new HashSet<>();

        int size;

        do {
            size = this.exportClasses.size();

            for (String exportClass : this.exportClasses) {
                JavaClass javaClass = jpb.getClassByName(exportClass);

                for (String anImport : javaClass.getSource().getImports()) {
                    if (!this.exportClasses.contains(anImport) && !extra.contains(anImport) && anImport.startsWith("org.apache.dubbo") ) {
                        String[] strs = anImport.split("\\.");
                        if (!startsWithDigitOrUpper(strs[strs.length - 2])) {
                            extra.add(anImport);
                        }
                    }
                }
            }
            this.exportClasses.addAll(extra);
            extra.clear();
        } while (size != this.exportClasses.size());

    }

    boolean startsWithDigitOrUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    private void addPackage() {
        Set<String> exportPackageNames = FileUtils.readConfig(configPath);
        for (String exportPackageName : exportPackageNames) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackageName);
            if (javaPackage == null) {
                continue;
            }
            for (JavaClass aClass : new ArrayList<>(javaPackage.getClasses())) {
                if (!aClass.isInner()) {
                    this.exportClasses.add(aClass.getBinaryName());
                }
            }
        }
    }

    private boolean isSPIExtensionPoint(JavaClass javaClass) {
        for (JavaAnnotation annotation : javaClass.getAnnotations()) {
            if (annotation.getType().toString().equals("org.apache.dubbo.common.extension.SPI")) {
                return true;
            }
        }
        return  false;
    }

    private void addClass() {
        for (JavaClass aClass : jpb.getClasses()) {
            if (!aClass.isInner() && isSPIExtensionPoint(aClass)) {
                this.exportClasses.add(aClass.getBinaryName());
            }
        }
    }

    private void initEnvirenment() {
        copySourceCode();
        initJavaProjectBuilder();
    }



    private void copySourceCode() {
        try {
            FileUtils.copyFolder(this.sourthCodePath,this.outputBaseDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initJavaProjectBuilder() {
        inOrNot(new File(this.outputBaseDir));
        for (File file : sourceFile) {
            jpb.addSourceTree(file);
        }
    }

    private void inOrNot(File file) {
        // 过滤一部分
        if (file.isFile() || file.getName().equals("dubbo-compiler")) {
            return;
        }

        if (file.getName().startsWith("dubbo")
                || file.getName().equals("src")
                || file.getName().equals("main")) {
            for (File f : file.listFiles()) {
                inOrNot(f);
            }
        }

        if (file.getName().equals("java")) {
            sourceFile.add(file);
            return;
        }
    }
}
