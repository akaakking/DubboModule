package org.apache.dubbo.Interface;

import org.springframework.core.io.ResourceLoader;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface ServiceAnnotationPostProcessorInterface extends Object, org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor, org.springframework.context.EnvironmentAware, org.springframework.context.ResourceLoaderAware, org.springframework.beans.factory.BeanClassLoaderAware, org.springframework.context.ApplicationContextAware, org.springframework.beans.factory.InitializingBean{
    void afterPropertiesSet();
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry);
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
    void setEnvironment(Environment environment);
    void setResourceLoader(ResourceLoader resourceLoader);
    void setBeanClassLoader(ClassLoader classLoader);
    void setApplicationContext(ApplicationContext applicationContext);
}