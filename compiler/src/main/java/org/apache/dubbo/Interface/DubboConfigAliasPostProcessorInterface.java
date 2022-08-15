package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface DubboConfigAliasPostProcessorInterface extends Object, org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor, org.springframework.beans.factory.config.BeanPostProcessor{
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry);
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName);
}