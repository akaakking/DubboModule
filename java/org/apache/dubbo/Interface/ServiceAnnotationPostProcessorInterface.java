package org.apache.dubbo.Interface;

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
import java.lang.ClassLoader;
import org.springframework.context.ApplicationContext;

public interface ServiceAnnotationPostProcessorInterface extends BeanDefinitionRegistryPostProcessor, EnvironmentAware, ResourceLoaderAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean {

    void afterPropertiesSet();

    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry);

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

    void setEnvironment(Environment environment);

    void setResourceLoader(ResourceLoader resourceLoader);

    void setBeanClassLoader(ClassLoader classLoader);

    void setApplicationContext(ApplicationContext applicationContext);
}
