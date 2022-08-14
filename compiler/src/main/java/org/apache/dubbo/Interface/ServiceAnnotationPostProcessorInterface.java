package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface ServiceAnnotationPostProcessorInterface{
    void afterPropertiesSet();
    void postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory);
    void setEnvironment(org.springframework.core.env.Environment environment);
    void setResourceLoader(org.springframework.core.io.ResourceLoader resourceLoader);
    void setBeanClassLoader(ClassLoader classLoader);
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);

}