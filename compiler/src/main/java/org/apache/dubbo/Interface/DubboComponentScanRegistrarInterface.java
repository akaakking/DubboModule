package org.apache.dubbo.Interface;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public interface DubboComponentScanRegistrarInterface extends Object, org.springframework.context.annotation.ImportBeanDefinitionRegistrar{
    void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);
}