package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface SpringCompatUtilsInterface{
    TInterface getPropertyValue(org.springframework.beans.PropertyValues pvs, String propertyName);
    boolean isFactoryMethodMetadataEnabled();
    String getFactoryMethodReturnType(org.springframework.beans.factory.annotation.AnnotatedBeanDefinition annotatedBeanDefinition);
    org.springframework.core.type.MethodMetadata getFactoryMethodMetadata(org.springframework.beans.factory.annotation.AnnotatedBeanDefinition annotatedBeanDefinition);
    Class getGenericTypeOfReturnType(org.springframework.core.type.MethodMetadata factoryMethodMetadata);

}