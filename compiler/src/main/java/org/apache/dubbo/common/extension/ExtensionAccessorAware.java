package org.apache.dubbo.common.extension;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionAccessorAware implements ExtensionAccessorAwareInterface {

    public void setExtensionAccessor(ExtensionAccessorInterface extensionAccessor) {
        instance.setExtensionAccessor(extensionAccessor);
    }
}
