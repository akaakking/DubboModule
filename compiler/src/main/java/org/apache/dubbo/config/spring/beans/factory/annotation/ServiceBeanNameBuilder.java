package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceBeanNameBuilder;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.Reference;

public class ServiceBeanNameBuilder implements ServiceBeanNameBuilderInterface {

    public ServiceBeanNameBuilderInterface group(StringInterface group) {
        return instance.group(group);
    }

    public ServiceBeanNameBuilderInterface version(StringInterface version) {
        return instance.version(version);
    }

    public StringInterface build() {
        return instance.build();
    }

    protected ServiceBeanNameBuilderInterface instance;

    public static ServiceBeanNameBuilderInterface create(AnnotationAttributesInterface attributes, Class<?> defaultInterfaceClass, EnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, AnnotationAttributes.class, Class.class, Environment.class);
        return method.invoke(attributes, defaultInterfaceClass, environment);
    }

    public static ServiceBeanNameBuilderInterface create(Class<?> interfaceClass, EnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Class.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilderInterface create(StringInterface interfaceClass, EnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, String.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilderInterface create(ServiceInterface service, Class<?> interfaceClass, EnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Service.class, Class.class, Environment.class);
        return method.invoke(service, interfaceClass, environment);
    }

    public static ServiceBeanNameBuilderInterface create(ReferenceInterface reference, Class<?> interfaceClass, EnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(create, Reference.class, Class.class, Environment.class);
        return method.invoke(reference, interfaceClass, environment);
    }
}
