package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.beans.factory.DisposableBean;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements AbstractAnnotationBeanPostProcessorInterface {

    public Class<? extends Annotation> getAnnotationType() {
        return instance.getAnnotationType();
    }

    public void setBeanFactory(BeanFactoryInterface beanFactory) {
        instance.setBeanFactory(beanFactory);
    }

    public void destroy() {
        instance.destroy();
    }

    public void setBeanClassLoader(ClassLoaderInterface classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment);
    }
}
