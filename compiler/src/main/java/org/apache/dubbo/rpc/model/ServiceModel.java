package org.apache.dubbo.rpc.model;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceModel implements ServiceModelInterface {

    public AbstractInterfaceConfigInterface getConfig() {
        return instance.getConfig();
    }

    public void setConfig(AbstractInterfaceConfigInterface config) {
        instance.setConfig(config);
    }

    public ReferenceConfigBaseInterface<?> getReferenceConfig() {
        return instance.getReferenceConfig();
    }

    public ServiceConfigBaseInterface<?> getServiceConfig() {
        return instance.getServiceConfig();
    }

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public void setProxyObject(Object proxyObject) {
        instance.setProxyObject(proxyObject);
    }

    public Object getProxyObject() {
        return instance.getProxyObject();
    }

    public ServiceDescriptorInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public void setClassLoader(ClassLoader classLoader) {
        instance.setClassLoader(classLoader);
    }

    public ClassLoader getClassLoader() {
        return instance.getClassLoader();
    }

    public Set<MethodDescriptor> getAllMethods() {
        return instance.getAllMethods();
    }

    public Class<?> getServiceInterfaceClass() {
        return instance.getServiceInterfaceClass();
    }

    public void setServiceKey(String serviceKey) {
        instance.setServiceKey(serviceKey);
    }

    public String getServiceName() {
        return instance.getServiceName();
    }

    public ServiceMetadataInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public ModuleModelInterface getModuleModel() {
        return instance.getModuleModel();
    }

    public Callable<Void> getDestroyCaller() {
        return instance.getDestroyCaller();
    }

    public void setDestroyCaller(Callable<Void> destroyCaller) {
        instance.setDestroyCaller(destroyCaller);
    }

    public ClassLoader getInterfaceClassLoader() {
        return instance.getInterfaceClassLoader();
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public ServiceModel(Object proxyObject, String serviceKey, ServiceDescriptorInterface serviceModel, ModuleModelInterface moduleModel, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{Object.class, String.class, ServiceDescriptorInterface.class, ModuleModelInterface.class, ClassLoader.class};
        Object[] args = new Object[]{proxyObject, serviceKey, serviceModel, moduleModel, interfaceClassLoader};
        instance = (ServiceModelInterface) DubboClassLoader.getInstance(ServiceModel.class.getName(), params, args);
    }

    public ServiceModel(Object proxyObject, String serviceKey, ServiceDescriptorInterface serviceModel, ModuleModelInterface moduleModel, ServiceMetadataInterface serviceMetadata, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{Object.class, String.class, ServiceDescriptorInterface.class, ModuleModelInterface.class, ServiceMetadataInterface.class, ClassLoader.class};
        Object[] args = new Object[]{proxyObject, serviceKey, serviceModel, moduleModel, serviceMetadata, interfaceClassLoader};
        instance = (ServiceModelInterface) DubboClassLoader.getInstance(ServiceModel.class.getName(), params, args);
    }
}
