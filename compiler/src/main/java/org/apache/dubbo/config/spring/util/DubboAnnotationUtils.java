package org.apache.dubbo.config.spring.util;

import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboAnnotationUtils implements DubboAnnotationUtilsInterface {

    public static String resolveInterfaceName(Service service, Class<?> defaultInterfaceClass) {
        Method method = instance.getClass().getMethod(Service.class, Class.class);
        return method.invoke(service, defaultInterfaceClass);
    }

    public static String resolveInterfaceName(Map<String, Object> attributes, Class<?> defaultInterfaceClass) {
        Method method = instance.getClass().getMethod(Map.class, Class.class);
        return method.invoke(attributes, defaultInterfaceClass);
    }

    public static String resolveInterfaceName(Reference reference, Class<?> defaultInterfaceClass) {
        Method method = instance.getClass().getMethod(Reference.class, Class.class);
        return method.invoke(reference, defaultInterfaceClass);
    }

    public static Map<String, String> convertParameters(String[] parameters) {
        Method method = instance.getClass().getMethod(String[].class);
        return method.invoke(parameters);
    }
}
