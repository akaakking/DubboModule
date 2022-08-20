package org.apache.dubbo.config.metadata;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataServiceURLParamsMetadataCustomizer implements MetadataServiceURLParamsMetadataCustomizerInterface {

    public void customize(ServiceInstanceInterface serviceInstance, ApplicationModelInterface applicationModel) {
        instance.customize(serviceInstance.getInternalInstance(), applicationModel.getInternalInstance());
    }

    protected MetadataServiceURLParamsMetadataCustomizerInterface instance;

    public MetadataServiceURLParamsMetadataCustomizerInterface getInternalInstance() {
        return instance;
    }
}
