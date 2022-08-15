package org.apache.dubbo.Interface;

import java.util.concurrent.Callable;

public interface ServiceConfigInterface<T> {
    boolean isExported();
    boolean isUnexported();
    void unexport();
    void init();
    void export();
    void addServiceListener(ServiceListenerInterface listener);
    Callable getDestroyRunner();
}