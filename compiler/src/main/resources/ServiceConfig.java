package org.apache.dubbo.Interface

import java.util.concurrent

public interface ServiceConfigInterface<T>{
    boolean isExported();
    boolean isUnexported();
    void unexport();
    void init();
    void export();
    void addServiceListener(ServiceListener listener );
    Callable getDestroyRunner();

}