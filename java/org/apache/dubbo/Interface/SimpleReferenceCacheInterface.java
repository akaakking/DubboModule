package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.Interface.ReferenceConfigBaseInterface;
import java.lang.String;
import java.lang.Class;
import java.util.List;
import java.util.Map;

public interface SimpleReferenceCacheInterface extends ReferenceCache {

    <T> T get(ReferenceConfigBaseInterface<T> rc);

    <T> T get(String key, Class<T> type);

    <T> T get(String key);

    <T> List<T> getAll(Class<T> type);

    <T> T get(Class<T> type);

    void destroy(String key, Class<?> type);

    void destroy(Class<?> type);

    <T> void destroy(ReferenceConfigBaseInterface<T> referenceConfig);

    void destroyAll();

    Map<String, List<ReferenceConfigBaseInterface<?>>> getReferenceMap();

    Map<Class<?>, List<ReferenceConfigBaseInterface<?>>> getReferenceTypeMap();

    String toString();
}
