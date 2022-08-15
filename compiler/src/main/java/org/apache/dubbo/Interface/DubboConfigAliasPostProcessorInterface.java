package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface DubboConfigAliasPostProcessorInterface {
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry);
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName);
}