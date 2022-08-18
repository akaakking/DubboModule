package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ModuleServiceRepository implements ModuleServiceRepositoryInterface {

    public ModuleModelInterface getModuleModel() {
        return instance.getModuleModel();
    }

    public void registerConsumer(String serviceKey, ServiceDescriptorInterface serviceDescriptor, ReferenceConfigBaseInterface<?> rc, Object proxy, ServiceMetadataInterface serviceMetadata) {
        instance.registerConsumer(serviceKey, serviceDescriptor, rc, proxy, serviceMetadata);
    }

    public void registerConsumer(ConsumerModelInterface consumerModel) {
        instance.registerConsumer(consumerModel);
    }

    public void registerProvider(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceModel, ServiceConfigBaseInterface<?> serviceConfig, ServiceMetadataInterface serviceMetadata) {
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

    public ServiceDescriptorInterface registerService(String path, Class<?> interfaceClass) {
        return instance.registerService(path, interfaceClass);
    }

    public void reRegisterProvider(String newServiceKey, String serviceKey) {
        instance.reRegisterProvider(newServiceKey, serviceKey);
    }

    public void reRegisterConsumer(String newServiceKey, String serviceKey) {
        instance.reRegisterConsumer(newServiceKey, serviceKey);
    }

    public void unregisterService(Class<?> interfaceClazz) {
        instance.unregisterService(interfaceClazz);
    }

    public void unregisterService(String path) {
        instance.unregisterService(path);
    }

    public void unregisterProvider(ProviderModelInterface providerModel) {
        instance.unregisterProvider(providerModel);
    }

    public void unregisterConsumer(ConsumerModelInterface consumerModel) {
        instance.unregisterConsumer(consumerModel);
    }

    public List<ServiceDescriptor> getAllServices() {
        return instance.getAllServices();
    }

    public ServiceDescriptorInterface getService(String serviceName) {
        return instance.getService(serviceName);
    }

    public ServiceDescriptorInterface lookupService(String interfaceName) {
        return instance.lookupService(interfaceName);
    }

    public MethodDescriptorInterface lookupMethod(String interfaceName, String methodName) {
        return instance.lookupMethod(interfaceName, methodName);
    }

    public List<ProviderModel> getExportedServices() {
        return instance.getExportedServices();
    }

    public ProviderModelInterface lookupExportedService(String serviceKey) {
        return instance.lookupExportedService(serviceKey);
    }

    public List<ConsumerModel> getReferredServices() {
        return instance.getReferredServices();
    }

    public ConsumerModelInterface lookupReferredService(String serviceKey) {
        return instance.lookupReferredService(serviceKey);
    }

    public List<ConsumerModel> lookupReferredServices(String serviceKey) {
        return instance.lookupReferredServices(serviceKey);
    }

    public void destroy() {
        instance.destroy();
    }

    public ModuleServiceRepository(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleServiceRepositoryInterface) DubboClassLoader.getInstance(ModuleServiceRepository.class.getName(), params, args);
    }
}
