package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface AbstractAnnotationBeanPostProcessorInterface{
    Class getAnnotationType();
    void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory);
    void destroy();
    void setBeanClassLoader(ClassLoader classLoader);
    void setEnvironment(org.springframework.core.env.Environment environment);

}