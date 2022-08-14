package org.apache.dubbo.Interface;

import ;

public interface DubboSpringInitializerInterface{
    void initialize(org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    boolean remove(org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    boolean remove(org.springframework.context.ApplicationContext springContext);

}