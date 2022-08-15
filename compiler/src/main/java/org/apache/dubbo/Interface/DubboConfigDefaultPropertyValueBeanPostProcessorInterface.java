package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.RootBeanDefinition;

public interface DubboConfigDefaultPropertyValueBeanPostProcessorInterface {
    void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class beanType, String beanName);
    int getOrder();
}