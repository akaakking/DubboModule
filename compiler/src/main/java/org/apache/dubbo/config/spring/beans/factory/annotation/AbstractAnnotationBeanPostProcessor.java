package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.env.Environment;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements AbstractAnnotationBeanPostProcessorInterface {

    public Class<? extends Annotation> getAnnotationType() {
        return instance.getAnnotationType();
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        instance.setBeanFactory(beanFactory);
    }

    public void destroy() {
        instance.destroy();
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setEnvironment(Environment environment) {
        instance.setEnvironment(environment);
    }

    public AbstractAnnotationBeanPostProcessorInterface getInternalInstance() {
        return instance;
    }

    public AbstractAnnotationBeanPostProcessorInterface getInternalInstance() {
        return instance;
    }
}
