package org.apache.dubbo.config.spring.context;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboInfraBeanRegisterPostProcessor implements DubboInfraBeanRegisterPostProcessorInterface {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    protected DubboInfraBeanRegisterPostProcessorInterface instance;

    public DubboInfraBeanRegisterPostProcessorInterface getInternalInstance() {
        return instance;
    }

    public DubboInfraBeanRegisterPostProcessorInterface getInternalInstance() {
        return instance;
    }
}
