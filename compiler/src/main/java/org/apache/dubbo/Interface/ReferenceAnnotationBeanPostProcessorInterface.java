package org.apache.dubbo.Interface;

import org.springframework.beans.factory.support.RootBeanDefinition;
import java.beans.PropertyDescriptor[];
import java.util.Map;
import java.util.Collection;
import org.springframework.beans.PropertyValues;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface ReferenceAnnotationBeanPostProcessorInterface {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
    void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class beanType, String beanName);
    PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor pds, Object bean, String beanName);
    String registerReferenceBean(String propertyName, Class injectedType, Map attributes, Member member);
    void setApplicationContext(ApplicationContext applicationContext);
    void destroy();
    Collection getReferenceBeans();
    Map getInjectedFieldReferenceBeanMap();
    Map getInjectedMethodReferenceBeanMap();
}