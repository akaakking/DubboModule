package org.apache.dubbo.rpc.model;

import java.util.Collection;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceRepository implements ServiceRepositoryInterface {

    public void destroy() {
        instance.destroy();
    }

    public Collection<ConsumerModelInterface> allConsumerModels() {
        return instance.allConsumerModels();
    }

    public Collection<ProviderModelInterface> allProviderModels() {
        return instance.allProviderModels();
    }

    protected ServiceRepositoryInterface instance;

    public ServiceRepository(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ServiceRepositoryInterface) DubboClassLoader.getInstance(ServiceRepository.class.getName(), params, args);
    }
}
