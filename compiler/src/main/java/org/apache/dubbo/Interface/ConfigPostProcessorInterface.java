package org.apache.dubbo.Interface;


public interface ConfigPostProcessorInterface{
    void postProcessReferConfig(ReferenceConfigInterface referenceConfig);
    void postProcessServiceConfig(ServiceConfigInterface serviceConfig);

}