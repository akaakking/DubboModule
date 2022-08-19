package org.apache.dubbo.compiler;



import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
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
public abstract class AbstractGenerator{
    protected final static JavaProjectBuilder jpb = new JavaProjectBuilder();

    public final static String PROJECT_BASE_PATH    = "/home/wfh/DubboModule/dubbo";
    public final static String OUTPUT_DIR           = "/home/wfh/DubboModule/compiler/src/main/java/";
    public final static String EXTRA_EXPORT_INFO_PATH = "/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfos";
    public final static String DIRECT_EXPORT_CLASS_PATH = "/home/wfh/DubboModule/compiler/src/main/resources/directExportClasses";

    private String projectBasePath;
    private String outputDir;
    private String extraExportInfoPath = EXTRA_EXPORT_INFO_PATH;
    private String directExportClassPath = DIRECT_EXPORT_CLASS_PATH;

    protected final Set<String> exportClasses = new HashSet<>();
    private final Set<String> extraExports = new HashSet<>();
    private final Set<File> sourceFile = new HashSet<>();
    private final Map<String,String> name2path = new HashMap<>();
    private final Set<String> directExportclasses = new HashSet<>();
    protected final List<String> importList = new ArrayList<>();
    private InterfaceGenerator interfaceGenerator;
    private ClassGenerator classGenerator;

    /**
     * sourthCodeBasePath /x/x/x/dubbo
     * classOutPutDir     /x/x/x/src/main/java/
     */
    public AbstractGenerator(String sorthCodeBasePath,String classOutPutDir) {
        this.projectBasePath = sorthCodeBasePath;
        this.outputDir = classOutPutDir;
    }

    protected abstract Set<String> provideExportClasses();
    protected abstract Set<String> provideExportPackages();

    public void generate() {
        initEnvirenment();
        initNamePathMap();

        Set<String> exportPackages = provideExportPackages();
        addExportPackages(exportPackages);
        Set<String> exportClasses = provideExportClasses();
        addExportClasses(exportClasses);

        classGenerator = new ClassGenerator(this);
        interfaceGenerator = new InterfaceGenerator(this);

        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            if (javaPackage == null) {
                continue;
            }

            Collection<JavaClass> javaClasses0 = javaPackage.getClasses();

            List<JavaClass> javaClasses = new LinkedList<>(javaClasses0);

            for (JavaClass javaClass : javaClasses) {
                dealClass(javaClass);
                this.importList.clear();
            }
        }

