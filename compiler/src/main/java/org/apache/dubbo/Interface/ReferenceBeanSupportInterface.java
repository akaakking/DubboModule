package org.apache.dubbo.Interface;

import java.util.Map;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.ApplicationContext;

public interface ReferenceBeanSupportInterface extends Object{
    void convertReferenceProps(Map attributes, Class defaultInterfaceClass);
    String generateReferenceKey(Map attributes, ApplicationContext applicationContext);
    Map convertPropertyValues(MutablePropertyValues propertyValues);
    String generateReferenceKey(ReferenceBeanInterface<T> referenceBean, ApplicationContext applicationContext);
    String generateReferenceKey(BeanDefinition beanDefinition, ApplicationContext applicationContext);
    Map getReferenceAttributes(ReferenceBeanInterface<T> referenceBean);
    Map getReferenceAttributes(BeanDefinition beanDefinition);
}