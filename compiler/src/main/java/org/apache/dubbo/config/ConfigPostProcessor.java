package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigPostProcessor implements ConfigPostProcessorInterface {

    public void postProcessReferConfig(ReferenceConfigInterface referenceConfig) {
        instance.postProcessReferConfig(referenceConfig);
    }

    public void postProcessServiceConfig(ServiceConfigInterface serviceConfig) {
        instance.postProcessServiceConfig(serviceConfig);
    }
}
