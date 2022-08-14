package org.apache.dubbo.Interface;

import java.lang;
import org.apache.dubbo.rpc;
import org.apache.dubbo.common;

public interface DelegateProviderMetaDataInvokerInterface<T>{
    Class getInterface();
    URL getUrl();
    boolean isAvailable();
    Result invoke(Invocation invocation);
    void destroy();
    ServiceConfigInterface getMetadata();

}