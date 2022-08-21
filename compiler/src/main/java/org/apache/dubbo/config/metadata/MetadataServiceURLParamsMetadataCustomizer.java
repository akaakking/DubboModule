package org.apache.dubbo.config.metadata;

import org.apache.dubbo.registry.client.ServiceInstance;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataServiceURLParamsMetadataCustomizer implements MetadataServiceURLParamsMetadataCustomizerInterface {

    public void customize(ServiceInstanceInterface serviceInstance, ApplicationModelInterface applicationModel) {
        instance.customize(((ServiceInstance) serviceInstance).getInternalInstance(), ((ApplicationModel) applicationModel).getInternalInstance());
    }

    protected MetadataServiceURLParamsMetadataCustomizerInterface instance;

    public MetadataServiceURLParamsMetadataCustomizerInterface getInternalInstance() {
        return instance;
    }

    protected MetadataServiceURLParamsMetadataCustomizer() {
        instance = (MetadataServiceURLParamsMetadataCustomizerInterface) DubboClassLoader.getInstance(MetadataServiceURLParamsMetadataCustomizer.class.getName());
    }
}
