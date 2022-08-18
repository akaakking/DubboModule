package org.apache.dubbo.rpc.model;

import java.util.Map;
import java.util.Collection;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceRepository implements ServiceRepositoryInterface {

    public void destroy() {
        instance.destroy();
    }

    public Collection<ConsumerModel> allConsumerModels() {
        return instance.allConsumerModels();
    }

    public Collection<ProviderModel> allProviderModels() {
        return instance.allProviderModels();
    }

    public ServiceRepository(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ServiceRepositoryInterface) DubboClassLoader.getInstance(ServiceRepository.class.getName(), params, args);
    }
}
