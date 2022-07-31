package org.apache.dubbo.config;

import org.apache.dubbo.InternalClassLoad;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午2:37
 */
public class ServiceConfig {
    private Object instance;
    private Class clazz;

    {
        try {
            instance = InternalClassLoad.getInstance(ServiceConfig.class);
            clazz = InternalClassLoad.getKlass(ServiceConfig.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("instance" + "is " + instance);
    }

    public void setInterface(Class<?> clazz) {
        try {
            Method method = this.clazz.getMethod("setInterface",Class.class);
            method.invoke(instance,clazz);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setRef(Object ref) {
        try {
            Method method = this.clazz.getMethod("setRef",Object.class);
            method.invoke(instance,ref);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setRegistry(RegistryConfig registryConfig) {
        Method method = null;
        try {
            method = this.clazz.getMethod("setRegistry",InternalClassLoad.getKlass(RegistryConfig.class));
            method.invoke(instance,registryConfig.getInstance());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setApplication(ApplicationConfig application) {
        Method method = null;
        try {
            method = this.clazz.getMethod("setApplication",InternalClassLoad.getKlass(ApplicationConfig.class));
            method.invoke(instance,application.getInstance());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setMetadataReportConfig(MetadataReportConfig metadataReportConfig) {
        Method method = null;
        try {
            method = this.clazz.getMethod("setMetadataReportConfig",InternalClassLoad.getKlass(MetadataReportConfig.class));
            method.invoke(instance,metadataReportConfig.getInstance());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void export() {
        try {
            Method method = this.clazz.getMethod("export");
            method.invoke(instance);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
