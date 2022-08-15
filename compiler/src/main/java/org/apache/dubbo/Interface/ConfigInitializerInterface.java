package org.apache.dubbo.Interface;


public interface ConfigInitializerInterface {
    void initReferConfig(ReferenceConfigInterface<T> referenceConfig);
    void initServiceConfig(ServiceConfigInterface<T> serviceConfig);
}