package org.apache.dubbo.Interface;

import ;

public interface DubboComponentScanRegistrarInterface{
    void registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata importingClassMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry registry);

}