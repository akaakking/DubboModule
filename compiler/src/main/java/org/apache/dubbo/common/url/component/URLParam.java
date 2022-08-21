package org.apache.dubbo.common.url.component;

import java.lang.String;
import java.util.Map;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;

public class URLParam implements URLParamInterface {

    public boolean hasMethodParameter(String method) {
        return instance.hasMethodParameter(method);
    }

    public String getMethodParameter(String method, String key) {
        return instance.getMethodParameter(method, key);
    }

    public String getMethodParameterStrict(String method, String key) {
        return instance.getMethodParameterStrict(method, key);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public String getAnyMethodParameter(String key) {
        return instance.getAnyMethodParameter(key);
    }

    public URLParamInterface addParameter(String key, String value) {
        return instance.addParameter(key, value);
    }

    public URLParamInterface addParameterIfAbsent(String key, String value) {
        return instance.addParameterIfAbsent(key, value);
    }

    public URLParamInterface addParameters(Map<String, String> parameters) {
        return instance.addParameters(parameters);
    }

    public URLParamInterface addParametersIfAbsent(Map<String, String> parameters) {
        return instance.addParametersIfAbsent(parameters);
    }

    public URLParamInterface removeParameters(String keys) {
        return instance.removeParameters(keys);
    }

    public URLParamInterface clearParameters() {
        return instance.clearParameters();
    }

    public boolean hasParameter(String key) {
        return instance.hasParameter(key);
    }

    public String getParameter(String key) {
        return instance.getParameter(key);
    }

    public String getRawParam() {
        return instance.getRawParam();
    }

    public long getTimestamp() {
        return instance.getTimestamp();
    }

    public void setTimestamp(long timestamp) {
        instance.setTimestamp(timestamp);
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public String toString() {
        return instance.toString();
    }

    protected URLParamInterface instance;

    public static Map<String, Map<String, String>> initMethodParameters(Map<String, String> parameters) {
        try { 
          Class klass = DubboClassLoader.getKlass(URLParam.class.getName());
        Method method = klass.getMethod("initMethodParameters", Map.class);
        return (Map<String, Map<String, String>>)method.invoke(parameters);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static URLParamInterface parse(Map<String, String> params) {
        try { 
          Class klass = DubboClassLoader.getKlass(URLParam.class.getName());
        Method method = klass.getMethod("parse", Map.class);
        return (URLParamInterface)method.invoke(params);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static URLParamInterface parse(String rawParam, boolean encoded, Map<String, String> extraParameters) {
        try { 
          Class klass = DubboClassLoader.getKlass(URLParam.class.getName());
        Method method = klass.getMethod("parse", String.class, boolean.class, Map.class);
        return (URLParamInterface)method.invoke(rawParam, encoded, extraParameters);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static URLParamInterface parse(String rawParam) {
        try { 
          Class klass = DubboClassLoader.getKlass(URLParam.class.getName());
        Method method = klass.getMethod("parse", String.class);
        return (URLParamInterface)method.invoke(rawParam);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static URLParamInterface parse(Map<String, String> params, String rawParam) {
        try { 
          Class klass = DubboClassLoader.getKlass(URLParam.class.getName());
        Method method = klass.getMethod("parse", Map.class, String.class);
        return (URLParamInterface)method.invoke(params, rawParam);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public URLParamInterface getInternalInstance() {
        return instance;
    }

    protected URLParam() {
        instance = (URLParamInterface) DubboClassLoader.getInstance(URLParam.class.getName());
    }
}
