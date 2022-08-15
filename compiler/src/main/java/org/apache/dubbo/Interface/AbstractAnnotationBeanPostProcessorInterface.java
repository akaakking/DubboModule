package org.apache.dubbo.Interface;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.BeanFactory;

public interface AbstractAnnotationBeanPostProcessorInterface extends org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter, org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor, org.springframework.beans.factory.BeanFactoryAware, org.springframework.beans.factory.BeanClassLoaderAware, org.springframework.context.EnvironmentAware, org.springframework.beans.factory.DisposableBean{
    Class getAnnotationType();
    void setBeanFactory(BeanFactory beanFactory);
    void destroy();
    void setBeanClassLoader(ClassLoader classLoader);
    void setEnvironment(Environment environment);
}