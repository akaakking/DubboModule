package org.apache.dubbo.common.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Configuration implements ConfigurationInterface {

    public String getString(String key) {
        return instance.getString(key);
    }

    public String getString(String key, String defaultValue) {
        return instance.getString(key, defaultValue);
    }

    public int getInt(String key) {
        return instance.getInt(key);
    }

    public int getInt(String key, int defaultValue) {
        return instance.getInt(key, defaultValue);
    }

    public Integer getInteger(String key, Integer defaultValue) {
        return instance.getInteger(key, defaultValue);
    }

    public boolean getBoolean(String key) {
        return instance.getBoolean(key);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return instance.getBoolean(key, defaultValue);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return instance.getBoolean(key, defaultValue);
    }

    public Object getProperty(String key) {
        return instance.getProperty(key);
    }

    public Object getProperty(String key, Object defaultValue) {
        return instance.getProperty(key, defaultValue);
    }

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    public boolean containsKey(String key) {
        return instance.containsKey(key);
    }

    public <T> T convert(Class<T> cls, String key, T defaultValue) {
        return instance.convert(cls, key, defaultValue);
    }

    public static Boolean toBooleanObject(boolean bool) {
        Method method = instance.getClass().getMethod(boolean.class);
        return method.invoke(bool);
    }
}
