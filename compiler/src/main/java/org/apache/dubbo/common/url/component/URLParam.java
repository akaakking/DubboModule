package org.apache.dubbo.common.url.component;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class URLParam implements URLParamInterface {

    public boolean hasMethodParameter(StringInterface method) {
        return instance.hasMethodParameter(method);
    }

    public StringInterface getMethodParameter(StringInterface method, StringInterface key) {
        return instance.getMethodParameter(method, key);
    }

    public StringInterface getMethodParameterStrict(StringInterface method, StringInterface key) {
        return instance.getMethodParameterStrict(method, key);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public StringInterface getAnyMethodParameter(StringInterface key) {
        return instance.getAnyMethodParameter(key);
    }

    public URLParamInterface addParameter(StringInterface key, StringInterface value) {
        return instance.addParameter(key, value);
    }

    public URLParamInterface addParameterIfAbsent(StringInterface key, StringInterface value) {
        return instance.addParameterIfAbsent(key, value);
    }

    public URLParamInterface addParameters(Map<String, String> parameters) {
        return instance.addParameters(parameters);
    }

    public URLParamInterface addParametersIfAbsent(Map<String, String> parameters) {
        return instance.addParametersIfAbsent(parameters);
    }

    public URLParamInterface removeParameters(StringInterface keys) {
        return instance.removeParameters(keys);
    }

    public URLParamInterface clearParameters() {
        return instance.clearParameters();
    }

    public boolean hasParameter(StringInterface key) {
        return instance.hasParameter(key);
    }

    public StringInterface getParameter(StringInterface key) {
        return instance.getParameter(key);
    }

    public StringInterface getRawParam() {
        return instance.getRawParam();
    }

    public long getTimestamp() {
        return instance.getTimestamp();
    }

    public void setTimestamp(long timestamp) {
        instance.setTimestamp(timestamp);
    }

    public boolean equals(ObjectInterface o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public StringInterface toString() {
        return instance.toString();
    }

    protected URLParamInterface instance;

    public static Map<String, Map<String, String>> initMethodParameters(Map<String, String> parameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(initMethodParameters, Map.class);
        return method.invoke(parameters);
    }

    public static URLParamInterface parse(Map<String, String> params) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(parse, Map.class);
        return method.invoke(params);
    }

    public static URLParamInterface parse(StringInterface rawParam, boolean encoded, Map<String, String> extraParameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(parse, String.class, boolean.class, Map.class);
        return method.invoke(rawParam, encoded, extraParameters);
    }

    public static URLParamInterface parse(StringInterface rawParam) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(parse, String.class);
        return method.invoke(rawParam);
    }

    public static URLParamInterface parse(Map<String, String> params, StringInterface rawParam) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(parse, Map.class, String.class);
        return method.invoke(params, rawParam);
    }
}
