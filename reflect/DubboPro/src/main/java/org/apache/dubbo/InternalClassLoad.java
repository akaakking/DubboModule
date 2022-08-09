package org.apache.dubbo;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class InternalClassLoad {
    private static final String INTERNAL_JAR_NAME_PREFIX = "dubboInternal";
    private static final String INTERNAL_JAR_NAME_SUFFIX = ".jar";
    private static final String INTERNAL_JAR_NAME = INTERNAL_JAR_NAME_PREFIX + INTERNAL_JAR_NAME_SUFFIX;

    private static InternalURLClassLoader  internalClassLoader;

    private InternalClassLoad() {
    }

    static {
        File file = UnZipJAR();
        try {
            URL url = file.toURL();
            internalClassLoader = new InternalURLClassLoader(new URL[]{url});
            Thread.currentThread().setContextClassLoader(internalClassLoader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public static <T> T getInstance(Class<T> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class klass = internalClassLoader.loadClass(clazz.getName().replace("Interface",""));
        return  (T) klass.newInstance();
    }

    public static <T> T getInstance(Class<T> clazz,String args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class klass = internalClassLoader.loadClass(clazz.getName());
        try {
            Constructor constructor = klass.getConstructor(String.class);
            return (T) constructor.newInstance(args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class getKlass(Class clazz) throws ClassNotFoundException {
        return internalClassLoader.loadClass(clazz.getName());
    }

    // 将嵌套的jar文件解压到本地成为一个临时文件，为类加载做准备。
    private static File UnZipJAR() {
        URL url = InternalClassLoad.class.getResource("/" + INTERNAL_JAR_NAME);
        String path = url.getPath();
        // 得到 ApiModule.jar位置
        String jarpath = path.substring(0,path.lastIndexOf("!")).replace("file:","");



        try {
            JarFile jarFile = new JarFile(jarpath);
            JarEntry jarEntry = jarFile.getJarEntry(INTERNAL_JAR_NAME);
            InputStream is = jarFile.getInputStream(jarEntry);

            File tempFile = File.createTempFile(INTERNAL_JAR_NAME_PREFIX,INTERNAL_JAR_NAME_SUFFIX);
            tempFile.deleteOnExit();

            OutputStream outputStream = new FileOutputStream(tempFile);
            is.transferTo(outputStream);

            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static class InternalURLClassLoader extends URLClassLoader {

        public InternalURLClassLoader(URL[] urls) {
            super(urls);
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            synchronized (this.getClassLoadingLock(name)) {
                Class<?> c = this.findLoadedClass(name);
                if (c == null) {
                    if (!name.startsWith("org.apache.dubbo.common.bytecode")
                            && !name.startsWith("org.apache.dubbo.Interface")
                            && (name.startsWith("org.apache.dubbo") || name.startsWith("com.alibaba.dubbo"))) {
                        c = findClass(name);
                    } else {
                        c = super.loadClass(name);
                    }
                }

                return c;
            }
        }
    }

}


//