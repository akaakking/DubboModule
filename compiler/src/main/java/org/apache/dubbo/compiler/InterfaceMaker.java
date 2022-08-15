package org.apache.dubbo.compiler;

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


    private String templateSourthPath = TEMPLATE_SOURTH_PATH;
    private String templateName = TEMPLATE_NAME;
    private String exportInfoPath = EXPORT_INFO_PATH;
    private String projectBasePath = PROJECT_BASE_PATH;
    private String outputDir = OUTPUT_DIR;

    private List<File> sourceFile = new ArrayList<>();
    private static JavaProjectBuilder jpb;


    @Test
    public void methodGene() {
        String path = "/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/bootstrap/builders/AbstractServiceBuilder.java";

        initEnvirenment();

        JavaClass javaClass = jpb.getClassByName("org.apache.dubbo.config.bootstrap.builders.AbstractServiceBuilder");
        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
            System.out.println(typeParameter.getBounds());
        }
    }

    @Test
    public void makeTest() {
       make();
    }

    public void make() {
        initEnvirenment();

        Template template = FreeMarkerUtil.getTemplate(TEMPLATE_NAME);

        List<String> exportPackages = getExportPackages();

        for (String exportPackage : exportPackages) {
            JavaPackage javaPackage = jpb.getPackageByName(exportPackage);

            Collection<JavaClass> javaClasses0 = javaPackage.getClasses();

            List<JavaClass> javaClasses = new LinkedList<>(javaClasses0);

            for (JavaClass javaClass : javaClasses) {
                Map<String,Object> root = getDataModel(javaClass);
                generateInterface(root,template);
            }
        }
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
            typeParameters
 */
    public Map<String, Object> getDataModel(JavaClass javaClass) {
        Map<String,Object> root = new HashMap<>();

        String className = javaClass.getName();
        List<Method> methods = new ArrayList<>();
        Set<String> importPackages = new HashSet<>();
        List<String> typeParameters = new ArrayList<>();

        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
            typeParameters.add("<" + shortName(typeParameter.getName()) + ">");
        }
        root.put("className",className);
        root.put("methods",methods);
        root.put("importPackages",importPackages);
        root.put("typeParameters",typeParameters);

        for (JavaMethod method : javaClass.getMethods()) {
            if (!method.isPublic()) {
                continue;
            }

            Method m = new Method();
            List<Parameter> parameters = new ArrayList<>();
            m.setName(method.getName());

            m.setReturnType(getType(method.getReturns()));
            m.setParameters(parameters);
            methods.add(m);

            addImport(importPackages,method.getReturns());

            for (JavaParameter parameter : method.getParameters()) {
                Parameter p = new Parameter();
                p.setName(parameter.getName());

                p.setType(getType(parameter.getJavaClass()));

                parameters.add(p);
                addImport(importPackages,parameter.getJavaClass());
            }
        }
        return root;
    }

    private String getType(JavaClass javaClass) {
        String old = javaClass.getName();
        if (isInConfigPack(javaClass)) {
            old =  old + "Interface";
        }

        if (javaClass.isPrimitive()) {
            return javaClass.getName();
        }

        old = shortName(old);

        for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : javaClass.getTypeParameters()) {
            old = old + "<" + typeParameter.getName() + ">";
        }

        return old;
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

        if (!javaClass.getFullyQualifiedName().contains(".")) {
            return true;
        }
        return false;
    }


    private void initEnvirenment() {
        initJavaProjectBuilder();
        creatInterfaceDir();
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


    public List<String> getExportPackages() {
        List<String> exportPackages = new ArrayList<>();

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
