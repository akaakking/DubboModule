package org.apache.dubbo.config.spring.util;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import java.util.Map;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringCompatUtils implements SpringCompatUtilsInterface {

    public static <T> T getPropertyValue(PropertyValues pvs, String propertyName) {
        Method method = instance.getClass().getMethod(PropertyValues.class, String.class);
        return method.invoke(pvs, propertyName);
    }

    public static boolean isFactoryMethodMetadataEnabled() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static String getFactoryMethodReturnType(AnnotatedBeanDefinition annotatedBeanDefinition) {
        Method method = instance.getClass().getMethod(AnnotatedBeanDefinition.class);
        return method.invoke(annotatedBeanDefinition);
    }

    public static MethodMetadata getFactoryMethodMetadata(AnnotatedBeanDefinition annotatedBeanDefinition) {
        Method method = instance.getClass().getMethod(AnnotatedBeanDefinition.class);
        return method.invoke(annotatedBeanDefinition);
    }

    public static Class getGenericTypeOfReturnType(MethodMetadata factoryMethodMetadata) {
        Method method = instance.getClass().getMethod(MethodMetadata.class);
        return method.invoke(factoryMethodMetadata);
    }
}
