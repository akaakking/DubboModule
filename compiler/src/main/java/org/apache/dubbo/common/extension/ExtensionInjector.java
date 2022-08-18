package org.apache.dubbo.common.extension;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionInjector implements ExtensionInjectorInterface {

    public <T> T getInstance(Class<T> type, String name) {
        return instance.getInstance(type, name);
    }

    public void setExtensionAccessor(ExtensionAccessorInterface extensionAccessor) {
        instance.setExtensionAccessor(extensionAccessor);
    }
}
