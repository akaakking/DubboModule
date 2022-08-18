package org.apache.dubbo.config.spring.context.annotation;

import org.springframework.core.env.ConfigurableEnvironment;
import java.util.Map;
import java.util.SortedMap;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboComponentScanRegistrar implements DubboComponentScanRegistrarInterface {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        instance.registerBeanDefinitions(importingClassMetadata, registry);
    }
}
