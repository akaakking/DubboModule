package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigAliasPostProcessor implements DubboConfigAliasPostProcessorInterface {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistryInterface registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactoryInterface beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public ObjectInterface postProcessBeforeInitialization(ObjectInterface bean, StringInterface beanName) {
        return instance.postProcessBeforeInitialization(bean, beanName);
    }

    public ObjectInterface postProcessAfterInitialization(ObjectInterface bean, StringInterface beanName) {
        return instance.postProcessAfterInitialization(bean, beanName);
    }

    protected DubboConfigAliasPostProcessorInterface instance;
}
