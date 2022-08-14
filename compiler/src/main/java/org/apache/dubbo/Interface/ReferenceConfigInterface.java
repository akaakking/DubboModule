package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.rpc;
import java.util.concurrent;

public interface ReferenceConfigInterface<T>{
    String getServices();
    Set getSubscribedServices();
    void setServices(String services);
    TInterface get();
    void destroy();
    Invoker getInvoker();
    Callable getDestroyRunner();

}