package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboSpringInitializer implements DubboSpringInitializerInterface {

    public static void initialize(BeanDefinitionRegistry registry) {
        Method method = instance.getClass().getMethod(BeanDefinitionRegistry.class);
        method.invoke(registry);
    }

    public static boolean remove(BeanDefinitionRegistry registry) {
        Method method = instance.getClass().getMethod(BeanDefinitionRegistry.class);
        return method.invoke(registry);
    }

    public static boolean remove(ApplicationContext springContext) {
        Method method = instance.getClass().getMethod(ApplicationContext.class);
        return method.invoke(springContext);
    }
}
