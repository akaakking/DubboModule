package org.apache.dubbo.config.utils;

import org.apache.dubbo.config.ReferenceConfigBase;
import java.lang.String;
import java.lang.Class;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.apache.dubbo.config.utils.SimpleReferenceCache.KeyGenerator;

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

    public Map<String, List<ReferenceConfigBaseInterface<?>>> getReferenceMap() {
        return instance.getReferenceMap();
    }

    public Map<Class<?>, List<ReferenceConfigBaseInterface<?>>> getReferenceTypeMap() {
        return instance.getReferenceTypeMap();
    }

    public String toString() {
        return instance.toString();
    }

    protected SimpleReferenceCacheInterface instance;

    public static SimpleReferenceCacheInterface getCache() {
        try { 
          Class klass = DubboClassLoader.getKlass(SimpleReferenceCache.class.getName());
        Method method = klass.getMethod("getCache");
        return (SimpleReferenceCacheInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static SimpleReferenceCacheInterface newCache() {
        try { 
          Class klass = DubboClassLoader.getKlass(SimpleReferenceCache.class.getName());
        Method method = klass.getMethod("newCache");
        return (SimpleReferenceCacheInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static SimpleReferenceCacheInterface getCache(String name) {
        try { 
          Class klass = DubboClassLoader.getKlass(SimpleReferenceCache.class.getName());
        Method method = klass.getMethod("getCache", String.class);
        return (SimpleReferenceCacheInterface)method.invoke(name);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static SimpleReferenceCacheInterface getCache(String name, KeyGeneratorInterface keyGenerator) {
        try { 
          Class klass = DubboClassLoader.getKlass(SimpleReferenceCache.class.getName());
        Method method = klass.getMethod("getCache", String.class, KeyGeneratorInterface.class);
        return (SimpleReferenceCacheInterface)method.invoke(name, keyGenerator);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public SimpleReferenceCacheInterface getInternalInstance() {
        return instance;
    }

    protected SimpleReferenceCache() {
        instance = (SimpleReferenceCacheInterface) DubboClassLoader.getInstance(SimpleReferenceCache.class.getName());
    }
}
