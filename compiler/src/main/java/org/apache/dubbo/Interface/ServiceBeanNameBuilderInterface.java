package org.apache.dubbo.Interface;

import org.springframework.core.env.Environment;
import org.springframework.core.annotation.AnnotationAttributes;

public interface ServiceBeanNameBuilderInterface extends Object{
    ServiceBeanNameBuilderInterface create(AnnotationAttributes attributes, Class defaultInterfaceClass, Environment environment);
    ServiceBeanNameBuilderInterface create(Class interfaceClass, Environment environment);
    ServiceBeanNameBuilderInterface create(String interfaceClass, Environment environment);
    ServiceBeanNameBuilderInterface create(ServiceInterface service, Class interfaceClass, Environment environment);
    ServiceBeanNameBuilderInterface create(ReferenceInterface reference, Class interfaceClass, Environment environment);
    ServiceBeanNameBuilderInterface group(String group);
    ServiceBeanNameBuilderInterface version(String version);
    String build();
}