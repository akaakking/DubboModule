package org.apache.dubbo.Interface;

import java.util.concurrent.Callable;

public interface ServiceConfigInterface<T> extends ServiceConfigBase, org.apache.dubbo.Interface.ServiceConfigInterface{
    boolean isExported();
    boolean isUnexported();
    void unexport();
    void init();
    void export();
    void addServiceListener(ServiceListenerInterface listener);
    Callable getDestroyRunner();
}