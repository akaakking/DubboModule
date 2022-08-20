package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.core.type.MethodMetadata;

public class SpringCompatUtils implements SpringCompatUtilsInterface {

    protected SpringCompatUtilsInterface instance;

    public static <T> T getPropertyValue(PropertyValues pvs, String propertyName) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getPropertyValue, PropertyValues.class, String.class);
        return method.invoke(pvs, propertyName);
    }

    public static boolean isFactoryMethodMetadataEnabled() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(isFactoryMethodMetadataEnabled);
        return method.invoke();
    }

    public static String getFactoryMethodReturnType(AnnotatedBeanDefinition annotatedBeanDefinition) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getFactoryMethodReturnType, AnnotatedBeanDefinition.class);
        return method.invoke(annotatedBeanDefinition);
    }

    public static MethodMetadata getFactoryMethodMetadata(AnnotatedBeanDefinition annotatedBeanDefinition) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getFactoryMethodMetadata, AnnotatedBeanDefinition.class);
        return method.invoke(annotatedBeanDefinition);
    }

    public static Class getGenericTypeOfReturnType(MethodMetadata factoryMethodMetadata) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getGenericTypeOfReturnType, MethodMetadata.class);
        return method.invoke(factoryMethodMetadata);
    }

    public SpringCompatUtilsInterface getInternalInstance() {
        return instance;
    }

    public SpringCompatUtilsInterface getInternalInstance() {
        return instance;
    }
}
