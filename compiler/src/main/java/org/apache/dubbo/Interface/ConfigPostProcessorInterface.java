package org.apache.dubbo.Interface;


public interface ConfigPostProcessorInterface {
    void postProcessReferConfig(ReferenceConfigInterface<T> referenceConfig);
    void postProcessServiceConfig(ServiceConfigInterface<T> serviceConfig);
}