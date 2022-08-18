package org.apache.dubbo.config.utils;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SimpleReferenceCache implements SimpleReferenceCacheInterface {

    public <T> T get(ReferenceConfigBaseInterface<T> rc) {
        return instance.get(rc);
    }

    public <T> T get(String key, Class<T> type) {
        return instance.get(key, type);
    }

    public <T> T get(String key) {
        return instance.get(key);
    }

    public <T> List<T> getAll(Class<T> type) {
        return instance.getAll(type);
    }

    public <T> T get(Class<T> type) {
        return instance.get(type);
    }

    public void destroy(String key, Class<?> type) {
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

    public Map<String, List<ReferenceConfigBase<?>>> getReferenceMap() {
        return instance.getReferenceMap();
    }

    public Map<Class<?>, List<ReferenceConfigBase<?>>> getReferenceTypeMap() {
        return instance.getReferenceTypeMap();
    }

    public String toString() {
        return instance.toString();
    }

    public static SimpleReferenceCacheInterface getCache() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static SimpleReferenceCacheInterface newCache() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static SimpleReferenceCacheInterface getCache(String name) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(name);
    }

    public static SimpleReferenceCacheInterface getCache(String name, KeyGeneratorInterface keyGenerator) {
        Method method = instance.getClass().getMethod(String.class, KeyGeneratorInterface.class);
        return method.invoke(name, keyGenerator);
    }
}
