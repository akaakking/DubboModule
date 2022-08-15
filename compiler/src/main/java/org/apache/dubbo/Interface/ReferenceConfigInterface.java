package org.apache.dubbo.Interface;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.dubbo.rpc.Invoker;

public interface ReferenceConfigInterface<T> {
    String getServices();
    Set getSubscribedServices();
    void setServices(String services);
    T get();
    void destroy();
    Invoker<T> getInvoker();
    Callable getDestroyRunner();
}