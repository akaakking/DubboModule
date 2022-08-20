package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigAliasPostProcessor implements DubboConfigAliasPostProcessorInterface {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return instance.postProcessBeforeInitialization(bean, beanName);
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return instance.postProcessAfterInitialization(bean, beanName);
    }

    protected DubboConfigAliasPostProcessorInterface instance;

    public DubboConfigAliasPostProcessorInterface getInternalInstance() {
        return instance;
    }
}
