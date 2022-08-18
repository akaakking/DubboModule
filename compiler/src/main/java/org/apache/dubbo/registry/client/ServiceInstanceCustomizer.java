package org.apache.dubbo.registry.client;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceInstanceCustomizer implements ServiceInstanceCustomizerInterface {

    public void customize(ServiceInstanceInterface serviceInstance, ApplicationModelInterface applicationModel) {
        instance.customize(serviceInstance, applicationModel);
    }
}
