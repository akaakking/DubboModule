package org.apache.dubbo.Interface;

import ;
import java.lang.reflect;
import java.lang;
import java.util;
import java.beans;

public interface ReferenceAnnotationBeanPostProcessorInterface{
    void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory);
    void postProcessMergedBeanDefinition(org.springframework.beans.factory.support.RootBeanDefinition beanDefinition, Class beanType, String beanName);
    org.springframework.beans.PropertyValues postProcessPropertyValues(org.springframework.beans.PropertyValues pvs, PropertyDescriptor pds, Object bean, String beanName);
    String registerReferenceBean(String propertyName, Class injectedType, Map attributes, Member member);
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void destroy();
    Collection getReferenceBeans();
    Map getInjectedFieldReferenceBeanMap();
    Map getInjectedMethodReferenceBeanMap();

}