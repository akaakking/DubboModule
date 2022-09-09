package org.apache.dubbo.Interface;

import java.util.List;
import org.apache.dubbo.registry.client.ServiceInstance;

public interface ServiceInstancesChangedEventInterface {

    String getServiceName();

    List<ServiceInstance> getServiceInstances();
}
