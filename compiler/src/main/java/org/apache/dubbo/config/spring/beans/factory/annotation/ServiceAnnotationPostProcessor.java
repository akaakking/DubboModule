package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.InitializingBean;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.Collection;
import java.util.Set;

public class ServiceAnnotationPostProcessor implements ServiceAnnotationPostProcessorInterface {

    public void afterPropertiesSet() {
        instance.afterPropertiesSet();
    }

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistryInterface registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactoryInterface beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment);
    }

    public void setResourceLoader(ResourceLoaderInterface resourceLoader) {
        instance.setResourceLoader(resourceLoader);
    }

    public void setBeanClassLoader(ClassLoaderInterface classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    protected ServiceAnnotationPostProcessorInterface instance;

    public ServiceAnnotationPostProcessor(String packagesToScan) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{packagesToScan};
        instance = (ServiceAnnotationPostProcessorInterface) DubboClassLoader.getInstance(ServiceAnnotationPostProcessor.class.getName(), params, args);
    }

    public ServiceAnnotationPostProcessor(Collection<String> packagesToScan) {
        Class[] params = new Class[]{CollectionCollection<String>.class};
        Object[] args = new Object[]{packagesToScan};
        instance = (ServiceAnnotationPostProcessorInterface) DubboClassLoader.getInstance(ServiceAnnotationPostProcessor.class.getName(), params, args);
    }

    public ServiceAnnotationPostProcessor(Set<String> packagesToScan) {
        Class[] params = new Class[]{SetSet<String>.class};
        Object[] args = new Object[]{packagesToScan};
        instance = (ServiceAnnotationPostProcessorInterface) DubboClassLoader.getInstance(ServiceAnnotationPostProcessor.class.getName(), params, args);
    }
}
