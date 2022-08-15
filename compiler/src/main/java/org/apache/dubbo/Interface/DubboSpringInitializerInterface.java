package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;

public interface DubboSpringInitializerInterface extends Object{
    void initialize(BeanDefinitionRegistry registry);
    boolean remove(BeanDefinitionRegistry registry);
    boolean remove(ApplicationContext springContext);
}