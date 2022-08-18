package org.apache.dubbo.rpc.model;

import java.util.Set;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceDescriptor implements ServiceDescriptorInterface {

    public FullServiceDefinitionInterface getFullServiceDefinition(String serviceKey) {
        return instance.getFullServiceDefinition(serviceKey);
    }

    public String getInterfaceName() {
        return instance.getInterfaceName();
    }

    public Class<?> getServiceInterfaceClass() {
        return instance.getServiceInterfaceClass();
    }

    public Set<MethodDescriptor> getAllMethods() {
        return instance.getAllMethods();
    }

    public MethodDescriptorInterface getMethod(String methodName, String params) {
        return instance.getMethod(methodName, params);
    }

    public MethodDescriptorInterface getMethod(String methodName, Class<?>[] paramTypes) {
        return instance.getMethod(methodName, paramTypes);
    }

    public List<MethodDescriptor> getMethods(String methodName) {
        return instance.getMethods(methodName);
    }
}
