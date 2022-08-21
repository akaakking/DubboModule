package org.apache.dubbo.config.spring.util;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.core.env.ConfigurableEnvironment;
import java.util.SortedMap;

public class EnvironmentUtils implements EnvironmentUtilsInterface {

    protected EnvironmentUtilsInterface instance;

    public static Map<String, Object> extractProperties(ConfigurableEnvironment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(EnvironmentUtils.class.getName());
        Method method = klass.getMethod("extractProperties", ConfigurableEnvironment.class);
        return (Map<String, Object>)method.invoke(environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static SortedMap<String, String> filterDubboProperties(ConfigurableEnvironment environment) {
        try { 
          Class klass = DubboClassLoader.getKlass(EnvironmentUtils.class.getName());
        Method method = klass.getMethod("filterDubboProperties", ConfigurableEnvironment.class);
        return (SortedMap<String, String>)method.invoke(environment);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public EnvironmentUtilsInterface getInternalInstance() {
        return instance;
    }

    protected EnvironmentUtils() {
        instance = (EnvironmentUtilsInterface) DubboClassLoader.getInstance(EnvironmentUtils.class.getName());
    }
}
