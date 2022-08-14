package org.apache.dubbo.Interface;

import ;
import org.apache.dubbo.common.extension;
import java.lang;

public interface SpringExtensionInjectorInterface{
    void addApplicationContext(org.springframework.context.ApplicationContext context);
    SpringExtensionInjectorInterface get(ExtensionAccessor extensionAccessor);
    org.springframework.context.ApplicationContext getContext();
    void init(org.springframework.context.ApplicationContext context);
    TInterface getInstance(Class type, String name);

}