package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface DubboInfraBeanRegisterPostProcessorInterface extends Object, org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor, org.springframework.context.ApplicationContextAware{
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry);
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
    void setApplicationContext(ApplicationContext applicationContext);
}