package org.apache.dubbo.Interface;

import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Class;
import T;

public interface ConfigurationInterface {

    String getString(String key);

    String getString(String key, String defaultValue);

    int getInt(String key);

    int getInt(String key, int defaultValue);

    Integer getInteger(String key, Integer defaultValue);

    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defaultValue);

    Boolean getBoolean(String key, Boolean defaultValue);

    Object getProperty(String key);

    Object getProperty(String key, Object defaultValue);

    Object getInternalProperty(String key);

    boolean containsKey(String key);

    <T> T convert(Class<T> cls, String key, T defaultValue);
}
