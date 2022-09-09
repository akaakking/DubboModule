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
    protected String targetPath     = "/home/wfh/tem/dubboTem";

    private final List<File> javafiles = new ArrayList<>();
    private final JavaProjectBuilder JPB = new JavaProjectBuilder();
    protected final Set<JavaClass> exportClassesJ = new HashSet<>();
    protected final Set<String> exportClassesS = new HashSet<>();

    public AbstactGenerator() {
    }

    public void generate() throws Exception {
        initEnvironment();

        dealNeedExportClasses();
    }

    private void dealNeedExportClasses() {
        this.exportClassesJ.forEach(javaClass -> {
            if (javaClass.isInterface()) {
                dealInterface(javaClass);
                return;
            }

            if (javaClass.isEnum()) {
                dealEnum(javaClass);
                return;
            }

            if (javaClass.isAnnotation()) {
                dealAnnotation(javaClass);
                return;
            }

            dealClass(javaClass);
        });
    }

    // 如果不暴露返回null
    String dealType(String genericFullName,String genericValue) {
        String brackets = "";

        // 没有泛型不做处理
        if (!genericValue.contains("<")) {
            switch (checkOut(genericFullName)) {
                case INNER:    return null;
                case NOTDUBBO: return genericValue;
                case NOTINNER: return genericValue + "Interface";
            }
        }

        if (genericValue.contains("[")) {
            brackets = genericValue.substring(genericValue.indexOf("["),genericValue.lastIndexOf("]")  + 1);
            genericValue = genericValue.substring(0,genericValue.indexOf("["));
            genericFullName = genericFullName.substring(0,genericFullName.indexOf("["));
        }

        Queue<String> suffixs = new LinkedList<>(); // ? extend
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < genericFullName.length()) {
            int index1 = genericFullName.indexOf("<",i);
            int index2 = genericFullName.indexOf(">",i);
            int index3 = genericFullName.indexOf(" ",i);
            int index4 = genericFullName.indexOf(",",i);
            int index5 = genericFullName.indexOf("? extends ",i);
            int index6 = genericFullName.indexOf("? super ",i);

            int min = min(index1,index2,index3,index4,index5,index6);

            if (i == min) {
                if (i == index5) {
                    i = i + 10;
                } else if (i==index6)  {
                    i = i + 8;
                } else {
                    i = i + 1;
                }
            } else {
                String s1 = genericFullName.substring(i, min);
                switch (checkOut(s1)) {
                    case NOTDUBBO:
                        suffixs.add("");
                        break;
                    case INNER:
                        return null;
                    case NOTINNER:
                        suffixs.add("Interface");
                        break;
                }

                i = min;
                if (i == index5) {
                    i = i + 10;
                } else if (i==index6)  {
                    i = i + 8;
                } else {
                    i = i + 1;
                }
            }
        }

        i = 0;

        while (i < genericValue.length() - 1) {
            int index1 = genericValue.indexOf("<",i);
            int index2 = genericValue.indexOf(">",i);
            int index3 = genericValue.indexOf(" ",i);
            int index4 = genericValue.indexOf(",",i);
            int index5 = genericValue.indexOf("? extends ",i);
            int index6 = genericValue.indexOf("? super ",i);

            int min = min(index1,index2,index3,index4,index5,index6);

            if (i == min) {
                if (i == index5) {
                    result.append(genericValue.substring(i,i + 10));
                    i = i + 10;
                }  else if (i==index6)  {
                    result.append(genericValue.substring(i,i + 8));
                    i = i + 8;
                } else {
                    result.append(genericValue.substring(i,i + 1));
                    i = i + 1;
                }
            } else {
                String s1 = genericValue.substring(i, min);
                result.append(s1).append(suffixs.poll());
                i = min;
            }
        }

        return result.append(">").append(brackets).toString();
    }

    protected int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] >= 0  && nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    // 纯粹一点他就是为了判断，该name是否在要暴露的里边
    CheckResult checkOut(String name) {
        name = removeBrackets(name);
        if (name.startsWith("org.apache.dubbo")) {
            if (this.exportClassesS.contains(name)) {
                return CheckResult.NOTINNER;
            }
            // 不暴露
            return CheckResult.INNER;
        }
        // 非dubbo
        return CheckResult.NOTDUBBO;
    }

    String removeBrackets(String str) {
        if (str.contains("<")) {
            str = str.substring(0,str.indexOf("<"));
        }

        if (str.contains("[")) {
            str = str.substring(0,str.indexOf("["));
        }

        return str;
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
    protected abstract void dealEnum(JavaClass javaClass);
    protected abstract void dealClass(JavaClass javaClass);
    protected abstract void dealAnnotation(JavaClass javaClass);
    protected abstract void dealInterface(JavaClass javaClass);


    public String getTargetPath() {
        return targetPath;
    }

    public void addToExportClasses(Set<String> exportPackagesInfo, Set<JavaClass> exportClassesInfo) {
        if (exportPackagesInfo != null) {
            exportPackagesInfo.forEach(packageName -> {
                JavaPackage javaPackage = JPB.getPackageByName(packageName);
                if (javaPackage != null) {
                    Collection<JavaClass> javaClasses0 = javaPackage.getClasses();
                    Collection<JavaClass> javaClasses = new HashSet<>(javaClasses0);
                    javaClasses.forEach(javaClass -> {
                        if (javaClass.getNestedClasses().isEmpty() && !javaClass.isInner()) {
                            exportClassesJ.add(javaClass);
                            //  这里有点不太确定在jps中是..(FullyQuanlified) 还是$(Binray) ,
                            exportClassesS.add(javaClass.getFullyQualifiedName());
                        }
                    });
                }
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
        File baseFile = new File(this.targetPath);
        inOrNot(baseFile);
        this.javafiles.forEach(file -> {
            JPB.addSourceTree(file);
        });
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

    enum CheckResult {
        INNER,
        NOTINNER,
        NOTDUBBO
    }
}
