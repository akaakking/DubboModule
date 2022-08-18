package org.apache.dubbo.config.spring.util;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.core.type.MethodMetadata;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class EnvironmentUtils implements EnvironmentUtilsInterface {

    public static Map<String, Object> extractProperties(ConfigurableEnvironment environment) {
        Method method = instance.getClass().getMethod(ConfigurableEnvironment.class);
        return method.invoke(environment);
    }

    public static SortedMap<String, String> filterDubboProperties(ConfigurableEnvironment environment) {
        Method method = instance.getClass().getMethod(ConfigurableEnvironment.class);
        return method.invoke(environment);
    }
}
