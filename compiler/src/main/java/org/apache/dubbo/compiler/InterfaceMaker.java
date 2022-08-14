package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaPackage;
import com.thoughtworks.qdox.model.JavaParameter;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 现在解决
 * 1. import 为空，全限定引入
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

                Object root = getDataModel(javaClass);

                File file = new File(this.outputDir + javaClass.getName() + "Interface.java");

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                OutputStream os = null;

                try {
                    os = new FileOutputStream(file);
                    template.process(root,new OutputStreamWriter(os));
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
        }
    }

    public Object getDataModel(JavaClass javaClass) {
        Map<String,Object> root = new HashMap<>();

        String className = javaClass.getName();
        boolean isGenerics = !javaClass.getTypeParameters().isEmpty();
        List<Method> methods = new ArrayList<>();
        Set<String> importPackages = new HashSet<>();

        root.put("className",className);
        root.put("isGenerics",isGenerics);
        root.put("methods",methods);
        root.put("importPackages",importPackages);

        for (JavaMethod method : javaClass.getMethods()) {
            if (!method.isPublic()) {
                continue;
            }

            Method m = new Method();
            List<Parameter> parameters = new ArrayList<>();
            m.setName(method.getName());

            if (!isInConfigPack(method.getReturns())) {
                m.setReturnType(method.getReturns().getName());
            } else {
                m.setReturnType(method.getReturns().getName() + "Interface");
            }
            m.setParameters(parameters);
            methods.add(m);

            if (!isInConfigPack(method.getReturns()) && !method.getReturns().isPrimitive()) {
                importPackages.add(method.getReturns().getPackageName());
            }

            for (JavaParameter parameter : method.getParameters()) {
                Parameter p = new Parameter();
                p.setName(parameter.getName());

                if (isInConfigPack(parameter.getJavaClass())) {
                    p.setType(parameter.getJavaClass().getName() + "Interface");
                } else {
                    p.setType(parameter.getJavaClass().getName());
                }

                parameters.add(p);

                if (!isInConfigPack(parameter.getJavaClass()) && !parameter.getJavaClass().isPrimitive()) {
                    importPackages.add(parameter.getJavaClass().getPackageName());
                }
            }
        }
        return root;
    }

    private boolean isInConfigPack(JavaClass javaClass) {
        if (javaClass.getFullyQualifiedName().startsWith("org.apache.dubbo.config")) {
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
