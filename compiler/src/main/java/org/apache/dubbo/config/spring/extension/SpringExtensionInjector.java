package org.apache.dubbo.config.spring.extension;

import org.springframework.context.ApplicationContext;
import java.lang.Class;
import java.lang.String;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.apache.dubbo.common.extension.ExtensionAccessor;

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
        try { 
          Class klass = DubboClassLoader.getKlass(SpringExtensionInjector.class.getName());
        Method method = klass.getMethod("addApplicationContext", ApplicationContext.class);
        method.invoke(context);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static SpringExtensionInjectorInterface get(ExtensionAccessorInterface extensionAccessor) {
        try { 
          Class klass = DubboClassLoader.getKlass(SpringExtensionInjector.class.getName());
        Method method = klass.getMethod("get", ExtensionAccessorInterface.class);
        return (SpringExtensionInjectorInterface)method.invoke(extensionAccessor);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public SpringExtensionInjectorInterface getInternalInstance() {
        return instance;
    }

    protected SpringExtensionInjector() {
        instance = (SpringExtensionInjectorInterface) DubboClassLoader.getInstance(SpringExtensionInjector.class.getName());
    }
}
