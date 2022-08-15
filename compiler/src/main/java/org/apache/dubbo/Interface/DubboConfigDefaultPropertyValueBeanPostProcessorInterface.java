package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.RootBeanDefinition;

public interface DubboConfigDefaultPropertyValueBeanPostProcessorInterface extends com.alibaba.spring.beans.factory.config.GenericBeanPostProcessorAdapter, org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor, org.springframework.core.PriorityOrdered{
    void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class beanType, String beanName);
    int getOrder();
}