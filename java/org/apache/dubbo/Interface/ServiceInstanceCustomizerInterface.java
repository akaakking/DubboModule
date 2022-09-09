package org.apache.dubbo.Interface;

import org.apache.dubbo.common.lang.Prioritized;
import org.apache.dubbo.registry.client.ServiceInstance;
import org.apache.dubbo.rpc.model.ApplicationModel;

public interface ServiceInstanceCustomizerInterface extends Prioritized {

    void customize(ServiceInstance serviceInstance, ApplicationModelInterface applicationModel);
}
