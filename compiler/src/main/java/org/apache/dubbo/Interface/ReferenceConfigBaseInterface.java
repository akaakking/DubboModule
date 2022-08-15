package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.rpc.model.ServiceMetadata;

public interface ReferenceConfigBaseInterface<T> {
    boolean shouldCheck();
    boolean shouldInit();
    List getPrefixes();
    Map getMetaData();
    Class getServiceInterfaceClass();
    Class getInterfaceClass();
    Class determineInterfaceClass(String generic, String interfaceName);
    Class determineInterfaceClass(String generic, String interfaceName, ClassLoader classLoader);
    void setInterface(Class interfaceClass);
    String getClient();
    void setClient(String client);
    String getUrl();
    void setUrl(String url);
    ConsumerConfigInterface getConsumer();
    void setConsumer(ConsumerConfigInterface consumer);
    String getProtocol();
    void setProtocol(String protocol);
    ServiceMetadata getServiceMetadata();
    String getUniqueServiceName();
    String getVersion();
    String getGroup();
    Boolean shouldReferAsync();
    T get();
    void destroy();
}