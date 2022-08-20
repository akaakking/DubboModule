package org.apache.dubbo.config.spring.beans.factory.config;

import com.alibaba.spring.beans.factory.config.GenericBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigDefaultPropertyValueBeanPostProcessor extends GenericBeanPostProcessorAdapter<AbstractConfig> implements DubboConfigDefaultPropertyValueBeanPostProcessorInterface {

    public void postProcessMergedBeanDefinition(RootBeanDefinitionInterface beanDefinition, Class<?> beanType, StringInterface beanName) {
        instance.postProcessMergedBeanDefinition(beanDefinition, beanType, beanName);
    }

    public int getOrder() {
        return instance.getOrder();
    }
}
