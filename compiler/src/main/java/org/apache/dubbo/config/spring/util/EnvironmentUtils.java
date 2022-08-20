package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.core.env.ConfigurableEnvironment;
import java.util.Map;
import java.util.SortedMap;

public class EnvironmentUtils implements EnvironmentUtilsInterface {

    protected EnvironmentUtilsInterface instance;

    public static Map<String, Object> extractProperties(ConfigurableEnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(extractProperties, ConfigurableEnvironment.class);
        return method.invoke(environment);
    }

    public static SortedMap<String, String> filterDubboProperties(ConfigurableEnvironmentInterface environment) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(filterDubboProperties, ConfigurableEnvironment.class);
        return method.invoke(environment);
    }
}
