package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class FrameworkServiceRepository implements FrameworkServiceRepositoryInterface {

    public void registerProvider(ProviderModelInterface providerModel) {
        instance.registerProvider(providerModel.getInternalInstance());
    }

    public void unregisterProvider(ProviderModelInterface providerModel) {
        instance.unregisterProvider(providerModel.getInternalInstance());
    }

    public ProviderModelInterface lookupExportedServiceWithoutGroup(String key) {
        return instance.lookupExportedServiceWithoutGroup(key);
    }

    public List<ProviderModelInterface> lookupExportedServicesWithoutGroup(String key) {
        return instance.lookupExportedServicesWithoutGroup(key);
    }

    public void registerProviderUrl(URLInterface url) {
        instance.registerProviderUrl(url.getInternalInstance());
    }

    public ProviderModelInterface lookupExportedService(String serviceKey) {
        return instance.lookupExportedService(serviceKey);
    }

    public List<URLInterface> lookupRegisteredProviderUrlsWithoutGroup(String key) {
        return instance.lookupRegisteredProviderUrlsWithoutGroup(key);
    }

    public List<ProviderModelInterface> allProviderModels() {
        return instance.allProviderModels();
    }

    public List<ConsumerModelInterface> allConsumerModels() {
        return instance.allConsumerModels();
    }

    protected FrameworkServiceRepositoryInterface instance;

    public FrameworkServiceRepositoryInterface getInternalInstance() {
        return instance;
    }

    public FrameworkServiceRepository(FrameworkModelInterface frameworkModel) {
        Class[] params = new Class[]{FrameworkModelInterface.class};
        Object[] args = new Object[]{frameworkModel};
        instance = (FrameworkServiceRepositoryInterface) DubboClassLoader.getInstance(FrameworkServiceRepository.class.getName(), params, args);
    }

    protected FrameworkServiceRepository() {
        instance = (FrameworkServiceRepositoryInterface) DubboClassLoader.getInstance(FrameworkServiceRepository.class.getName());
    }
}
