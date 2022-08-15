package org.apache.dubbo.Interface;

import org.apache.dubbo.common.extension.ExtensionAccessor;
import org.springframework.context.ApplicationContext;

public interface SpringExtensionInjectorInterface {
    void addApplicationContext(ApplicationContext context);
    SpringExtensionInjectorInterface get(ExtensionAccessor extensionAccessor);
    ApplicationContext getContext();
    void init(ApplicationContext context);
    T getInstance(Class type, String name);
}