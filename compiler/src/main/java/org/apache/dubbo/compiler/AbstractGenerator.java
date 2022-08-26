package org.apache.dubbo.compiler;



import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.google.common.collect.Sets;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;

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

    protected String sourthCodePath;
    protected String outputBaseDir;
    // /.../java/
    protected String interfaceOutPutDir;
    // /.../java/
    protected String classOutPutDir;
    protected String extraExportInfoPath;
    protected String directExportClassPath;

    protected final Set<String> EIASet = new HashSet<>();
    protected final Set<String> exportClasses = new HashSet<>();
    private final Set<String> extraExports = new HashSet<>();
    private final Set<File> sourceFile = new HashSet<>();
    private final Map<String,String> name2path = new HashMap<>();
    protected final Set<String> directExportclasses = new HashSet<>();
    protected final List<String> importList = new ArrayList<>();
    protected InterfaceGenerator interfaceGenerator;
    protected ClassGenerator classGenerator;
    protected SourthCodeChanger sourthCodeChanger;
    /**
     * sourthCodeBasePath /x/x/x/dubbo
     * classOutPutDir     /x/x/x/src/main/java/
     */
    public AbstractGenerator() {
    }

    protected abstract Set<String> provideExportClasses();
    protected abstract Set<String> provideExportPackages();

    public void generate() {
        initEnvirenment();

        // get all need to export class
        Set<String> exportPackages = provideExportPackages();
        addExportPackages(exportPackages);
        Set<String> exportClasses = provideExportClasses();
        addExportClasses(exportClasses);

        classGenerator = new ClassGenerator(this);
        interfaceGenerator = new InterfaceGenerator(this);

        dealExportClasses();

        // 额外暴露和直接暴露都应该被记录，将来做过滤。
        dealExtraExport();

        saveDirectExportInfo();

        System.out.println(this.extraExports.size());
    }

    public Map<String, String> getName2path() {
        return name2path;
    }

    public SourthCodeChanger getSourthCodeChanger() {
        return sourthCodeChanger;
    }



    private void dealExportClasses() {
        if (exportClasses == null) {
            return;
        }

        for (String exportClass : exportClasses) {
            JavaClass javaClass = jpb.getClassByName(exportClass);
            dealJavaClass(javaClass);
        }
    }

    void addMethodGeneric(MethodDeclaration parserMethodDeclaration, JavaMethod method) {
        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : method.getTypeParameters()) {
            TypeParameter parserTypeParameter = stuffTypeParameter(typeParameter);
            parserMethodDeclaration.addTypeParameter(parserTypeParameter);
        }
    }


    // todo xiangyinggaibian
    private void dealExtraExport() {
        Set<String> s1;
        Set<String> s2 = new HashSet<>();

        while (!(s1 = Sets.difference(this.extraExports,s2)).isEmpty()) {
            s2 = new HashSet<>(this.extraExports);
            s1 = new HashSet<>(s1);
            for (String s : s1) {
                JavaClass javaClass = jpb.getClassByName(s);
                dealJavaClass(javaClass);
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
        if (!isPrimitive(removeBrackets(javaParameter.getFullyQualifiedName()))) {
            this.importList.add(removeBrackets(javaParameter.getFullyQualifiedName()));
        }
        Parameter parameter = new Parameter();
        parameter.setName(javaParameter.getName());
        parameter.setType(dealType(javaParameter.getType()));

        parserMethodDeclaration.addParameter(parameter);
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

    void addReturnType(MethodDeclaration parserMethodDeclaration,JavaMethod method) {
        if (method.getReturns().isVoid()) {
            return;
        }

        JavaType javaType = method.getReturnType();
        parserMethodDeclaration.setType(dealType(javaType));
    }

    void addImports(CompilationUnit cu) {
        for (String importName : this.importList) {
            cu.addImport(removeBrackets(importName));
        }
    }

    public String getInterfaceOutPutDir() {
        return interfaceOutPutDir;
    }

    public String getClassOutPutDir() {
        return classOutPutDir;
    }

    void saveContent(String content, String outpath) {
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

    public void setSourthCodePath(String sourthCodePath) {
        this.sourthCodePath = sourthCodePath;
    }

    public void setOutputBaseDir(String outputBaseDir) {
        this.outputBaseDir = outputBaseDir;
    }

    public void setInterfaceOutPutDir(String interfaceOutPutDir) {
        this.interfaceOutPutDir = interfaceOutPutDir;
    }

    public void setClassOutPutDir(String classOutPutDir) {
        this.classOutPutDir = classOutPutDir;
    }

    public void setExtraExportInfoPath(String extraExportInfoPath) {
        this.extraExportInfoPath = extraExportInfoPath;
    }

    public void setDirectExportClassPath(String directExportClassPath) {
        this.directExportClassPath = directExportClassPath;
    }

    TypeParameter stuffTypeParameter(JavaTypeVariable<JavaGenericDeclaration> typeParameter) {
        TypeParameter parserTypeParameter = new TypeParameter();
        parserTypeParameter.setName(typeParameter.getName());

        if (typeParameter.getBounds() != null) {
            NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
            for (JavaType bound : typeParameter.getBounds()) {
                ClassOrInterfaceType coit = new ClassOrInterfaceType();
                coit.setName(dealType(bound));
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
        return checkName(javaClass.getBinaryName());
    }

    // 外部来的有可能有相关问题
    String shortName(String oldName) {
        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
    }

    // 对外边的类做注解有没有意义？，我觉得直接暴露的是有意义的，但是直接暴露的基本没有。
    // 总的来讲又回到了那个问题，接口暴露怎么设计。
    // 接口的话可不可以这样，内外都一样，即参数都是Interface
    //
    void copyAnnotationToMethod(JavaMethod javaMethod,MethodDeclaration methodDeclaration) {
        for (JavaAnnotation annotation : javaMethod.getAnnotations()) {
            if (annotation.getType().toString().equals("java.lang.Override")) {
                continue;
            }

            NormalAnnotationExpr normalAnnotationExpr =  new NormalAnnotationExpr();
            copyAnnotation(annotation,normalAnnotationExpr);
            methodDeclaration.addAnnotation(normalAnnotationExpr);
        }
    }

    void checkClassAnnotation(JavaClass javaClass) {
        for (JavaAnnotation annotation : javaClass.getAnnotations()) {
            checkName(annotation.getType().toString());
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
        this.importList.add(javaAnnotation.getType().toString());

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

    // 检查全限定名并做相应处理 不加[ < 在包内的话返回true。
    // 检查要不要加interface,不是在包内就要加的。
    boolean checkName(String name) {
        removeBrackets(name);

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

            if (EIASet.contains(name)) {
                // EIASet代表直接暴露不改变名字
                this.importList.add(name);
                return false;
            }

            this.importList.add("org.apache.dubbo.Interface." + name.substring(name.lastIndexOf(".") + 1) + "Interface");

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

    public String dealType(JavaType javaType) {
        return dealType(javaType.getGenericFullyQualifiedName(),javaType.getGenericValue());
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
    protected abstract void dealPublicClass(JavaClass javaClass);
    protected abstract void dealPublicInterface(JavaClass javaClass);

    private void dealJavaClass(JavaClass javaClass) {
        // first
        if (javaClass.isInner()) {
            dealInnerClass(javaClass);
            return;
        }

        // second
        if (javaClass.isEnum()) {
            dealEnum(javaClass);
            return;
        }

        // last
        if (javaClass.isAnnotation()) {
            dealAnnotation(javaClass);
            return;
        }

        if (javaClass.isInterface() && javaClass.isPublic()) {
            dealPublicInterface(javaClass);
            return;
        }

        if (javaClass.isPublic()) {
            dealPublicClass(javaClass);
        }
        this.importList.clear();
    }



    // 要放在外边
    protected void directExport(JavaClass javaClass) {
        this.classGenerator.checkDirExists(javaClass);
        String path = this.name2path.get(javaClass.getBinaryName());
        File file = new File(path);
        File outFile = new File(this.classOutPutDir + javaClass.getFullyQualifiedName().replaceAll("\\.", "/") + ".java");

        try {
            outFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
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

    String dealType(String genericFullName,String genericValue) {
        String brackets = "";

        // 没有泛型不做处理
        if (!genericValue.contains("<")) {
            if (checkName(genericFullName)) {
                return addInterface(shortName(genericValue));
            } else {
                return shortName(genericValue);
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
                if (checkName(s1)) {
                    suffixs.add("Interface");
                } else {
                    suffixs.add("");
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

    // 求出最小非负
    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] >= 0  && nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    private void addExportPackages(Set<String> exportPackages) {
        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            if (javaPackage != null) {
                for (JavaClass aClass : javaPackage.getClasses()) {
                    this.exportClasses.add(aClass.getBinaryName());
                }
            }
        }
    }

    private void addExportClasses(Set<String> exportClasses) {
        if (exportClasses == null) {
            return;
        }
        this.exportClasses.addAll(exportClasses);
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
        copySourceCode();
        initJavaProjectBuilder();
        initNamePathMap();
        initEIASet();
    }

    // sourthcodepath outputbasepath
    private void copySourceCode() {
        try {
            FileUtils.copyFolder(this.sourthCodePath,this.outputBaseDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initEIASet() {
        for (JavaClass aClass : jpb.getClasses()) {
            if (aClass.isEnum() || aClass.isInterface() || aClass.isAnnotation()) {
                this.EIASet.add(aClass.getFullyQualifiedName());
            }
        }
    }

// 倒是可以作为一个算法题写一写

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

//FileSystemServiceDiscovery.java
