package org.apache.dubbo.config.utils;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SimpleReferenceCache implements SimpleReferenceCacheInterface {

    public <T> T get(ReferenceConfigBaseInterface<T> rc) {
        return instance.get(rc);
    }

    public <T> T get(StringInterface key, Class<T> type) {
        return instance.get(key, type);
    }

    public <T> T get(StringInterface key) {
        return instance.get(key);
    }

    public <T> List<T> getAll(Class<T> type) {
        return instance.getAll(type);
    }

    public <T> T get(Class<T> type) {
        return instance.get(type);
    }

    public void destroy(StringInterface key, Class<?> type) {
        instance.destroy(key, type);
    }

    public void destroy(Class<?> type) {
        instance.destroy(type);
    }

    public <T> void destroy(ReferenceConfigBaseInterface<T> referenceConfig) {
        instance.destroy(referenceConfig);
    }

    public void destroyAll() {
        instance.destroyAll();
    }

    public Map<String, List<ReferenceConfigBaseInterface<?>>> getReferenceMap() {
        return instance.getReferenceMap();
    }

    public Map<Class<?>, List<ReferenceConfigBaseInterface<?>>> getReferenceTypeMap() {
        return instance.getReferenceTypeMap();
    }

    public StringInterface toString() {
        return instance.toString();
    }

    protected SimpleReferenceCacheInterface instance;

    public static SimpleReferenceCacheInterface getCache() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getCache);
        return method.invoke();
    }

    public static SimpleReferenceCacheInterface newCache() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newCache);
        return method.invoke();
    }

    public static SimpleReferenceCacheInterface getCache(StringInterface name) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getCache, String.class);
        return method.invoke(name);
    }

    public static SimpleReferenceCacheInterface getCache(StringInterface name, KeyGeneratorInterface keyGenerator) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getCache, String.class, KeyGeneratorInterface.class);
        return method.invoke(name, keyGenerator);
    }
}
