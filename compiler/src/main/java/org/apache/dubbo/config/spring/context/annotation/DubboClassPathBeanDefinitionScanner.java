package org.apache.dubbo.config.spring.context.annotation;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboClassPathBeanDefinitionScanner implements DubboClassPathBeanDefinitionScannerInterface {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        return instance.findCandidateComponents(basePackage);
    }

    protected DubboClassPathBeanDefinitionScannerInterface instance;

    public DubboClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader) {
        Class[] params = new Class[]{BeanDefinitionRegistry.class, boolean.class, Environment.class, ResourceLoader.class};
        Object[] args = new Object[]{registry, useDefaultFilters, environment, resourceLoader};
        instance = (DubboClassPathBeanDefinitionScannerInterface) DubboClassLoader.getInstance(DubboClassPathBeanDefinitionScanner.class.getName(), params, args);
    }

    public DubboClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, Environment environment, ResourceLoader resourceLoader) {
        Class[] params = new Class[]{BeanDefinitionRegistry.class, Environment.class, ResourceLoader.class};
        Object[] args = new Object[]{registry, environment, resourceLoader};
        instance = (DubboClassPathBeanDefinitionScannerInterface) DubboClassLoader.getInstance(DubboClassPathBeanDefinitionScanner.class.getName(), params, args);
    }
}
