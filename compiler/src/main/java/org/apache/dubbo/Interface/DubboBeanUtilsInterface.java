package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface DubboBeanUtilsInterface {
    void registerCommonBeans(BeanDefinitionRegistry registry);
    boolean registerInfrastructureBean(BeanDefinitionRegistry beanDefinitionRegistry, String beanName, Class beanType);
    void registerPlaceholderConfigurerBeanIfNotExists(ConfigurableListableBeanFactory beanFactory, BeanDefinitionRegistry registry);
    boolean registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class beanClass, Map extraPropertyValues);
    boolean checkBeanExists(ConfigurableListableBeanFactory beanFactory, Class targetClass);
    ReferenceAnnotationBeanPostProcessorInterface getReferenceAnnotationBeanPostProcessor(AbstractBeanFactory beanFactory);
    ReferenceAnnotationBeanPostProcessorInterface getReferenceAnnotationBeanPostProcessor(ApplicationContext applicationContext);
    DubboSpringInitContextInterface getInitializationContext(BeanFactory beanFactory);
    ApplicationModel getApplicationModel(BeanFactory beanFactory);
    ModuleModel getModuleModel(BeanFactory beanFactory);
}