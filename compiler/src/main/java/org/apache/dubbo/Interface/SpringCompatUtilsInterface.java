package org.apache.dubbo.Interface;

import org.springframework.core.type.MethodMetadata;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.PropertyValues;

public interface SpringCompatUtilsInterface {
    T getPropertyValue(PropertyValues pvs, String propertyName);
    boolean isFactoryMethodMetadataEnabled();
    String getFactoryMethodReturnType(AnnotatedBeanDefinition annotatedBeanDefinition);
    MethodMetadata getFactoryMethodMetadata(AnnotatedBeanDefinition annotatedBeanDefinition);
    Class getGenericTypeOfReturnType(MethodMetadata factoryMethodMetadata);
}