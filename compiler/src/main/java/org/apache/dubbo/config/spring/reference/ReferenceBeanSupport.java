package org.apache.dubbo.config.spring.reference;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;

public class ReferenceBeanSupport implements ReferenceBeanSupportInterface {

    protected ReferenceBeanSupportInterface instance;

    public static void convertReferenceProps(Map<String, Object> attributes, Class defaultInterfaceClass) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(convertReferenceProps, Map.class, Class.class);
        method.invoke(attributes, defaultInterfaceClass);
    }

    public static String generateReferenceKey(Map<String, Object> attributes, ApplicationContext applicationContext) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(generateReferenceKey, Map.class, ApplicationContext.class);
        return method.invoke(attributes, applicationContext);
    }

    public static Map<String, Object> convertPropertyValues(MutablePropertyValues propertyValues) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(convertPropertyValues, MutablePropertyValues.class);
        return method.invoke(propertyValues);
    }

    public static String generateReferenceKey(ReferenceBeanInterface referenceBean, ApplicationContext applicationContext) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(generateReferenceKey, ReferenceBeanInterface.class, ApplicationContext.class);
        return method.invoke(referenceBean, applicationContext);
    }

    public static String generateReferenceKey(BeanDefinition beanDefinition, ApplicationContext applicationContext) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(generateReferenceKey, BeanDefinition.class, ApplicationContext.class);
        return method.invoke(beanDefinition, applicationContext);
    }

    public static Map<String, Object> getReferenceAttributes(ReferenceBeanInterface referenceBean) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getReferenceAttributes, ReferenceBeanInterface.class);
        return method.invoke(referenceBean);
    }

    public static Map<String, Object> getReferenceAttributes(BeanDefinition beanDefinition) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getReferenceAttributes, BeanDefinition.class);
        return method.invoke(beanDefinition);
    }

    public ReferenceBeanSupportInterface getInternalInstance() {
        return instance;
    }

    public ReferenceBeanSupportInterface getInternalInstance() {
        return instance;
    }
}
