package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.rpc.model;

public interface ServiceConfigBaseInterface<T>{
    boolean shouldExport();
    Boolean getExport();
    boolean shouldDelay();
    Integer getDelay();
    Optional getContextPath(ProtocolConfigInterface protocolConfig);
    Map getMetaData();
    Class getInterfaceClass();
    void setInterfaceClass(Class interfaceClass);
    void setInterface(Class interfaceClass);
    TInterface getRef();
    void setRef(TInterface ref);
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