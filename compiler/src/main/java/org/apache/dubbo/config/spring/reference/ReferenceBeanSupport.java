package org.apache.dubbo.config.spring.reference;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBeanSupport implements ReferenceBeanSupportInterface {

    public static void convertReferenceProps(Map<String, Object> attributes, Class defaultInterfaceClass) {
        Method method = instance.getClass().getMethod(Map.class, Class.class);
        method.invoke(attributes, defaultInterfaceClass);
    }

    public static String generateReferenceKey(Map<String, Object> attributes, ApplicationContext applicationContext) {
        Method method = instance.getClass().getMethod(Map.class, ApplicationContext.class);
        return method.invoke(attributes, applicationContext);
    }

    public static Map<String, Object> convertPropertyValues(MutablePropertyValues propertyValues) {
        Method method = instance.getClass().getMethod(MutablePropertyValues.class);
        return method.invoke(propertyValues);
    }

    public static String generateReferenceKey(ReferenceBeanInterface referenceBean, ApplicationContext applicationContext) {
        Method method = instance.getClass().getMethod(ReferenceBeanInterface.class, ApplicationContext.class);
        return method.invoke(referenceBean, applicationContext);
    }

    public static String generateReferenceKey(BeanDefinition beanDefinition, ApplicationContext applicationContext) {
        Method method = instance.getClass().getMethod(BeanDefinition.class, ApplicationContext.class);
        return method.invoke(beanDefinition, applicationContext);
    }

    public static Map<String, Object> getReferenceAttributes(ReferenceBeanInterface referenceBean) {
        Method method = instance.getClass().getMethod(ReferenceBeanInterface.class);
        return method.invoke(referenceBean);
    }

    public static Map<String, Object> getReferenceAttributes(BeanDefinition beanDefinition) {
        Method method = instance.getClass().getMethod(BeanDefinition.class);
        return method.invoke(beanDefinition);
    }
}
