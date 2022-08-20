package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ModuleServiceRepository implements ModuleServiceRepositoryInterface {

    public ModuleModelInterface getModuleModel() {
        return instance.getModuleModel();
    }

    public void registerConsumer(StringInterface serviceKey, ServiceDescriptorInterface serviceDescriptor, ReferenceConfigBaseInterface<?> rc, ObjectInterface proxy, ServiceMetadataInterface serviceMetadata) {
        instance.registerConsumer(serviceKey, serviceDescriptor, rc, proxy, serviceMetadata);
    }

    public void registerConsumer(ConsumerModelInterface consumerModel) {
        instance.registerConsumer(consumerModel);
    }

    public void registerProvider(StringInterface serviceKey, ObjectInterface serviceInstance, ServiceDescriptorInterface serviceModel, ServiceConfigBaseInterface<?> serviceConfig, ServiceMetadataInterface serviceMetadata) {
        instance.registerProvider(serviceKey, serviceInstance, serviceModel, serviceConfig, serviceMetadata);
    }

    public void registerProvider(ProviderModelInterface providerModel) {
        instance.registerProvider(providerModel);
    }

    public ServiceDescriptorInterface registerService(ServiceDescriptorInterface serviceDescriptor) {
        return instance.registerService(serviceDescriptor);
    }

    public ServiceDescriptorInterface registerService(Class<?> interfaceClazz) {
        return instance.registerService(interfaceClazz);
    }

    public ServiceDescriptorInterface registerService(Class<?> interfaceClazz, ServiceDescriptorInterface serviceDescriptor) {
        return instance.registerService(interfaceClazz, serviceDescriptor);
    }

    public ServiceDescriptorInterface registerService(StringInterface path, Class<?> interfaceClass) {
        return instance.registerService(path, interfaceClass);
    }

    public void reRegisterProvider(StringInterface newServiceKey, StringInterface serviceKey) {
        instance.reRegisterProvider(newServiceKey, serviceKey);
    }

    public void reRegisterConsumer(StringInterface newServiceKey, StringInterface serviceKey) {
        instance.reRegisterConsumer(newServiceKey, serviceKey);
    }

    public void unregisterService(Class<?> interfaceClazz) {
        instance.unregisterService(interfaceClazz);
    }

    public void unregisterService(StringInterface path) {
        instance.unregisterService(path);
    }

    public void unregisterProvider(ProviderModelInterface providerModel) {
        instance.unregisterProvider(providerModel);
    }

    public void unregisterConsumer(ConsumerModelInterface consumerModel) {
        instance.unregisterConsumer(consumerModel);
    }

    public List<ServiceDescriptorInterface> getAllServices() {
        return instance.getAllServices();
    }

    public ServiceDescriptorInterface getService(StringInterface serviceName) {
        return instance.getService(serviceName);
    }

    public ServiceDescriptorInterface lookupService(StringInterface interfaceName) {
        return instance.lookupService(interfaceName);
    }

    public MethodDescriptorInterface lookupMethod(StringInterface interfaceName, StringInterface methodName) {
        return instance.lookupMethod(interfaceName, methodName);
    }

    public List<ProviderModelInterface> getExportedServices() {
        return instance.getExportedServices();
    }

    public ProviderModelInterface lookupExportedService(StringInterface serviceKey) {
        return instance.lookupExportedService(serviceKey);
    }

    public List<ConsumerModelInterface> getReferredServices() {
        return instance.getReferredServices();
    }

    public ConsumerModelInterface lookupReferredService(StringInterface serviceKey) {
        return instance.lookupReferredService(serviceKey);
    }

    public List<ConsumerModelInterface> lookupReferredServices(StringInterface serviceKey) {
        return instance.lookupReferredServices(serviceKey);
    }

    public void destroy() {
        instance.destroy();
    }

    protected ModuleServiceRepositoryInterface instance;

    public ModuleServiceRepository(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleServiceRepositoryInterface) DubboClassLoader.getInstance(ModuleServiceRepository.class.getName(), params, args);
    }
}
