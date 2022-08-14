package org.apache.dubbo.Interface;

import ;

public interface DubboInfraBeanRegisterPostProcessorInterface{
    void postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory);
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);

}