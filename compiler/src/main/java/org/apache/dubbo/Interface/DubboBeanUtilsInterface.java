package org.apache.dubbo.Interface;

import ;
import java.lang;
import java.util;
import org.apache.dubbo.rpc.model;

public interface DubboBeanUtilsInterface{
    void registerCommonBeans(org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    boolean registerInfrastructureBean(org.springframework.beans.factory.support.BeanDefinitionRegistry beanDefinitionRegistry, String beanName, Class beanType);
    void registerPlaceholderConfigurerBeanIfNotExists(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory, org.springframework.beans.factory.support.BeanDefinitionRegistry registry);
    boolean registerBeanDefinition(org.springframework.beans.factory.support.BeanDefinitionRegistry registry, String beanName, Class beanClass, Map extraPropertyValues);
    boolean checkBeanExists(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory, Class targetClass);
    ReferenceAnnotationBeanPostProcessorInterface getReferenceAnnotationBeanPostProcessor(org.springframework.beans.factory.support.AbstractBeanFactory beanFactory);
    ReferenceAnnotationBeanPostProcessorInterface getReferenceAnnotationBeanPostProcessor(org.springframework.context.ApplicationContext applicationContext);
    DubboSpringInitContextInterface getInitializationContext(org.springframework.beans.factory.BeanFactory beanFactory);
    ApplicationModel getApplicationModel(org.springframework.beans.factory.BeanFactory beanFactory);
    ModuleModel getModuleModel(org.springframework.beans.factory.BeanFactory beanFactory);

}