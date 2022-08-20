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

    public BooleanInterface getExport() {
        return instance.getExport();
    }

    public boolean shouldDelay() {
        return instance.shouldDelay();
    }

    public IntegerInterface getDelay() {
        return instance.getDelay();
    }

    public Optional<String> getContextPath(ProtocolConfigInterface protocolConfig) {
        return instance.getContextPath(protocolConfig);
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

    public StringInterface getPath() {
        return instance.getPath();
    }

    public void setPath(StringInterface path) {
        instance.setPath(path);
    }

    public ProviderConfigInterface getProvider() {
        return instance.getProvider();
    }

    public void setProvider(ProviderConfigInterface provider) {
        instance.setProvider(provider);
    }

    public StringInterface getProviderIds() {
        return instance.getProviderIds();
    }

    public void setProviderIds(StringInterface providerIds) {
        instance.setProviderIds(providerIds);
    }

    public StringInterface getGeneric() {
        return instance.getGeneric();
    }

    public void setGeneric(StringInterface generic) {
        instance.setGeneric(generic);
    }

    public ServiceMetadataInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public StringInterface getUniqueServiceName() {
        return instance.getUniqueServiceName();
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public BooleanInterface shouldExportAsync() {
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
}
