package org.apache.dubbo.Interface;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.BeanFactory;

public interface AbstractAnnotationBeanPostProcessorInterface {
    Class getAnnotationType();
    void setBeanFactory(BeanFactory beanFactory);
    void destroy();
    void setBeanClassLoader(ClassLoader classLoader);
    void setEnvironment(Environment environment);
}