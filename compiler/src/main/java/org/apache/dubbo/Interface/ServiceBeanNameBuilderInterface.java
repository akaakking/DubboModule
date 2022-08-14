package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface ServiceBeanNameBuilderInterface{
    ServiceBeanNameBuilderInterface create(org.springframework.core.annotation.AnnotationAttributes attributes, Class defaultInterfaceClass, org.springframework.core.env.Environment environment);
    ServiceBeanNameBuilderInterface create(Class interfaceClass, org.springframework.core.env.Environment environment);
    ServiceBeanNameBuilderInterface create(String interfaceClass, org.springframework.core.env.Environment environment);
    ServiceBeanNameBuilderInterface create(ServiceInterface service, Class interfaceClass, org.springframework.core.env.Environment environment);
    ServiceBeanNameBuilderInterface create(ReferenceInterface reference, Class interfaceClass, org.springframework.core.env.Environment environment);
    ServiceBeanNameBuilderInterface group(String group);
    ServiceBeanNameBuilderInterface version(String version);
    String build();

}