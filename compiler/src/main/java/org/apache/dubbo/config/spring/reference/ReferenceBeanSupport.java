package org.apache.dubbo.config.spring.reference;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import java.util.Map;
import java.lang.Class;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.MutablePropertyValues;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.factory.config.BeanDefinition;

public class ReferenceBeanSupport implements ReferenceBeanSupportInterface {

    protected ReferenceBeanSupportInterface instance;

    public static void convertReferenceProps(Map<String, Object> attributes, Class defaultInterfaceClass) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("convertReferenceProps", Map.class, Class.class);
        method.invoke(attributes, defaultInterfaceClass);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static String generateReferenceKey(Map<String, Object> attributes, ApplicationContext applicationContext) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("generateReferenceKey", Map.class, ApplicationContext.class);
        return (String)method.invoke(attributes, applicationContext);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Map<String, Object> convertPropertyValues(MutablePropertyValues propertyValues) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("convertPropertyValues", MutablePropertyValues.class);
        return (Map<String, Object>)method.invoke(propertyValues);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String generateReferenceKey(ReferenceBeanInterface referenceBean, ApplicationContext applicationContext) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("generateReferenceKey", ReferenceBeanInterface.class, ApplicationContext.class);
        return (String)method.invoke(referenceBean, applicationContext);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String generateReferenceKey(BeanDefinition beanDefinition, ApplicationContext applicationContext) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("generateReferenceKey", BeanDefinition.class, ApplicationContext.class);
        return (String)method.invoke(beanDefinition, applicationContext);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Map<String, Object> getReferenceAttributes(ReferenceBeanInterface referenceBean) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("getReferenceAttributes", ReferenceBeanInterface.class);
        return (Map<String, Object>)method.invoke(referenceBean);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Map<String, Object> getReferenceAttributes(BeanDefinition beanDefinition) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBeanSupport.class.getName());
        Method method = klass.getMethod("getReferenceAttributes", BeanDefinition.class);
        return (Map<String, Object>)method.invoke(beanDefinition);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ReferenceBeanSupportInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceBeanSupport() {
        instance = (ReferenceBeanSupportInterface) DubboClassLoader.getInstance(ReferenceBeanSupport.class.getName());
    }
}
