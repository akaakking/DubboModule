package org.apache.dubbo.config.spring.extension;

import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringExtensionInjector implements SpringExtensionInjectorInterface {

    public ApplicationContext getContext() {
        return instance.getContext();
    }

    public void init(ApplicationContext context) {
        instance.init(context);
    }

    public <T> T getInstance(Class<T> type, String name) {
        return instance.getInstance(type, name);
    }

    protected SpringExtensionInjectorInterface instance;

    public static void addApplicationContext(ApplicationContext context) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(addApplicationContext, ApplicationContext.class);
        method.invoke(context);
    }

    public static SpringExtensionInjectorInterface get(ExtensionAccessorInterface extensionAccessor) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(get, ExtensionAccessorInterface.class);
        return method.invoke(extensionAccessor);
    }

    public SpringExtensionInjectorInterface getInternalInstance() {
        return instance;
    }

    public SpringExtensionInjectorInterface getInternalInstance() {
        return instance;
    }
}
