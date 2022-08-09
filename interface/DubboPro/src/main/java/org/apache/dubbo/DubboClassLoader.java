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
 * @Date 2022/8/9 下午4:45
 */
public class DubboClassLoader {
    private static final String INTERNAL_JAR_NAME_PREFIX = "dubboInternal";
    private static final String INTERNAL_JAR_NAME_SUFFIX = ".jar";
    private static final String INTERNAL_JAR_NAME = INTERNAL_JAR_NAME_PREFIX + INTERNAL_JAR_NAME_SUFFIX;

    private static InternalURLClassLoader classLoader;

    static {
        File file = UnZipJAR();
        try {
            URL url = file.toURL();
            classLoader = new InternalURLClassLoader(new URL[]{url});
            Thread.currentThread().setContextClassLoader(classLoader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    //TODO 异常处理没处理
    public static <T> T getInstance(Class<T> clazz) {
        Class klass = null;
        try {
            klass = classLoader.loadClass(clazz.getName().replace("Interface",""));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return  (T) klass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 字符串操作会成为慢操作，到时候看看能不能优化一下 todo
    public static <T> T getInstance(Class<T> clazz,String args)  {
        Class klass = null;
        try {
            klass = classLoader.loadClass(clazz.getName().replace("Interface",""));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Constructor constructor = klass.getConstructor(String.class);
            return (T) constructor.newInstance(args);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static File UnZipJAR() {
        URL url = DubboClassLoader.class.getResource("/" + INTERNAL_JAR_NAME);
        String path = url.getPath();
        String jarpath = path.substring(0,path.lastIndexOf("!")).replace("file:","");


        InputStream is = null;
        OutputStream out = null;
        try {
            JarFile jarFile = new JarFile(jarpath);
            JarEntry jarEntry = jarFile.getJarEntry(INTERNAL_JAR_NAME);
            is = jarFile.getInputStream(jarEntry);

            File tempFile = File.createTempFile(INTERNAL_JAR_NAME_PREFIX,INTERNAL_JAR_NAME_SUFFIX);
            tempFile.deleteOnExit();

            out = new FileOutputStream(tempFile);
            transferTo(is,out);

            return tempFile;
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

        return null;
    }

    private DubboClassLoader() {
    }

    private static void transferTo(InputStream is,OutputStream out) throws IOException {
        for (byte[] buffer = new byte[1 << 13]; is.read(buffer) > 0;  ) {
            out.write(buffer);
        }
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
