package org.apache.dubbo.compiler;

import com.google.common.collect.Sets;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 现在解决
 * 2. 返回值，参数，泛型相关
 * 3. 接口之间继承关系
 *
 * @Author wfh
 * @Date 2022/8/14 下午6:16
 */
public class InterfaceMaker {
    private final static String TEMPLATE_SOURTH_PATH = "/home/wfh/DubboModule/compiler/src/main/resources";
    private final static String EXPORT_INFO_PATH     = "/home/wfh/DubboModule/compiler/src/main/resources/exportpackage";
    private final static String PROJECT_BASE_PATH    = "/home/wfh/DubboModule/dubbo";
    private final static String TEMPLATE_NAME        = "Interface.ftl";
    private final static String OUTPUT_DIR           = "/home/wfh/DubboModule/compiler/src/main/java";
    private final static String EXTRA_EXPORT_INFO_DIR           = "/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfo.txt";

    private String templateSourthPath = TEMPLATE_SOURTH_PATH;
    private String templateName = TEMPLATE_NAME;
    private String exportInfoPath = EXPORT_INFO_PATH;
    private String projectBasePath = PROJECT_BASE_PATH;
    private String outputDir = OUTPUT_DIR;
    // 所谓额外暴露可以理解为牵连着暴露的。即不再我们的sourthfile里边的东西，那么现在这个定位就很准确了
    private String extraExportInfoDir = EXTRA_EXPORT_INFO_DIR;

    private final List<File> sourceFile = new ArrayList<>();
    private final Set<String> extraExport = new HashSet<>();
    private  Set<String> exportClasses;
    private Template template;
    private static JavaProjectBuilder jpb;


    @Test
    public void makeTest() {
       make();
    }

    public void make() {
        initEnvirenment();

        Set<String> exportPackages = getExportPackages();

        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            Collection<JavaClass> javaClasses0 = javaPackage.getClasses();

            List<JavaClass> javaClasses = new LinkedList<>(javaClasses0);

            for (JavaClass javaClass : javaClasses) {
                if (!javaClass.isPublic()) {
                    continue;
                }

                if (javaClass.isInner()) {
                    // dealInner
                    continue;
                }

                if (javaClass.isEnum()) {
                    // dealEnum
                    continue;
                }

                if (javaClass.isAnnotation()) {
                    // dealAnnotation
                    continue;
                }

                // dealInterfaceOrClass
                Map<String,Object> root = getDataModel(javaClass);
                generateInterface(root,template);

            }
        }
        dealExtraExport();
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

