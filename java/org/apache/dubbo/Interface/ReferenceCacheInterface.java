package org.apache.dubbo.Interface;

import org.apache.dubbo.config.ReferenceConfigBase;
import java.lang.String;
import java.lang.Class;
import java.util.List;

public interface ReferenceCacheInterface {

    <T> T get(ReferenceConfigBaseInterface<T> referenceConfig);

    <T> T get(String key, Class<T> type);

    <T> T get(String key);

    <T> List<T> getAll(Class<T> type);

    <T> T get(Class<T> type);

    void destroy(String key, Class<?> type);

    void destroy(Class<?> type);

    <T> void destroy(ReferenceConfigBaseInterface<T> referenceConfig);

    void destroyAll();
}
