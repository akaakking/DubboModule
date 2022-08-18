package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ProviderModel implements ProviderModelInterface {

    public Object getServiceInstance() {
        return instance.getServiceInstance();
    }

    public List<RegisterStatedURL> getStatedUrl() {
        return instance.getStatedUrl();
    }

    public void addStatedUrl(RegisterStatedURLInterface url) {
        instance.addStatedUrl(url);
    }

    public List<ProviderMethodModel> getAllMethodModels() {
        return instance.getAllMethodModels();
    }

    public ProviderMethodModelInterface getMethodModel(String methodName, String[] argTypes) {
        return instance.getMethodModel(methodName, argTypes);
    }

    public List<ProviderMethodModel> getMethodModelList(String methodName) {
        return instance.getMethodModelList(methodName);
    }

    public List<URL> getServiceUrls() {
        return instance.getServiceUrls();
    }

    public void setServiceUrls(List<URL> urls) {
        instance.setServiceUrls(urls);
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    protected ProviderModelInterface instance;

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceDescriptor, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceDescriptor, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
    }

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceDescriptor, ServiceMetadataInterface serviceMetadata, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ServiceMetadataInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceDescriptor, serviceMetadata, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
    }

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceModel, ModuleModelInterface moduleModel, ServiceMetadataInterface serviceMetadata, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ModuleModelInterface.class, ServiceMetadataInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceModel, moduleModel, serviceMetadata, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
    }
}
