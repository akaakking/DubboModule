package org.apache.dubbo.Interface;

import java.lang.Class;
import org.apache.dubbo.common.extension.SPI;
import S;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.BeanFactory;
import java.lang.ClassLoader;
import org.springframework.core.env.Environment;

public interface AbstractAnnotationBeanPostProcessorInterface extends InstantiationAwareBeanPostProcessorAdapter, MergedBeanDefinitionPostProcessor, BeanFactoryAware, BeanClassLoaderAware, EnvironmentAware, DisposableBean {

    Class<? extends Annotation> getAnnotationType();

    void setBeanFactory(BeanFactory beanFactory);

    void destroy();

    void setBeanClassLoader(ClassLoader classLoader);

    void setEnvironment(Environment environment);
}
