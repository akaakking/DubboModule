package org.apache.dubbo.Interface;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Result;

public interface DelegateProviderMetaDataInvokerInterface<T> extends Object, Invoker{
    Class getInterface();
    URL getUrl();
    boolean isAvailable();
    Result invoke(Invocation invocation);
    void destroy();
    ServiceConfigInterface<T> getMetadata();
}