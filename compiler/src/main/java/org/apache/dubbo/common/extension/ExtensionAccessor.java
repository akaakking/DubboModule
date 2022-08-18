package org.apache.dubbo.common.extension;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionAccessor implements ExtensionAccessorInterface {

    public ExtensionDirectorInterface getExtensionDirector() {
        return instance.getExtensionDirector();
    }

    public <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type) {
        return instance.getExtensionLoader(type);
    }

    public <T> T getExtension(Class<T> type, String name) {
        return instance.getExtension(type, name);
    }

    public <T> T getAdaptiveExtension(Class<T> type) {
        return instance.getAdaptiveExtension(type);
    }

    public <T> T getDefaultExtension(Class<T> type) {
        return instance.getDefaultExtension(type);
    }
}
