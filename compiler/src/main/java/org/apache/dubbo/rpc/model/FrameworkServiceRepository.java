package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class FrameworkServiceRepository implements FrameworkServiceRepositoryInterface {

    public void registerProvider(ProviderModelInterface providerModel) {
        instance.registerProvider(providerModel);
    }

    public void unregisterProvider(ProviderModelInterface providerModel) {
        instance.unregisterProvider(providerModel);
    }

    public ProviderModelInterface lookupExportedServiceWithoutGroup(StringInterface key) {
        return instance.lookupExportedServiceWithoutGroup(key);
    }

    public List<ProviderModelInterface> lookupExportedServicesWithoutGroup(StringInterface key) {
        return instance.lookupExportedServicesWithoutGroup(key);
    }

    public void registerProviderUrl(URLInterface url) {
        instance.registerProviderUrl(url);
    }

    public ProviderModelInterface lookupExportedService(StringInterface serviceKey) {
        return instance.lookupExportedService(serviceKey);
    }

    public List<URLInterface> lookupRegisteredProviderUrlsWithoutGroup(StringInterface key) {
        return instance.lookupRegisteredProviderUrlsWithoutGroup(key);
    }

    public List<ProviderModelInterface> allProviderModels() {
        return instance.allProviderModels();
    }

    public List<ConsumerModelInterface> allConsumerModels() {
        return instance.allConsumerModels();
    }

    protected FrameworkServiceRepositoryInterface instance;

    public FrameworkServiceRepository(FrameworkModelInterface frameworkModel) {
        Class[] params = new Class[]{FrameworkModelInterface.class};
        Object[] args = new Object[]{frameworkModel};
        instance = (FrameworkServiceRepositoryInterface) DubboClassLoader.getInstance(FrameworkServiceRepository.class.getName(), params, args);
    }
}
