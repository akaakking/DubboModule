package org.apache.dubbo.Interface;

import java.lang.String;
import java.util.Map;
import org.apache.dubbo.Interface.URLParamInterface;
import java.lang.Object;

public interface URLParamInterface {

    boolean hasMethodParameter(String method);

    String getMethodParameter(String method, String key);

    String getMethodParameterStrict(String method, String key);

    Map<String, String> getParameters();

    String getAnyMethodParameter(String key);

    URLParamInterface addParameter(String key, String value);

    URLParamInterface addParameterIfAbsent(String key, String value);

    URLParamInterface addParameters(Map<String, String> parameters);

    URLParamInterface addParametersIfAbsent(Map<String, String> parameters);

    URLParamInterface removeParameters(String keys);

    URLParamInterface clearParameters();

    boolean hasParameter(String key);

    String getParameter(String key);

    String getRawParam();

    long getTimestamp();

    void setTimestamp(long timestamp);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
