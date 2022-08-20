package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;

public class DubboSpringInitializer implements DubboSpringInitializerInterface {

    protected DubboSpringInitializerInterface instance;

    public static void initialize(BeanDefinitionRegistryInterface registry) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(initialize, BeanDefinitionRegistry.class);
        method.invoke(registry);
    }

    public static boolean remove(BeanDefinitionRegistryInterface registry) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(remove, BeanDefinitionRegistry.class);
        return method.invoke(registry);
    }

    public static boolean remove(ApplicationContextInterface springContext) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(remove, ApplicationContext.class);
        return method.invoke(springContext);
    }
}
