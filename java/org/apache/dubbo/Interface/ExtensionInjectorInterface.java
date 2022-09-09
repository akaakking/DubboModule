package org.apache.dubbo.Interface;

import org.apache.dubbo.common.extension.ExtensionAccessorAware;
import java.lang.Class;
import java.lang.String;
import org.apache.dubbo.common.extension.ExtensionAccessor;

public interface ExtensionInjectorInterface extends ExtensionAccessorAware {

    <T> T getInstance(Class<T> type, String name);

    void setExtensionAccessor(ExtensionAccessor extensionAccessor);
}
