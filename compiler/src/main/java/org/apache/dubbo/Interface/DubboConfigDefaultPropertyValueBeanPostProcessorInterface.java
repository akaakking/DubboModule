package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface DubboConfigDefaultPropertyValueBeanPostProcessorInterface{
    void postProcessMergedBeanDefinition(org.springframework.beans.factory.support.RootBeanDefinition beanDefinition, Class beanType, String beanName);
    int getOrder();

}