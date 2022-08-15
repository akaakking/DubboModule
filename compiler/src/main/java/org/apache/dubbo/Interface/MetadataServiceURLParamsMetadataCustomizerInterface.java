package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.registry.client.ServiceInstance;

public interface MetadataServiceURLParamsMetadataCustomizerInterface {
    void customize(ServiceInstance serviceInstance, ApplicationModel applicationModel);
}