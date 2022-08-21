package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ServiceModel;

public class ProviderModel extends ServiceModel implements ProviderModelInterface {

    public Object getServiceInstance() {
        return instance.getServiceInstance();
    }

    public List<RegisterStatedURLInterface> getStatedUrl() {
        return instance.getStatedUrl();
    }

    public void addStatedUrl(RegisterStatedURLInterface url) {
        instance.addStatedUrl(url.getInternalInstance());
    }

    public List<ProviderMethodModelInterface> getAllMethodModels() {
        return instance.getAllMethodModels();
    }

    public ProviderMethodModelInterface getMethodModel(String methodName, String[] argTypes) {
        return instance.getMethodModel(methodName, argTypes);
    }

    public List<ProviderMethodModelInterface> getMethodModelList(String methodName) {
        return instance.getMethodModelList(methodName);
    }

    public List<URLInterface> getServiceUrls() {
        return instance.getServiceUrls();
    }

    public void setServiceUrls(List<URLInterface> urls) {
        instance.setServiceUrls(urls);
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public ProviderModelInterface getInternalInstance() {
        return instance;
    }

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceDescriptor, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceDescriptor, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
        super.instance = instance;
    }

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceDescriptor, ServiceMetadataInterface serviceMetadata, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ServiceMetadataInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceDescriptor, serviceMetadata, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
        super.instance = instance;
    }

    public ProviderModel(String serviceKey, Object serviceInstance, ServiceDescriptorInterface serviceModel, ModuleModelInterface moduleModel, ServiceMetadataInterface serviceMetadata, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ModuleModelInterface.class, ServiceMetadataInterface.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, serviceInstance, serviceModel, moduleModel, serviceMetadata, interfaceClassLoader};
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName(), params, args);
        super.instance = instance;
    }

    protected ProviderModel() {
        instance = (ProviderModelInterface) DubboClassLoader.getInstance(ProviderModel.class.getName());
        super.instance = instance;
    }
}
