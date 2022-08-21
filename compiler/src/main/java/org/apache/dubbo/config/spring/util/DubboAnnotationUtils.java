package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.apache.dubbo.config.annotation.Service;
import java.lang.Class;
import java.util.Map;
import org.apache.dubbo.config.annotation.Reference;
import java.lang.String;

public class DubboAnnotationUtils implements DubboAnnotationUtilsInterface {

    protected DubboAnnotationUtilsInterface instance;

    public static String resolveInterfaceName(Service service, Class<?> defaultInterfaceClass) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboAnnotationUtils.class.getName());
        Method method = klass.getMethod("resolveInterfaceName", Service.class, Class.class);
        return (String)method.invoke(service, defaultInterfaceClass);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String resolveInterfaceName(Map<String, Object> attributes, Class<?> defaultInterfaceClass) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboAnnotationUtils.class.getName());
        Method method = klass.getMethod("resolveInterfaceName", Map.class, Class.class);
        return (String)method.invoke(attributes, defaultInterfaceClass);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String resolveInterfaceName(Reference reference, Class<?> defaultInterfaceClass) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboAnnotationUtils.class.getName());
        Method method = klass.getMethod("resolveInterfaceName", Reference.class, Class.class);
        return (String)method.invoke(reference, defaultInterfaceClass);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Map<String, String> convertParameters(String[] parameters) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboAnnotationUtils.class.getName());
        Method method = klass.getMethod("convertParameters", String[].class);
        return (Map<String, String>)method.invoke(parameters);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public DubboAnnotationUtilsInterface getInternalInstance() {
        return instance;
    }

    protected DubboAnnotationUtils() {
        instance = (DubboAnnotationUtilsInterface) DubboClassLoader.getInstance(DubboAnnotationUtils.class.getName());
    }
}
