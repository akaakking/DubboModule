package org.apache.dubbo.rpc.model;

import java.util.Set;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ServiceModel;
import java.util.Map;

public class ConsumerModel extends ServiceModel implements ConsumerModelInterface {

    public AsyncMethodInfoInterface getMethodConfig(StringInterface methodName) {
        return instance.getMethodConfig(methodName);
    }

    public Set<String> getApps() {
        return instance.getApps();
    }

    public AsyncMethodInfoInterface getAsyncInfo(StringInterface methodName) {
        return instance.getAsyncInfo(methodName);
    }

    public void initMethodModels() {
        instance.initMethodModels();
    }

    public ConsumerMethodModelInterface getMethodModel(MethodInterface method) {
        return instance.getMethodModel(method);
    }

    public ConsumerMethodModelInterface getMethodModel(StringInterface method) {
        return instance.getMethodModel(method);
    }

    public ConsumerMethodModelInterface getMethodModel(StringInterface method, StringInterface[] argsType) {
        return instance.getMethodModel(method, argsType);
    }

    public List<ConsumerMethodModelInterface> getAllMethodModels() {
        return instance.getAllMethodModels();
    }

    public boolean equals(ObjectInterface o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public ConsumerModel(String serviceKey, Object proxyObject, ServiceDescriptorInterface serviceDescriptor, Map<String, AsyncMethodInfo> methodConfigs, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, MapMap<String,AsyncMethodInfo>.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, proxyObject, serviceDescriptor, methodConfigs, interfaceClassLoader};
        instance = (ConsumerModelInterface) DubboClassLoader.getInstance(ConsumerModel.class.getName(), params, args);
    }

    public ConsumerModel(String serviceKey, Object proxyObject, ServiceDescriptorInterface serviceDescriptor, ServiceMetadataInterface metadata, Map<String, AsyncMethodInfo> methodConfigs, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ServiceMetadataInterface.class, MapMap<String,AsyncMethodInfo>.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, proxyObject, serviceDescriptor, metadata, methodConfigs, interfaceClassLoader};
        instance = (ConsumerModelInterface) DubboClassLoader.getInstance(ConsumerModel.class.getName(), params, args);
    }

    public ConsumerModel(String serviceKey, Object proxyObject, ServiceDescriptorInterface serviceDescriptor, ModuleModelInterface moduleModel, ServiceMetadataInterface metadata, Map<String, AsyncMethodInfo> methodConfigs, ClassLoader interfaceClassLoader) {
        Class[] params = new Class[]{String.class, Object.class, ServiceDescriptorInterface.class, ModuleModelInterface.class, ServiceMetadataInterface.class, MapMap<String,AsyncMethodInfo>.class, ClassLoader.class};
        Object[] args = new Object[]{serviceKey, proxyObject, serviceDescriptor, moduleModel, metadata, methodConfigs, interfaceClassLoader};
        instance = (ConsumerModelInterface) DubboClassLoader.getInstance(ConsumerModel.class.getName(), params, args);
    }
}
