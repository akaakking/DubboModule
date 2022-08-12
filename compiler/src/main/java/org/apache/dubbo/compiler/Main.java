package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaPackage;
import com.thoughtworks.qdox.model.JavaParameter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/12 下午4:09
 */
public class Main {
    private static List<File> list = new ArrayList<>();

    public static void main(String[] args) {
//        JavaDocBuilder javaDocBuilder = new JavaDocBuilder();
//        javaDocBuilder.addSourceTree(new File("/home/wfh/DubboModule/compiler/src/main/java/org/apache/dubbo/compiler"));
//        JavaClass[] javaClasses = javaDocBuilder.getClasses();
//        for (JavaClass javaClass : javaClasses) {
//            System.out.println(javaClass);
//        }

        String basePath = "/home/wfh/DubboModule/dubbo/";
        File file = new File(basePath);
        inOrNot(file);

        System.out.println(list);


        JavaDocBuilder javaDocBuilder = new JavaDocBuilder();

        javaDocBuilder.addSourceTree(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-spring/src/main/java/org/apache/dubbo/config/spring/context/config/DubboConfigBeanCustomizer.java"));

//        for (File f : list) {
//            javaDocBuilder.addSourceTree(f);
//        }
//
//        JavaPackage[] javaPackages = javaDocBuilder.getPackages();
//
//        for (JavaPackage javaPackage : javaPackages) {
//            System.out.println(javaPackage);
//        }
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
