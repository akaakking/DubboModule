package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.annotation.Service;
import java.util.Map;
import org.apache.dubbo.config.annotation.Reference;

public class DubboAnnotationUtils implements DubboAnnotationUtilsInterface {

    protected DubboAnnotationUtilsInterface instance;

    public static StringInterface resolveInterfaceName(ServiceInterface service, Class<?> defaultInterfaceClass) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(resolveInterfaceName, Service.class, Class.class);
        return method.invoke(service, defaultInterfaceClass);
    }

    public static StringInterface resolveInterfaceName(Map<String, Object> attributes, Class<?> defaultInterfaceClass) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(resolveInterfaceName, Map.class, Class.class);
        return method.invoke(attributes, defaultInterfaceClass);
    }

    public static StringInterface resolveInterfaceName(ReferenceInterface reference, Class<?> defaultInterfaceClass) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(resolveInterfaceName, Reference.class, Class.class);
        return method.invoke(reference, defaultInterfaceClass);
    }

    public static Map<String, String> convertParameters(StringInterface[] parameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(convertParameters, String[].class);
        return method.invoke(parameters);
    }
}
