package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface SimpleReferenceCacheInterface{
    SimpleReferenceCacheInterface getCache();
    SimpleReferenceCacheInterface newCache();
    SimpleReferenceCacheInterface getCache(String name);
    SimpleReferenceCacheInterface getCache(String name, KeyGeneratorInterface keyGenerator);
    TInterface get(ReferenceConfigBaseInterface rc);
    TInterface get(String key, Class type);
    TInterface get(String key);
    List getAll(Class type);
    TInterface get(Class type);
    void destroy(String key, Class type);
    void destroy(Class type);
    void destroy(ReferenceConfigBaseInterface referenceConfig);
    void destroyAll();
    Map getReferenceMap();
    Map getReferenceTypeMap();
    String toString();

}