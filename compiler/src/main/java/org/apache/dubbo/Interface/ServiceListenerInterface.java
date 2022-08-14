package org.apache.dubbo.Interface;


public interface ServiceListenerInterface{
    void exported(ServiceConfigInterface sc);
    void unexported(ServiceConfigInterface sc);

}