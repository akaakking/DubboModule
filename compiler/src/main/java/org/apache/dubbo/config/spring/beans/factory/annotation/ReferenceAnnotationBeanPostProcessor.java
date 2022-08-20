package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.PropertyValues;
import java.util.Map;
import java.util.Collection;
import org.springframework.beans.factory.annotation.InjectionMetadata$InjectedElement;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceAnnotationBeanPostProcessor extends AbstractAnnotationBeanPostProcessor implements ReferenceAnnotationBeanPostProcessorInterface {

    public void postProcessBeanFactory(ConfigurableListableBeanFactoryInterface beanFactory) {
        instance.postProcessBeanFactory(beanFactory);
    }

    public void postProcessMergedBeanDefinition(RootBeanDefinitionInterface beanDefinition, Class<?> beanType, StringInterface beanName) {
        instance.postProcessMergedBeanDefinition(beanDefinition, beanType, beanName);
    }

    public PropertyValuesInterface postProcessPropertyValues(PropertyValuesInterface pvs, PropertyDescriptorInterface[] pds, ObjectInterface bean, StringInterface beanName) {
        return instance.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    public StringInterface registerReferenceBean(StringInterface propertyName, Class<?> injectedType, Map<String, Object> attributes, MemberInterface member) {
        return instance.registerReferenceBean(propertyName, injectedType, attributes, member);
    }

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void destroy() {
        instance.destroy();
    }

    public Collection<ReferenceBeanInterface<?>> getReferenceBeans() {
        return instance.getReferenceBeans();
    }

    public Map<InjectionMetadata.InjectedElement, ReferenceBeanInterface<?>> getInjectedFieldReferenceBeanMap() {
        return instance.getInjectedFieldReferenceBeanMap();
    }

    public Map<InjectionMetadata.InjectedElement, ReferenceBeanInterface<?>> getInjectedMethodReferenceBeanMap() {
        return instance.getInjectedMethodReferenceBeanMap();
    }

    public ReferenceAnnotationBeanPostProcessor() {
        instance = (ReferenceAnnotationBeanPostProcessorInterface) DubboClassLoader.getInstance(ReferenceAnnotationBeanPostProcessor.class.getName());
    }
}
