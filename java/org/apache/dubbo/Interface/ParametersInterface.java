package org.apache.dubbo.Interface;

import java.util.Map;
import java.lang.Class;
import java.lang.String;
import java.lang.Object;

public interface ParametersInterface {

    Map<String, String> getParameters();

    <T> T getExtension(Class<T> type, String key);

    <T> T getExtension(Class<T> type, String key, String defaultValue);

    <T> T getMethodExtension(Class<T> type, String method, String key);

    <T> T getMethodExtension(Class<T> type, String method, String key, String defaultValue);

    String getDecodedParameter(String key);

    String getDecodedParameter(String key, String defaultValue);

    String getParameter(String key);

    String getParameter(String key, String defaultValue);

    int getIntParameter(String key);

    int getIntParameter(String key, int defaultValue);

    int getPositiveIntParameter(String key, int defaultValue);

    boolean getBooleanParameter(String key);

    boolean getBooleanParameter(String key, boolean defaultValue);

    boolean hasParameter(String key);

    String getMethodParameter(String method, String key);

    String getMethodParameter(String method, String key, String defaultValue);

    int getMethodIntParameter(String method, String key);

    int getMethodIntParameter(String method, String key, int defaultValue);

    int getMethodPositiveIntParameter(String method, String key, int defaultValue);

    boolean getMethodBooleanParameter(String method, String key);

    boolean getMethodBooleanParameter(String method, String key, boolean defaultValue);

    boolean hasMethodParameter(String method, String key);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
