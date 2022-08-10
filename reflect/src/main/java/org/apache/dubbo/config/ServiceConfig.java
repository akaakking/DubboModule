package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/10 下午6:56
 */
public class ServiceConfig {
    private Object instance;
    private Class clazz;

    public ServiceConfig() {

        this.instance = DubboClassLoader.getInstance(ServiceConfig.class);
        try {
            this.clazz = DubboClassLoader.getKlass(ServiceConfig.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("instanceis " + this.instance);
    }

    public void setInterface(Class<?> clazz) {
        try {
            Method method = this.clazz.getMethod("setInterface", Class.class);
            method.invoke(this.instance, clazz);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var3) {
            var3.printStackTrace();
        }

    }

    public void setRef(Object ref) {
        try {
            Method method = this.clazz.getMethod("setRef", Object.class);
            method.invoke(this.instance, ref);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var3) {
            var3.printStackTrace();
        }

    }

    public void setRegistry(RegistryConfig registryConfig) {
        Method method = null;

        try {
            method = this.clazz.getMethod("setRegistry", DubboClassLoader.getKlass(RegistryConfig.class));
            method.invoke(this.instance, registryConfig.getInstance());
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException var4) {
            var4.printStackTrace();
        }

    }

    public void setApplication(ApplicationConfig application) {
        Method method = null;

        try {
            method = this.clazz.getMethod("setApplication", DubboClassLoader.getKlass(ApplicationConfig.class));
            method.invoke(this.instance, application.getInstance());
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException var4) {
            var4.printStackTrace();
        }

    }

    public void setMetadataReportConfig(MetadataReportConfig metadataReportConfig) {
        Method method = null;

        try {
            method = this.clazz.getMethod("setMetadataReportConfig", DubboClassLoader.getKlass(MetadataReportConfig.class));
            method.invoke(this.instance, metadataReportConfig.getInstance());
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException var4) {
            var4.printStackTrace();
        }

    }

    public void export() {
        try {
            Method method = this.clazz.getMethod("export");
            method.invoke(this.instance);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var2) {
            var2.printStackTrace();
        }

    }
}
