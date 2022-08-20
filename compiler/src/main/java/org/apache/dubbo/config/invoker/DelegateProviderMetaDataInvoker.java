package org.apache.dubbo.config.invoker;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DelegateProviderMetaDataInvoker<T> implements DelegateProviderMetaDataInvokerInterface<T> {

    public Class<T> getInterface() {
        return instance.getInterface();
    }

    public URLInterface getUrl() {
        return instance.getUrl();
    }

    public boolean isAvailable() {
        return instance.isAvailable();
    }

    public ResultInterface invoke(InvocationInterface invocation) {
        return instance.invoke(invocation);
    }

    public void destroy() {
        instance.destroy();
    }

    public ServiceConfigInterface<?> getMetadata() {
        return instance.getMetadata();
    }

    protected DelegateProviderMetaDataInvokerInterface instance;

    public DelegateProviderMetaDataInvoker(InvokerInterface<T> invoker, ServiceConfigInterface<?> metadata) {
        Class[] params = new Class[]{InvokerInterfaceInvokerInterface<T>.class, ServiceConfigInterfaceServiceConfigInterface<?>.class};
        Object[] args = new Object[]{invoker, metadata};
        instance = (DelegateProviderMetaDataInvokerInterface) DubboClassLoader.getInstance(DelegateProviderMetaDataInvoker.class.getName(), params, args);
    }
}