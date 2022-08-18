package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigInitializer implements ConfigInitializerInterface {

    public void initReferConfig(ReferenceConfigInterface referenceConfig) {
        instance.initReferConfig(referenceConfig);
    }

    public void initServiceConfig(ServiceConfigInterface serviceConfig) {
        instance.initServiceConfig(serviceConfig);
    }
}
