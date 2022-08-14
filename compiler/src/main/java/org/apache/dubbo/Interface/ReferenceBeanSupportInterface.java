package org.apache.dubbo.Interface;

import ;
import java.util;
import java.lang;

public interface ReferenceBeanSupportInterface{
    void convertReferenceProps(Map attributes, Class defaultInterfaceClass);
    String generateReferenceKey(Map attributes, org.springframework.context.ApplicationContext applicationContext);
    Map convertPropertyValues(org.springframework.beans.MutablePropertyValues propertyValues);
    String generateReferenceKey(ReferenceBeanInterface referenceBean, org.springframework.context.ApplicationContext applicationContext);
    String generateReferenceKey(org.springframework.beans.factory.config.BeanDefinition beanDefinition, org.springframework.context.ApplicationContext applicationContext);
    Map getReferenceAttributes(ReferenceBeanInterface referenceBean);
    Map getReferenceAttributes(org.springframework.beans.factory.config.BeanDefinition beanDefinition);

}