    private void dealExtraExport() {
        if (extraExport.isEmpty()) {
            return;
        }

        Set<String> s1;
        Set<String> s2 = new HashSet<>();

        while (!(s1 = Sets.difference(extraExport,s2)).isEmpty()) {
            s2 = new HashSet<>(extraExport);
            s1 = new HashSet<>(s1);
            for (String s : s1) {
                JavaClass javaClass = jpb.getClassByName(s);
                generateInterface(getDataModel(javaClass),template);
            }
        }

        File file = new File(extraExportInfoDir);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream ps = null;

        try {
            ps = new PrintStream(file);
            for (String s : extraExport) {
                ps.println(s);
            }
            ps.println(extraExport.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }


    }

    @Test
    public void testForSet() {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Set<Integer> integers1 = new HashSet<>();
        integers1.add(2);
        integers1.add(4);
        integers1.add(5);
        System.out.println(Sets.difference(integers1, integers));
    }



    private void generateInterface(Map<String,Object> root,Template interfaceIemplate) {

        File file = new File(this.outputDir + root.get("className") + "Interface.java");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream os = null;

        try {
            os = new FileOutputStream(file);
            interfaceIemplate.process(root,new OutputStreamWriter(os));
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
|---root(class)
            methods
                method1
                    methodName
                    parameters
                        parameter1
                            Type
                            name
                        parameter2
                method2
                method3
            importPackages
                package1
                package2
                package3
            className
            GenericString
 */
    public Map<String, Object> getDataModel(JavaClass javaClass) {
        Map<String,Object> root = new HashMap<>();

        List<Method> methods = new ArrayList<>();
        Set<String> importPackages = new HashSet<>();
        List<String> parents = getParents(javaClass);
        String classTypeName = getClassTypeName(javaClass);


        for (JavaMethod method : javaClass.getMethods()) {
            if (!method.isPublic()) {
                continue;
            }

            Method m = new Method();
            m.setName(method.getName());
            List<Parameter> parameters = new ArrayList<>();

            m.setReturnType(getClassTypeName(method.getReturns()));
            m.setParameters(parameters);
            methods.add(m);

            addImport(importPackages,method.getReturns());

            for (JavaParameter parameter : method.getParameters()) {
                Parameter p = new Parameter();
                p.setName(parameter.getName());

                p.setType(getClassTypeName(parameter.getJavaClass()));

                parameters.add(p);
                addImport(importPackages,parameter.getJavaClass());
            }
        }

        root.put("methods",methods);
        root.put("className",javaClass.getName());
        root.put("importPackages",importPackages);
        root.put("parents",parents);
        root.put("hasSuper",!parents.isEmpty());
        root.put("classTypeName", classTypeName);

        return root;
    }

    private List<String> getParents(JavaClass javaClass) {
        List<String> parents = new ArrayList<>();

        JavaClass superClass = javaClass.getSuperJavaClass();

        if (superClass != null && !superClass.getFullyQualifiedName().startsWith("java.lang.Object")
                                && !superClass.getFullyQualifiedName().startsWith("java.lang.Enum")
                                   && !superClass.getFullyQualifiedName().startsWith("org.apache.dubbo.Interface")) {
            parents.add(getClassTypeName(superClass));
        }

        for (JavaClass anInterface : javaClass.getInterfaces()) {
            if (!anInterface.getFullyQualifiedName().startsWith("org.apache.dubbo.Interface")) {
                parents.add(getClassTypeName(anInterface));
            }
        }

        return parents;
    }

    // javaclass -> className+ 泛型相关
    private String getClassTypeName(JavaClass javaClass) {
        StringBuffer sb = new StringBuffer(addInterface(javaClass.getFullyQualifiedName()));

        if (javaClass.getTypeParameters() != null && !javaClass.getTypeParameters().isEmpty()) {
            sb.append("<");

            for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
                sb.append(typeParameter.toString());
                if (typeParameter.getBounds() != null && !typeParameter.getBounds().isEmpty()) {
                    sb.append(" extends ");
                    sb.append(addInterface(typeParameter.getBounds().get(0).toString()));
                }
                sb.append(",");
            }

            sb.delete(sb.length() -1 , sb.length());

            sb.append(">");
        }

        return sb.toString();
    }

    // todo 不在config包下，但在dubbo内
    private String addInterface(String s) {
        if (!s.startsWith("org.apache.dubbo")) {
            return shortName(s);
        }

        if (isPrimitive(s)) {
            return s;
        }

        if (s.length() == 1) {
            return s;
        }

        if (!exportClasses.contains(s)) {
            extraExport.add(s);
        }

        return shortName(s) + "Interface";
    }



    private boolean isPrimitive(String name)
    {
        return "void".equals( name ) || "boolean".equals( name ) || "byte".equals( name ) || "char".equals( name )
                || "short".equals( name ) || "int".equals( name ) || "long".equals( name ) || "float".equals( name )
                || "double".equals( name );
    }


    private void addImport(Set<String> importPackages, JavaClass javaClass) {
        if (isInConfigPack(javaClass)) {
            return;
        }

        if (javaClass.isPrimitive()) {
            return;
        }

        if (javaClass.getFullyQualifiedName().startsWith("java.lang")) {
            return;
        }

        if (javaClass.getName().length() == 1) {
            return;
        }

        importPackages.add(javaClass.getFullyQualifiedName());
    }

    private String shortName(String oldName) {

        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
    }

    private boolean isInConfigPack(JavaClass javaClass) {
        if (javaClass.getFullyQualifiedName().startsWith("org.apache.dubbo.config")) {
            return true;
        }

        if (javaClass.isPrimitive()) {
            return false;
        }

        if (javaClass.getName().length() == 1) {
            return false;
        }

        if (!javaClass.getFullyQualifiedName().contains(".")) {
            return true;
        }

        return false;
    }

    public boolean isDubboComponent(JavaClass javaClass) {
        if (javaClass.getFullyQualifiedName().startsWith("org.apache.dubbo")) {
            return true;
        }

        if (javaClass.isPrimitive()) {
            return false;
        }

        if (javaClass.getFullyQualifiedName().length() == 1) {
            return false;
        }

        if (!javaClass.getFullyQualifiedName().contains(".")) {
            return true;
        }

        return false;
    }


    private void initEnvirenment() {
        initJavaProjectBuilder();
        creatInterfaceDir();
        template = FreeMarkerUtil.getTemplate(templateName);
    }

    private void creatInterfaceDir() {
        this.outputDir = this.outputDir + "/org/apache/dubbo/Interface/";
        File outputDir = new File(this.outputDir);
        outputDir.mkdirs();
    }

    private void initJavaProjectBuilder() {
        jpb = new JavaProjectBuilder();
        inOrNot(new File(this.projectBasePath));
        for (File file : sourceFile) {
            jpb.addSourceTree(file);
        }
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


    public String getTemplateSourthPath() {
        return templateSourthPath;
    }

    public void setTemplateSourthPath(String templateSourthPath) {
        this.templateSourthPath = templateSourthPath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getExportInfoPath() {
        return exportInfoPath;
    }

    public void setExportInfoPath(String exportInfoPath) {
        this.exportInfoPath = exportInfoPath;
    }

    public String getProjectBasePath() {
        return projectBasePath;
    }

    public void setProjectBasePath(String projectBasePath) {
        projectBasePath = projectBasePath;
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
}
