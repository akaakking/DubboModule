package org.apache.dubbo.compiler;


import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/12 下午4:09
 */
public class Main {
    private static List<File> list = new ArrayList<>();
    private static String InterfaceBaseDir = "/home/wfh/DubboModule/compiler/src/main/java/org/apache/dubbo/Interface/";
    private static String DirectExportBaseDir = "/home/wfh/DubboModule/compiler/src/main/resources";

    @Test
    public void testForInOrNot() {
        inOrNot(new File("/home/wfh/DubboModule/dubbo"));
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        for (File f : list) {
            javaProjectBuilder.addSourceTree(f);
        }

        JavaClass javaClass = javaProjectBuilder.getClassByName("org.apache.dubbo.config.ServiceConfig");
        for (JavaMethod method : javaClass.getMethods()) {
            System.out.println(method);
        }
    }
// 先解决list ，的问题，再解决javaparser
    @Test
    public void testForReturns() {
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        try {
            javaProjectBuilder.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/deploy/DefaultApplicationDeployer.java"));
            javaProjectBuilder.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-common/src/main/java/org/apache/dubbo/common/deploy/ApplicationDeployer.java"));
            for (JavaClass aClass : javaProjectBuilder.getClasses()) {
                for (JavaMethod method : aClass.getMethods()) {
                    if (method.isPublic()) {
                        System.out.println(method.getReturnType(false).getFullyQualifiedName());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void DataModelTest() {
        inOrNot(new File("/home/wfh/DubboModule/dubbo"));
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();

        for (File f : list) {
            javaProjectBuilder.addSourceTree(f);
        }

        try {
            JavaClass javaClass = javaProjectBuilder.getClassByName("org.apache.dubbo.remoting.zookeeper.AbstractZookeeperClient");
            List<JavaMethod> method = javaClass.getMethods();
            Object root = getDataModel(javaClass);

            Template template = FreeMarkerUtil.getTemplate("Interface.ftl");
            File file = new File("/home/wfh/DubboModule/compiler/src/main/resources/ApplicationConfig.java");
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            template.process(root,new OutputStreamWriter(fileOutputStream));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    public static Object getDataModel(JavaClass javaClass) {
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
                p.setType(parameter.getType().getGenericValue());

                parameters.add(p);

                if (!isInConfigPack(parameter.getJavaClass()) && !parameter.getJavaClass().isPrimitive()) {
                    importPackages.add(parameter.getJavaClass().getPackageName());
                }
            }
        }
        return root;
    }

    public static void inOrNot(File file) {
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
            list.add(file);
            return;
        }

//        if (file.getName().startsWith("dubbo")
//                || file.getName().equals("src")
//                || file.getName().equals("java")
//                || file.getName().equals("main" )
//                || file.getName().equals("org")
//                || file.getName().equals("apache")) {
//            for (File f : file.listFiles()) {
//                inOrNot(f);
//            }
//        }
//
//        if (file.getName().equals("apache")) {
//            list.add(file);
//            return;
//        }
    }

    // 在包下 或者没有那么长 但没有那么长也不一定是
    public static boolean isInConfigPack(JavaClass javaClass) {
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

    @Test
    public void testForType() {
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        try {
            javaProjectBuilder.addSource(new File("/home/wfh/DubboModule/interface/DubboPro/src/main/java/org/apache/dubbo/Interface/ServiceConfigInterface.java"));
            for (JavaClass aClass : javaProjectBuilder.getClasses()) {
//                System.out.println(aClass.getFullyQualifiedName());
                for (JavaMethod method : aClass.getMethods()) {
//                    System.out.println(method.getReturnType());
//                    System.out.println(method.getName());
                    for (JavaParameter parameter : method.getParameters()) {
//                        System.out.println(parameter.getType());
                        System.out.println(parameter.getJavaClass().getSimpleName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void testForSet() {
        Set set = new HashSet();
        set.add("wang");
        set.add("Li");
        set.add("wang");

        Map<String,Object> root = new HashMap<>();
        root.put("sets",set);

        Template template = FreeMarkerUtil.getTemplate("Interface.ftl");
        try {
            template.process(root,new OutputStreamWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*

//    public static void main(String[] args) {
//
//
//        Map<String,Object> root = new HashMap<>();
//        root.put("user","wang");
//        List<String> names = new ArrayList<>();
//        names.add("wang");
//        names.add("li");
//        root.put("names",names);
//
//        try {
//            Template template = cfg.getTemplate("Interface.ftl");
//            Writer out = new OutputStreamWriter(System.out);
//            template.process(root,out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public static void main(String[] args) {
//        inOrNot(new File("/home/wfh/DubboModule/dubbo/"));
//        JavaProjectBuilder jpb = new JavaProjectBuilder();
//
//        for (File file : list) {
//            jpb.addSourceTree(file);
//        }
//
//        Collection<JavaClass> javaClasses = jpb.getClasses();
//
//        for (JavaClass javaClass : javaClasses) {
//
//            List<JavaMethod> javaMethod =  javaClass.getMethods();
//
//            for (JavaMethod method : javaMethod) {
//
//                if (method.isPrivate()) {
//                    continue;
//                }
//                if (method.getReturnType().toString().startsWith("org.apache.dubbo")
//                        && !method.getReturnType().toString().startsWith("org.apache.dubbo.config")) {
//                        System.out.println(method.getReturnType());
//                    }
//            }
//        }
//    }

    // 直接暴露没啥说的实际上就是直接挪动罢了，
    // 挪到外面来但是要输出一个list,让我知道有哪些直接走了，可能会影响到其他的东西就看值不值了
    public static void dealAnnotation(JavaClass javaClass) {
    }

    public static void dealClass(JavaClass javaClass) {

    }

    public static boolean dealInterface(JavaClass javaClass) {
        boolean isDirectExport = false;

        return isDirectExport;
    }



    public static void inOrNot(File file) {
        // 过滤一部分
        if (file.isFile()) {
            return;
        }
        if (file.getName().startsWith("dubbo")
                    || file.getName().equals("src")
                    || file.getName().equals("java")
                    || file.getName().equals("main" )
                    || file.getName().equals("org")
                    || file.getName().equals("apache")) {
            for (File f : file.listFiles()) {
                inOrNot(f);
            }
        }

        if (file.getName().equals("config")) {
            list.add(file);
            return;
        }
    }
}
*/
// 要不然先不管那些引用了外部的方法。
