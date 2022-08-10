package org.apache.dubbo;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/10 下午6:39
 */
public class DubboClassLoader {
    private static final String INTERNAL_JAR_NAME_PREFIX = "dubboInternal";
    private static final String INTERNAL_JAR_NAME_SUFFIX = ".jar";
    private static final String INTERNAL_JAR_NAME = INTERNAL_JAR_NAME_PREFIX + INTERNAL_JAR_NAME_SUFFIX;
    private static InternalURLClassLoader internalClassLoader;



    public static Object getInstance(Class<?> clazz){
        Class klass = null;
        try {
            klass = internalClassLoader.loadClass(clazz.getName());
            return  klass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getInstance(Class<?> clazz, String args) {
        Class klass = null;
        try {
            klass = internalClassLoader.loadClass(clazz.getName());

            Constructor constructor = klass.getConstructor(String.class);
            return  constructor.newInstance(args);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Class getKlass(Class<?> clazz) throws ClassNotFoundException {
        return internalClassLoader.loadClass(clazz.getName());
    }

    private static File UnZipJAR() {
        URL url = DubboClassLoader.class.getResource("/" +
                INTERNAL_JAR_NAME);
        String path = url.getPath();
        String jarpath = path.substring(0, path.lastIndexOf("!")).replace("file:", "");

        try {
            JarFile jarFile = new JarFile(jarpath);
            JarEntry jarEntry = jarFile.getJarEntry(INTERNAL_JAR_NAME);
            InputStream is = jarFile.getInputStream(jarEntry);
            File tempFile = File.createTempFile(INTERNAL_JAR_NAME_PREFIX, INTERNAL_JAR_NAME_SUFFIX);
            tempFile.deleteOnExit();
            OutputStream outputStream = new FileOutputStream(tempFile);
            transferTo(is,outputStream);
            is.close();
            outputStream.close();
            return tempFile;
        } catch (IOException var8) {
            var8.printStackTrace();
            return null;
        }
    }

    private static void transferTo(InputStream is,OutputStream out) throws IOException {
        int read;
        byte[] buffer = new byte[1 << 13];
        while ((read = is.read(buffer)) >= 0) {
            out.write(buffer,0,read);
        }
    }

    static {
        File file = UnZipJAR();

        try {
            URL url = file.toURL();
            internalClassLoader = new InternalURLClassLoader(new URL[]{url});
            Thread.currentThread().setContextClassLoader(internalClassLoader);
        } catch (MalformedURLException var2) {
            var2.printStackTrace();
        }

    }

    private static class InternalURLClassLoader extends URLClassLoader {
        public InternalURLClassLoader(URL[] urls) {
            super(urls);
        }

        public Class<?> loadClass(String name) throws ClassNotFoundException {
            synchronized(this.getClassLoadingLock(name)) {
                Class<?> c = this.findLoadedClass(name);
                if (c == null) {
                    if (name.startsWith("org.apache.dubbo.common.bytecode") || (!name.startsWith("org.apache.dubbo") && !name.startsWith("com.alibaba.dubbo"))) {
                        c = super.loadClass(name);
                    } else {
                        c = this.findClass(name);
                    }
                }

                return c;
            }
        }
    }
}
