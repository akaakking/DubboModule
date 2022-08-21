package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.springframework.beans.PropertyValues;
import java.lang.String;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.core.type.MethodMetadata;

public class SpringCompatUtils implements SpringCompatUtilsInterface {

    protected SpringCompatUtilsInterface instance;

    public static <T> T getPropertyValue(PropertyValues pvs, String propertyName) {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringCompatUtils.class.getName());
        Method method = klass.getMethod("getPropertyValue", PropertyValues.class, String.class);
        return (T)method.invoke(pvs, propertyName);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static boolean isFactoryMethodMetadataEnabled() {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringCompatUtils.class.getName());
        Method method = klass.getMethod("isFactoryMethodMetadataEnabled");
        return (boolean)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String getFactoryMethodReturnType(AnnotatedBeanDefinition annotatedBeanDefinition) {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringCompatUtils.class.getName());
        Method method = klass.getMethod("getFactoryMethodReturnType", AnnotatedBeanDefinition.class);
        return (String)method.invoke(annotatedBeanDefinition);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static MethodMetadata getFactoryMethodMetadata(AnnotatedBeanDefinition annotatedBeanDefinition) {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringCompatUtils.class.getName());
        Method method = klass.getMethod("getFactoryMethodMetadata", AnnotatedBeanDefinition.class);
        return (MethodMetadata)method.invoke(annotatedBeanDefinition);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Class getGenericTypeOfReturnType(MethodMetadata factoryMethodMetadata) {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringCompatUtils.class.getName());
        Method method = klass.getMethod("getGenericTypeOfReturnType", MethodMetadata.class);
        return (Class)method.invoke(factoryMethodMetadata);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public SpringCompatUtilsInterface getInternalInstance() {
        return instance;
    }

    protected SpringCompatUtils() {
        instance = (SpringCompatUtilsInterface) DubboClassLoader.getInstance(SpringCompatUtils.class.getName());
    }
}
