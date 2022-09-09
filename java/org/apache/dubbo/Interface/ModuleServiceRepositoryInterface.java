package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ModuleModelInterface;
import java.lang.String;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.Interface.ReferenceConfigBaseInterface;
import java.lang.Object;
import org.apache.dubbo.rpc.model.ServiceMetadata;
import org.apache.dubbo.Interface.ServiceMetadataInterface;
import org.apache.dubbo.rpc.model.ConsumerModel;
import org.apache.dubbo.Interface.ConsumerModelInterface;
import org.apache.dubbo.config.ServiceConfigBase;
import org.apache.dubbo.Interface.ServiceConfigBaseInterface;
import org.apache.dubbo.rpc.model.ProviderModel;
import org.apache.dubbo.Interface.ProviderModelInterface;
import java.lang.Class;
import java.util.List;
import org.apache.dubbo.rpc.model.MethodDescriptor;

public interface ModuleServiceRepositoryInterface {

    ModuleModelInterface getModuleModel();

    void registerConsumer(String serviceKey, ServiceDescriptor serviceDescriptor, ReferenceConfigBaseInterface<?> rc, Object proxy, ServiceMetadataInterface serviceMetadata);

    void registerConsumer(ConsumerModelInterface consumerModel);

    void registerProvider(String serviceKey, Object serviceInstance, ServiceDescriptor serviceModel, ServiceConfigBaseInterface<?> serviceConfig, ServiceMetadataInterface serviceMetadata);

    void registerProvider(ProviderModelInterface providerModel);

    ServiceDescriptor registerService(ServiceDescriptor serviceDescriptor);

    ServiceDescriptor registerService(Class<?> interfaceClazz);

    ServiceDescriptor registerService(Class<?> interfaceClazz, ServiceDescriptor serviceDescriptor);

    ServiceDescriptor registerService(String path, Class<?> interfaceClass);

    void reRegisterProvider(String newServiceKey, String serviceKey);

    void reRegisterConsumer(String newServiceKey, String serviceKey);

    void unregisterService(Class<?> interfaceClazz);

    void unregisterService(String path);

    void unregisterProvider(ProviderModelInterface providerModel);

    void unregisterConsumer(ConsumerModelInterface consumerModel);

    List<ServiceDescriptor> getAllServices();

    ServiceDescriptor getService(String serviceName);

    ServiceDescriptor lookupService(String interfaceName);

    MethodDescriptor lookupMethod(String interfaceName, String methodName);

    List<ProviderModelInterface> getExportedServices();

    ProviderModelInterface lookupExportedService(String serviceKey);

    List<ConsumerModelInterface> getReferredServices();

    ConsumerModelInterface lookupReferredService(String serviceKey);

    List<ConsumerModelInterface> lookupReferredServices(String serviceKey);

    void destroy();
}
