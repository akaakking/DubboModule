package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceBeanNameBuilder;
import java.lang.String;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import java.lang.Class;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.Reference;

public class ServiceBeanNameBuilder implements ServiceBeanNameBuilderInterface {

    public ServiceBeanNameBuilder group(String group) {
        return instance.group(group);
    }

    public ServiceBeanNameBuilder version(String version) {
        return instance.version(version);
    }

    public String build() {
        return instance.build();
    }

    protected ServiceBeanNameBuilderInterface instance;

    public static ServiceBeanNameBuilder create(AnnotationAttributes attributes, Class<?> defaultInterfaceClass, Environment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBeanNameBuilder.class.getName());
        Method method = klass.getMethod("create", AnnotationAttributes.class, Class.class, Environment.class);
        return (ServiceBeanNameBuilder)method.invoke(attributes, defaultInterfaceClass, environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ServiceBeanNameBuilder create(Class<?> interfaceClass, Environment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBeanNameBuilder.class.getName());
        Method method = klass.getMethod("create", Class.class, Environment.class);
        return (ServiceBeanNameBuilder)method.invoke(interfaceClass, environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ServiceBeanNameBuilder create(String interfaceClass, Environment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBeanNameBuilder.class.getName());
        Method method = klass.getMethod("create", String.class, Environment.class);
        return (ServiceBeanNameBuilder)method.invoke(interfaceClass, environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ServiceBeanNameBuilder create(Service service, Class<?> interfaceClass, Environment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBeanNameBuilder.class.getName());
        Method method = klass.getMethod("create", Service.class, Class.class, Environment.class);
        return (ServiceBeanNameBuilder)method.invoke(service, interfaceClass, environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ServiceBeanNameBuilder create(Reference reference, Class<?> interfaceClass, Environment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBeanNameBuilder.class.getName());
        Method method = klass.getMethod("create", Reference.class, Class.class, Environment.class);
        return (ServiceBeanNameBuilder)method.invoke(reference, interfaceClass, environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ServiceBeanNameBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ServiceBeanNameBuilder() {
        instance = (ServiceBeanNameBuilderInterface) DubboClassLoader.getInstance(ServiceBeanNameBuilder.class.getName());
    }
}
