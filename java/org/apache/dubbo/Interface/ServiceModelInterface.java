package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.AbstractInterfaceConfigInterface;
import org.apache.dubbo.config.AbstractInterfaceConfig;
import org.apache.dubbo.Interface.ReferenceConfigBaseInterface;
import org.apache.dubbo.Interface.ServiceConfigBaseInterface;
import java.lang.Object;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import java.lang.ClassLoader;
import java.util.Set;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import java.lang.String;
import org.apache.dubbo.Interface.ServiceMetadataInterface;
import org.apache.dubbo.Interface.ModuleModelInterface;
import java.lang.Runnable;

public interface ServiceModelInterface {

    AbstractInterfaceConfigInterface getConfig();

    void setConfig(AbstractInterfaceConfigInterface config);

    ReferenceConfigBaseInterface<?> getReferenceConfig();

    ServiceConfigBaseInterface<?> getServiceConfig();

    String getServiceKey();

    void setProxyObject(Object proxyObject);

    Object getProxyObject();

    ServiceDescriptor getServiceModel();

    void setClassLoader(ClassLoader classLoader);

    ClassLoader getClassLoader();

    Set<MethodDescriptor> getAllMethods();

    Class<?> getServiceInterfaceClass();

    void setServiceKey(String serviceKey);

    String getServiceName();

    ServiceMetadataInterface getServiceMetadata();

    ModuleModelInterface getModuleModel();

    Runnable getDestroyRunner();

    void setDestroyRunner(Runnable destroyRunner);

    ClassLoader getInterfaceClassLoader();

    boolean equals(Object o);

    int hashCode();
}
