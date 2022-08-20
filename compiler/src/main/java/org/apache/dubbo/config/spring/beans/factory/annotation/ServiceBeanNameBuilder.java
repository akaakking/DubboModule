package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceBeanNameBuilder;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
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
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, AnnotationAttributes.class, Class.class, Environment.class);
        return method.invoke(attributes, defaultInterfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Class<?> interfaceClass, Environment environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Class.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(String interfaceClass, Environment environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, String.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Service service, Class<?> interfaceClass, Environment environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Service.class, Class.class, Environment.class);
        return method.invoke(service, interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Reference reference, Class<?> interfaceClass, Environment environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Reference.class, Class.class, Environment.class);
        return method.invoke(reference, interfaceClass, environment);
    }

    public ServiceBeanNameBuilderInterface getInternalInstance() {
        return instance;
    }
}
