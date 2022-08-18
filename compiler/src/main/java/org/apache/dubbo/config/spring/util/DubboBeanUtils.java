package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.config.annotation.Service;
import java.util.Map;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBeanUtils implements DubboBeanUtilsInterface {

    public static void registerCommonBeans(BeanDefinitionRegistry registry) {
        Method method = instance.getClass().getMethod(BeanDefinitionRegistry.class);
        method.invoke(registry);
    }

    public static boolean registerInfrastructureBean(BeanDefinitionRegistry beanDefinitionRegistry, String beanName, Class<?> beanType) {
        Method method = instance.getClass().getMethod(BeanDefinitionRegistry.class, String.class, Class.class);
        return method.invoke(beanDefinitionRegistry, beanName, beanType);
    }

    public static void registerPlaceholderConfigurerBeanIfNotExists(ConfigurableListableBeanFactory beanFactory, BeanDefinitionRegistry registry) {
        Method method = instance.getClass().getMethod(ConfigurableListableBeanFactory.class, BeanDefinitionRegistry.class);
        method.invoke(beanFactory, registry);
    }

    public static boolean registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass, Map<String, Object> extraPropertyValues) {
        Method method = instance.getClass().getMethod(BeanDefinitionRegistry.class, String.class, Class.class, Map.class);
        return method.invoke(registry, beanName, beanClass, extraPropertyValues);
    }

    public static boolean checkBeanExists(ConfigurableListableBeanFactory beanFactory, Class<?> targetClass) {
        Method method = instance.getClass().getMethod(ConfigurableListableBeanFactory.class, Class.class);
        return method.invoke(beanFactory, targetClass);
    }

    public static ReferenceAnnotationBeanPostProcessor getReferenceAnnotationBeanPostProcessor(AbstractBeanFactory beanFactory) {
        Method method = instance.getClass().getMethod(AbstractBeanFactory.class);
        return method.invoke(beanFactory);
    }

    public static ReferenceAnnotationBeanPostProcessor getReferenceAnnotationBeanPostProcessor(ApplicationContext applicationContext) {
        Method method = instance.getClass().getMethod(ApplicationContext.class);
        return method.invoke(applicationContext);
    }

    public static DubboSpringInitContextInterface getInitializationContext(BeanFactory beanFactory) {
        Method method = instance.getClass().getMethod(BeanFactory.class);
        return method.invoke(beanFactory);
    }

    public static ApplicationModelInterface getApplicationModel(BeanFactory beanFactory) {
        Method method = instance.getClass().getMethod(BeanFactory.class);
        return method.invoke(beanFactory);
    }

    public static ModuleModelInterface getModuleModel(BeanFactory beanFactory) {
        Method method = instance.getClass().getMethod(BeanFactory.class);
        return method.invoke(beanFactory);
    }
}
