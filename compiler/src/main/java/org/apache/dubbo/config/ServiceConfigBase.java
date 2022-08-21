package org.apache.dubbo.config;

import java.util.Optional;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractServiceConfig;

public class ServiceConfigBase<T> extends AbstractServiceConfig implements ServiceConfigBaseInterface<T> {

    public boolean shouldExport() {
        return instance.shouldExport();
    }

    public Boolean getExport() {
        return instance.getExport();
    }

    public boolean shouldDelay() {
        return instance.shouldDelay();
    }

    public Integer getDelay() {
        return instance.getDelay();
    }

    public Optional<String> getContextPath(ProtocolConfigInterface protocolConfig) {
        return instance.getContextPath(protocolConfig.getInternalInstance());
    }

    public Map<String, String> getMetaData() {
        return instance.getMetaData();
    }

    public Class<?> getInterfaceClass() {
        return instance.getInterfaceClass();
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        instance.setInterfaceClass(interfaceClass);
    }

    public void setInterface(Class<?> interfaceClass) {
        instance.setInterface(interfaceClass);
    }

    public T getRef() {
        return instance.getRef();
    }

    public void setRef(T ref) {
        instance.setRef(ref);
    }

    public String getPath() {
        return instance.getPath();
    }

    public void setPath(String path) {
        instance.setPath(path);
    }

    public ProviderConfigInterface getProvider() {
        return instance.getProvider();
    }

    public void setProvider(ProviderConfigInterface provider) {
        instance.setProvider(provider.getInternalInstance());
    }

    public String getProviderIds() {
        return instance.getProviderIds();
    }

    public void setProviderIds(String providerIds) {
        instance.setProviderIds(providerIds);
    }

    public String getGeneric() {
        return instance.getGeneric();
    }

    public void setGeneric(String generic) {
        instance.setGeneric(generic);
    }

    public ServiceMetadataInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public String getUniqueServiceName() {
        return instance.getUniqueServiceName();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public Boolean shouldExportAsync() {
        return instance.shouldExportAsync();
    }

    public void export() {
        instance.export();
    }

    public void unexport() {
        instance.unexport();
    }

    public boolean isExported() {
        return instance.isExported();
    }

    public boolean isUnexported() {
        return instance.isUnexported();
    }

    public ServiceConfigBaseInterface getInternalInstance() {
        return instance;
    }

    protected ServiceConfigBase() {
    }
}