        dealExtraExport();
        saveDirectExportInfo();
    }

    void addMethodGeneric(MethodDeclaration parserMethodDeclaration, JavaMethod method) {
        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : method.getTypeParameters()) {
            TypeParameter parserTypeParameter = stuffTypeParameter(typeParameter);
            parserMethodDeclaration.addTypeParameter(parserTypeParameter);
        }
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
                importList.clear();
            }
        }

        saveExtraExportInfo();
    }

    protected Set<String> readConfig(String configPath) {
        Set<String> configSet = new HashSet<>();

        File file = new File(configPath);

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String config;
            while ((config = bufferedReader.readLine()) != null) {
                // 为什么当初要判断是否在包内来着？
                configSet.add(config);
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
        return configSet;
    }

    void addParams(MethodDeclaration parserMethodDeclaration,JavaParameter javaParameter) {
        Parameter parameter = new Parameter();
        parameter.setName(javaParameter.getName());

        if (checkName(javaParameter.getType().getBinaryName())) {
            parameter.setType(addInterface(shortName(javaParameter.getType().getGenericValue())));
        } else {
            parameter.setType(javaParameter.getType().getGenericValue());
        }

        parserMethodDeclaration.addParameter(parameter);
    }

    void addReturnType(MethodDeclaration parserMethodDeclaration,JavaMethod method) {
        JavaType javaType = method.getReturnType();

        if (checkName(javaType.getBinaryName()) && !method.getReturns().isEnum()) {
            parserMethodDeclaration.setType(addInterface(shortName(javaType.getGenericValue())));
        } else {
            parserMethodDeclaration.setType(javaType.getGenericValue());
            if (method.getReturns().isEnum()) {
                this.importList.add(javaType.getBinaryName());
            }
        }
    }

    void addImports(CompilationUnit cu) {
        for (String importName : this.importList) {
            cu.addImport(importName);
        }
    }

    void saveContent(String content,String outpath) {
        File file = new File(outpath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.print(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    TypeParameter stuffTypeParameter(JavaTypeVariable<JavaGenericDeclaration> typeParameter) {
        TypeParameter parserTypeParameter = new TypeParameter();
        parserTypeParameter.setName(typeParameter.getName());

        if (typeParameter.getBounds() != null) {
            NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
            for (JavaType bound : typeParameter.getBounds()) {
                ClassOrInterfaceType coit = new ClassOrInterfaceType();
                if (checkName(bound.getFullyQualifiedName())) {
                    coit.setName(addInterface(shortName(bound.getGenericValue())));
                } else {
                    coit.setName(bound.getGenericValue());
                }
                nodeList.add(coit);
            }

            if (!nodeList.isEmpty()) {
                parserTypeParameter.setTypeBound(nodeList);
            }
        }

        return parserTypeParameter;
    }


    String addInterface(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (s.contains("<")) {
            sb.insert(sb.lastIndexOf("<"),"Interface");
            return sb.toString();
        }

        if (s.contains("[")) {
            sb.insert(sb.lastIndexOf("["),"Interface");
            return sb.toString();
        }

        return s + "Interface";
    }

    boolean checkName(JavaClass javaClass) {
        if (javaClass.isEnum()) {
            this.importList.add(javaClass.getBinaryName());
            return false;
        } else{
            return checkName(javaClass.getBinaryName());
        }
    }

    // 外部来的有可能有相关问题
    String shortName(String oldName) {
        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
    }


    void copyAnnotationToMethod(JavaMethod javaMethod,MethodDeclaration methodDeclaration) {
        for (JavaAnnotation annotation : javaMethod.getAnnotations()) {
            NormalAnnotationExpr normalAnnotationExpr =  new NormalAnnotationExpr();
            copyAnnotation(annotation,normalAnnotationExpr);
            methodDeclaration.addAnnotation(normalAnnotationExpr);
        }
    }

    void copyAnnotationToClass(JavaClass javaClass,ClassOrInterfaceDeclaration coid) {
        for (JavaAnnotation annotation : javaClass.getAnnotations()) {
            NormalAnnotationExpr normalAnnotationExpr =  new NormalAnnotationExpr();
            copyAnnotation(annotation,normalAnnotationExpr);
            coid.addAnnotation(normalAnnotationExpr);
        }
    }

    void copyAnnotation(JavaAnnotation javaAnnotation, NormalAnnotationExpr annotationExpr) {

        if (javaAnnotation.getType().toString().startsWith("org.apache.dubbo")
                                || javaAnnotation.getType().toString().startsWith("com.alibaba.dubbo")) {
            if (!this.exportClasses.contains(javaAnnotation.getType().toString())) {
                this.extraExports.add(javaAnnotation.getType().toString());
            }
        }

        javaAnnotation.getPropertyMap().forEach((key,value) -> {
            annotationExpr.addPair(key,value.toString());
        });
    }


    protected void saveSet(Set<String> saveList,String path) {
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

    // 检查全限定名并做相应处理 不加[ < 在包内的话返回true
    boolean checkName(String name) {
        if (name == null) {
            return false;
        }

        if (isPrimitive(name) || name.startsWith("java.lang")) {
            if (name.startsWith("java.lang.reflect")) {
                this.importList.add(name);
            }
            return false;
        }

        if (name.startsWith("org.apache.dubbo") || name.startsWith("com.alibab.dubbo")) {
            // 在想要暴露的包中
            if (!this.exportClasses.contains(name)) {
                this.extraExports.add(name);
            }

            if (name.contains("annotation")) {
                this.importList.add(name);
                return false;
            }

            return true;
        }

        if (name.length() == 1) {
            return false;
        }

        if (!name.contains(".")) {
            return true;
        } else {
            this.importList.add(name);
            return false;
        }
    }

    boolean isPrimitive(String name) {
        return "void".equals( name ) || "boolean".equals( name ) || "byte".equals( name ) || "char".equals( name )
                || "short".equals( name ) || "int".equals( name ) || "long".equals( name ) || "float".equals( name )
                || "double".equals( name );
    }

    private void saveExtraExportInfo() {
        saveSet(this.extraExports,this.extraExportInfoPath);
    }

    private void saveDirectExportInfo() {
        saveSet(this.directExportclasses,this.directExportClassPath);
    }

    protected abstract void dealInnerClass(JavaClass javaClass);
    protected abstract void dealAnnotation(JavaClass javaClass);
    protected abstract void dealEnum(JavaClass javaClass);

    private void dealClass(JavaClass javaClass) {
        if (javaClass.isInner()) {
            dealInnerClass(javaClass);
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


        if (javaClass.isPublic()) {
            CompilationUnit cu = interfaceGenerator.generateInterface(javaClass);
            if (!javaClass.isInterface()) {
                classGenerator.generateClass(javaClass,cu);
            }
        }
    }

    protected void directExport(JavaClass javaClass) {
        String path = this.name2path.get(javaClass.getBinaryName());
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
            this.directExportclasses.add(javaClass.getBinaryName());
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


    private void addExportPackages(Set<String> exportPackages) {
        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            if (javaPackage != null) {
                for (JavaClass aClass : javaPackage.getClasses()) {
                    this.exportClasses.add(aClass.getFullyQualifiedName());
                }
            }
        }
    }

    private void addExportClasses(Set<String> exportClasses) {
        if (exportClasses == null) {
            return;
        }
        for (String exportClass : exportClasses) {
            this.exportClasses.add(exportClass);
        }
    }

    private String getPackageName(File file) {
        String fileName = file.getAbsolutePath();
        return fileName.substring(fileName.lastIndexOf("java/") + "java/".length(),fileName.lastIndexOf(".java"))
                .replaceAll("/",".");
    }

    public Set<String> getExportClasses() {
        return exportClasses;
    }

    public Set<String> getExtraExports() {
        return extraExports;
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
