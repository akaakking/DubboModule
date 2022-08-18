package org.apache.dubbo.config.spring.beans.factory.annotation;

import java.util.Map;
import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceBeanNameBuilder;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

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

    public static ServiceBeanNameBuilder create(AnnotationAttributes attributes, Class<?> defaultInterfaceClass, Environment environment) {
        Method method = instance.getClass().getMethod(AnnotationAttributes.class, Class.class, Environment.class);
        return method.invoke(attributes, defaultInterfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Class<?> interfaceClass, Environment environment) {
        Method method = instance.getClass().getMethod(Class.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(String interfaceClass, Environment environment) {
        Method method = instance.getClass().getMethod(String.class, Environment.class);
        return method.invoke(interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Service service, Class<?> interfaceClass, Environment environment) {
        Method method = instance.getClass().getMethod(Service.class, Class.class, Environment.class);
        return method.invoke(service, interfaceClass, environment);
    }

    public static ServiceBeanNameBuilder create(Reference reference, Class<?> interfaceClass, Environment environment) {
        Method method = instance.getClass().getMethod(Reference.class, Class.class, Environment.class);
        return method.invoke(reference, interfaceClass, environment);
    }
}
