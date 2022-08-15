package org.apache.dubbo.Interface;

import java.util.List;

public interface CompositeReferenceCacheInterface extends Object, ReferenceCache{
    T get(ReferenceConfigBaseInterface<T> referenceConfig);
    T get(String key, Class type);
    T get(String key);
    List getAll(Class type);
    T get(Class type);
    void destroy(String key, Class type);
    void destroy(Class type);
    void destroy(ReferenceConfigBaseInterface<T> referenceConfig);
    void destroyAll();
}