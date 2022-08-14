package org.apache.dubbo.Interface;


public interface ConfigInitializerInterface{
    void initReferConfig(ReferenceConfigInterface referenceConfig);
    void initServiceConfig(ServiceConfigInterface serviceConfig);

}