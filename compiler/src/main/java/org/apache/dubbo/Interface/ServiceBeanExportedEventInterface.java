package org.apache.dubbo.Interface;


public interface ServiceBeanExportedEventInterface extends org.springframework.context.ApplicationEvent{
    ServiceBeanInterface<T> getServiceBean();
}