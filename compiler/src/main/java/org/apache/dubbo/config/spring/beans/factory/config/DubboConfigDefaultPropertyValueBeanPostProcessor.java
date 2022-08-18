package org.apache.dubbo.config.spring.beans.factory.config;

import com.alibaba.spring.beans.factory.config.GenericBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigDefaultPropertyValueBeanPostProcessor implements DubboConfigDefaultPropertyValueBeanPostProcessorInterface {

    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        instance.postProcessMergedBeanDefinition(beanDefinition, beanType, beanName);
    }

    public int getOrder() {
        return instance.getOrder();
    }

    protected DubboConfigDefaultPropertyValueBeanPostProcessorInterface instance;
}
