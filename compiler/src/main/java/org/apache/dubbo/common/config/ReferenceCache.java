package org.apache.dubbo.common.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceCache implements ReferenceCacheInterface {

    public <T> T get(ReferenceConfigBaseInterface<T> referenceConfig) {
        return instance.get(referenceConfig);
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
}
