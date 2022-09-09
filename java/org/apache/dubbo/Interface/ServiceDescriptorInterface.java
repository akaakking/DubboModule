package org.apache.dubbo.Interface;

import java.lang.String;
import java.util.Set;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import java.lang.Class;
import java.util.List;

public interface ServiceDescriptorInterface {

    FullServiceDefinitionInterface getFullServiceDefinition(String serviceKey);

    String getInterfaceName();

    Class<?> getServiceInterfaceClass();

    Set<MethodDescriptor> getAllMethods();

    MethodDescriptor getMethod(String methodName, String params);

    MethodDescriptor getMethod(String methodName, Class<?>[] paramTypes);

    List<MethodDescriptor> getMethods(String methodName);
}
