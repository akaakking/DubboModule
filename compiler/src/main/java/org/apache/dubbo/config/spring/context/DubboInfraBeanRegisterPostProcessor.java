package org.apache.dubbo.config.spring.context;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboInfraBeanRegisterPostProcessor implements DubboInfraBeanRegisterPostProcessorInterface {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistryInterface registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactoryInterface beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    protected DubboInfraBeanRegisterPostProcessorInterface instance;
}
