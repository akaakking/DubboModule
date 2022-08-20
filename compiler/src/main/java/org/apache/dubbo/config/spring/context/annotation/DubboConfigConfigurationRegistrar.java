package org.apache.dubbo.config.spring.context.annotation;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigConfigurationRegistrar implements DubboConfigConfigurationRegistrarInterface {

    public void registerBeanDefinitions(AnnotationMetadataInterface importingClassMetadata, BeanDefinitionRegistryInterface registry) {
        instance.registerBeanDefinitions(importingClassMetadata, registry);
    }

    protected DubboConfigConfigurationRegistrarInterface instance;
}
