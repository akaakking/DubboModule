package org.apache.dubbo.compiler;


import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import com.thoughtworks.qdox.model.impl.DefaultJavaParameterizedType;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/16 下午2:56
 */
public class Generator {
    private final static JavaProjectBuilder jpb = new JavaProjectBuilder();

    private final static String PROJECT_BASE_PATH    = "/home/wfh/DubboModule/dubbo";
    private final static String OUTPUT_DIR           = "/home/wfh/DubboModule/compiler/src/main/java/";
    private final static String EXPORT_INFO_PATH     = "/home/wfh/DubboModule/compiler/src/main/resources/exportpackage";


    private String projectBasePath = PROJECT_BASE_PATH;
    private String outputDir = OUTPUT_DIR;
    private String exportInfoPath = EXPORT_INFO_PATH;


    private  Set<String> exportClasses;
    private Set<String> extraExports = new HashSet<>();
    private Set<File> sourceFile = new HashSet<>();
    private Map<String,String> name2path = new HashMap<>();


    static JavaProjectBuilder getJpb() {
        return jpb;
    }

    @Test
    public void testGen() {
//        try {
//            CompilationUnit cu = StaticJavaParser.parse(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/ConfigScopeModelInitializer.java"));
//
//            ClassOrInterfaceDeclaration cid = new ClassOrInterfaceDeclaration();
//
//            JavaClass javaClass;
//            javaClass.getMethodBySignature();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        generate();
    }

    // 先找办法不行的话就依托javaclass的数据用javaparser生成



    public void generate() {
        initEnvirenment();
        initNamePathMap();
        Set<String> exportPackages = getExportPackages();
        InterfaceGenerator interfaceGenerator = new InterfaceGenerator(this);
        ClassGenerator classGenerator = new ClassGenerator(this);

        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            Collection<JavaClass> javaClasses0 = javaPackage.getClasses();

            List<JavaClass> javaClasses = new LinkedList<>(javaClasses0);

            for (JavaClass javaClass : javaClasses) {
                if (javaClass.isEnum()) {
                    //todo
                    continue;
                }

                if (javaClass.isAnnotation()) {
                    //todo
                    continue;
                }

                if (javaClass.isInner()) {
                    //todo
                    continue;
                }

                if (javaClass.isPublic()) {
                    interfaceGenerator.generateInterface(javaClass);
//                classGenerator.generateClass(javaClass);
                }
            }
        }
    }

    public Map<String, String> getName2path() {
        return name2path;
    }

    public void setName2path(Map<String, String> name2path) {
        this.name2path = name2path;
    }

    public Set<String> getExportPackages() {
        Set<String> exportPackages = new HashSet<>();

        File file = new File(exportInfoPath);

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String packageName;
            while ((packageName = bufferedReader.readLine()) != null) {
                if (jpb.getPackageByName(packageName) != null) {
                    exportPackages.add(packageName);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        exportClasses = getExportClasses(exportPackages);

        return exportPackages;
    }

    public Set<String> getExportClasses() {
        return exportClasses;
    }

    public Set<String> getExtraExports() {
        return extraExports;
    }

    private Set<String> getExportClasses(Set<String> exportPackages) {
        Set<String> exportClasses = new HashSet<>();
        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);
            for (JavaClass aClass : javaPackage.getClasses()) {
                exportClasses.add(aClass.getFullyQualifiedName());
            }
        }

        return exportClasses;
    }

    private void initEnvirenment() {
        initJavaProjectBuilder();
        initNamePathMap();
    }

    private void initNamePathMap() {
        for (File file : sourceFile) {
            memory(file);
        }
    }

    private void memory(File file) {
        if (file.isFile()) {
            name2path.put(getPackageName(file),file.getAbsolutePath());
            return;
        }

        for (File f : file.listFiles()) {
            memory(f);
        }
    }

    private String getPackageName(File file) {
        String fileName = file.getAbsolutePath();
        return fileName.substring(fileName.lastIndexOf("java/") + "java/".length(),fileName.lastIndexOf(".java"))
                .replaceAll("/",".");
    }
// 倒是可以作为一个算法题写一写

    private void initJavaProjectBuilder() {
        inOrNot(new File(this.projectBasePath));
        for (File file : sourceFile) {
            jpb.addSourceTree(file);
        }
    }

    private void inOrNot(File file) {
        // 过滤一部分
        if (file.isFile()) {
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

    public String getProjectBasePath() {
        return projectBasePath;
    }

    public void setProjectBasePath(String projectBasePath) {
        this.projectBasePath = projectBasePath;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
}
