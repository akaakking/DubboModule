package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.PropertyValues;
import java.beans.PropertyDescriptor;
import java.util.Map;
import java.lang.reflect.Member;
import org.springframework.context.ApplicationContext;
import java.util.Collection;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceAnnotationBeanPostProcessor implements ReferenceAnnotationBeanPostProcessorInterface {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        instance.postProcessMergedBeanDefinition(beanDefinition, beanType, beanName);
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) {
        return instance.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    public String registerReferenceBean(String propertyName, Class<?> injectedType, Map<String, Object> attributes, Member member) {
        return instance.registerReferenceBean(propertyName, injectedType, attributes, member);
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void destroy() {
        instance.destroy();
    }

    public Collection<ReferenceBean<?>> getReferenceBeans() {
        return instance.getReferenceBeans();
    }

    public Map<InjectionMetadata.InjectedElement, ReferenceBean<?>> getInjectedFieldReferenceBeanMap() {
        return instance.getInjectedFieldReferenceBeanMap();
    }

    public Map<InjectionMetadata.InjectedElement, ReferenceBean<?>> getInjectedMethodReferenceBeanMap() {
        return instance.getInjectedMethodReferenceBeanMap();
    }

    protected ReferenceAnnotationBeanPostProcessorInterface instance;

    public ReferenceAnnotationBeanPostProcessor() {
        instance = (ReferenceAnnotationBeanPostProcessorInterface) DubboClassLoader.getInstance(ReferenceAnnotationBeanPostProcessor.class.getName());
    }
}
