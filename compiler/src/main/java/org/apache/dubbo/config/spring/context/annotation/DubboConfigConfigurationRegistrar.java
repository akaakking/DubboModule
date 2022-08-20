package org.apache.dubbo.config.spring.context.annotation;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigConfigurationRegistrar implements DubboConfigConfigurationRegistrarInterface {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        instance.registerBeanDefinitions(importingClassMetadata, registry);
    }

    protected DubboConfigConfigurationRegistrarInterface instance;

    public DubboConfigConfigurationRegistrarInterface getInternalInstance() {
        return instance;
    }
}
