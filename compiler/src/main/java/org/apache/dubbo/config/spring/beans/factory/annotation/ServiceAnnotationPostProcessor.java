package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.Collection;
import java.util.Set;

public class ServiceAnnotationPostProcessor implements ServiceAnnotationPostProcessorInterface {

    public void afterPropertiesSet() {
        instance.afterPropertiesSet();
    }

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        instance.postProcessBeanDefinitionRegistry(registry);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void setEnvironment(Environment environment) {
        instance.setEnvironment(environment);
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        instance.setResourceLoader(resourceLoader);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    protected ServiceAnnotationPostProcessorInterface instance;

    public ServiceAnnotationPostProcessorInterface getInternalInstance() {
        return instance;
    }

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
