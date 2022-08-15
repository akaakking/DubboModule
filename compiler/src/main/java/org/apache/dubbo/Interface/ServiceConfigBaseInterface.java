package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.dubbo.rpc.model.ServiceMetadata;

public interface ServiceConfigBaseInterface<T> {
    boolean shouldExport();
    Boolean getExport();
    boolean shouldDelay();
    Integer getDelay();
    Optional getContextPath(ProtocolConfigInterface protocolConfig);
    Map getMetaData();
    Class getInterfaceClass();
    void setInterfaceClass(Class interfaceClass);
    void setInterface(Class interfaceClass);
    T getRef();
    void setRef(T ref);
    String getPath();
    void setPath(String path);
    ProviderConfigInterface getProvider();
    void setProvider(ProviderConfigInterface provider);
    String getProviderIds();
    void setProviderIds(String providerIds);
    String getGeneric();
    void setGeneric(String generic);
    ServiceMetadata getServiceMetadata();
    List getPrefixes();
    String getUniqueServiceName();
    String getGroup();
    String getVersion();
    Boolean shouldExportAsync();
    void export();
    void unexport();
    boolean isExported();
    boolean isUnexported();
}