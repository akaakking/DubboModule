package org.apache.dubbo.common.beans.factory;

import java.util.function.Function;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ScopeBeanFactory implements ScopeBeanFactoryInterface {

    public <T> T registerBean(Class<T> bean) {
        return instance.registerBean(bean);
    }

    public <T> T registerBean(StringInterface name, Class<T> clazz) {
        return instance.registerBean(name, clazz);
    }

    public void registerBean(ObjectInterface bean) {
        instance.registerBean(bean);
    }

    public void registerBean(StringInterface name, ObjectInterface bean) {
        instance.registerBean(name, bean);
    }

    public <T> T getOrRegisterBean(Class<T> type) {
        return instance.getOrRegisterBean(type);
    }

    public <T> T getOrRegisterBean(StringInterface name, Class<T> type) {
        return instance.getOrRegisterBean(name, type);
    }

    public <T> T getOrRegisterBean(Class<T> type, Function<? super Class<T>, ? extends T> mappingFunction) {
        return instance.getOrRegisterBean(type, mappingFunction);
    }

    public <T> T getOrRegisterBean(StringInterface name, Class<T> type, Function<? super Class<T>, ? extends T> mappingFunction) {
        return instance.getOrRegisterBean(name, type, mappingFunction);
    }

    public <T> T initializeBean(T bean) {
        return instance.initializeBean(bean);
    }

    public <T> T getBean(Class<T> type) {
        return instance.getBean(type);
    }

    public <T> T getBean(StringInterface name, Class<T> type) {
        return instance.getBean(name, type);
    }

    public void destroy() {
        instance.destroy();
    }

    protected ScopeBeanFactoryInterface instance;

    public ScopeBeanFactory(ScopeBeanFactoryInterface parent, ExtensionAccessorInterface extensionAccessor) {
        Class[] params = new Class[]{ScopeBeanFactoryInterface.class, ExtensionAccessorInterface.class};
        Object[] args = new Object[]{parent, extensionAccessor};
        instance = (ScopeBeanFactoryInterface) DubboClassLoader.getInstance(ScopeBeanFactory.class.getName(), params, args);
    }
}
