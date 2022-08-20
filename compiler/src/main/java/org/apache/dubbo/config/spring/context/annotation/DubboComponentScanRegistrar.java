package org.apache.dubbo.config.spring.context.annotation;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboComponentScanRegistrar implements DubboComponentScanRegistrarInterface {

    public void registerBeanDefinitions(AnnotationMetadataInterface importingClassMetadata, BeanDefinitionRegistryInterface registry) {
        instance.registerBeanDefinitions(importingClassMetadata, registry);
    }

    protected DubboComponentScanRegistrarInterface instance;
}
