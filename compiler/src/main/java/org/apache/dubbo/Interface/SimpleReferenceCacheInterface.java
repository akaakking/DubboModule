package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Map;

public interface SimpleReferenceCacheInterface {
    SimpleReferenceCacheInterface getCache();
    SimpleReferenceCacheInterface newCache();
    SimpleReferenceCacheInterface getCache(String name);
    SimpleReferenceCacheInterface getCache(String name, KeyGeneratorInterface<T> keyGenerator);
    T get(ReferenceConfigBaseInterface<T> rc);
    T get(String key, Class type);
    T get(String key);
    List getAll(Class type);
    T get(Class type);
    void destroy(String key, Class type);
    void destroy(Class type);
    void destroy(ReferenceConfigBaseInterface<T> referenceConfig);
    void destroyAll();
    Map getReferenceMap();
    Map getReferenceTypeMap();
    String toString();
}