package org.apache.dubbo.Interface;


public interface ServiceListenerInterface {
    void exported(ServiceConfigInterface<T> sc);
    void unexported(ServiceConfigInterface<T> sc);
}