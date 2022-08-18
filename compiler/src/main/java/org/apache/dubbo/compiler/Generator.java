package org.apache.dubbo.compiler;



import com.github.javaparser.ast.CompilationUnit;
import com.google.common.collect.Sets;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
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
    private final static String EXTRA_EXPORT_INFO_PATH = "/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfos";
    private final static String DIRECT_EXPORT_CLASS_PATH = "/home/wfh/DubboModule/compiler/src/main/resources/directExportClasses";


    private String projectBasePath = PROJECT_BASE_PATH;
    private String outputDir = OUTPUT_DIR;
    private String exportInfoPath = EXPORT_INFO_PATH;
    private String extraExportInfoPath = EXTRA_EXPORT_INFO_PATH;
    private String directExportClassPath = DIRECT_EXPORT_CLASS_PATH;

    private  Set<String> exportClasses;
    private Set<String> extraExports = new HashSet<>();
    private Set<File> sourceFile = new HashSet<>();
    private Map<String,String> name2path = new HashMap<>();
    private Set<String> directExportclasses = new HashSet<>();
    private InterfaceGenerator interfaceGenerator;
    private ClassGenerator classGenerator;

    @Test
    public void testGen() {
        generate();
    }

    public void generate() {
        initEnvirenment();
        initNamePathMap();
        Set<String> exportPackages = getExportPackages();
        interfaceGenerator = new InterfaceGenerator(this);
        classGenerator = new ClassGenerator(this);
        classGenerator.setInterfaceGenerator(interfaceGenerator);

        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            Collection<JavaClass> javaClasses0 = javaPackage.getClasses();

            List<JavaClass> javaClasses = new LinkedList<>(javaClasses0);

            for (JavaClass javaClass : javaClasses) {
                dealClass(javaClass);
            }
        }
        dealExtraExport();
        saveDirectExportInfo();
    }

    private void dealExtraExport() {
        Set<String> s1;
        Set<String> s2 = new HashSet<>();

        while (!(s1 = Sets.difference(this.extraExports,s2)).isEmpty()) {
            s2 = new HashSet<>(this.extraExports);
            s1 = new HashSet<>(s1);
            for (String s : s1) {
                JavaClass javaClass = jpb.getClassByName(s);
                dealClass(javaClass);
            }
        }

        saveExtraExportInfo();
    }

    private void save(Set<String> saveList,String path) {
        File file = new File(path);
        PrintWriter printWriter = null;
        try {
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            printWriter = new PrintWriter(out);
            for (String extraExport : saveList) {
                printWriter.println(extraExport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    private void saveExtraExportInfo() {
        save(this.extraExports,this.extraExportInfoPath);
    }

    private void saveDirectExportInfo() {
        save(this.directExportclasses,this.directExportClassPath);
    }

    private void dealClass(JavaClass javaClass) {
        if (javaClass.isEnum()) {
            directExport(javaClass);
            return;
        }

        if (javaClass.isAnnotation()) {
            directExport(javaClass);
            return;
        }

        if (javaClass.isInner()) {
            //todo
            return;
        }

        if (javaClass.isPublic()) {
            CompilationUnit cu = interfaceGenerator.generateInterface(javaClass);
            classGenerator.generateClass(javaClass,cu);
        }
    }

    private void directExport(JavaClass javaClass) {
        String path = this.name2path.get(javaClass.getFullyQualifiedName());
        File file = new File(path);
        File outFile = new File(this.outputDir + javaClass.getFullyQualifiedName().replaceAll("\\.", "/") + ".java");

        if (!outFile.exists()) {
            this.classGenerator.createDir(javaClass);
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        OutputStream out = null;
        try {
            is = new FileInputStream(file);
            out = new FileOutputStream(outFile);
            transfer(is,out);
            this.directExportclasses.add(javaClass.getFullyQualifiedName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void transfer(InputStream is, OutputStream out) throws IOException {
        int read;
        byte[] buffer = new byte[1 << 13];
        while ((read = is.read(buffer)) >= 0) {
            out.write(buffer,0,read);
        }
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
