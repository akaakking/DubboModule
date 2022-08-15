package org.apache.dubbo.Interface;

import java.util.List;

public interface AbstractInterfaceBuilderInterface<T><B> extends AbstractMethodBuilder{
    B local(String local);
    B local(Boolean local);
    B stub(String stub);
    B stub(Boolean stub);
    B monitor(MonitorConfigInterface monitor);
    B monitor(String monitor);
    B proxy(String proxy);
    B cluster(String cluster);
    B filter(String filter);
    B listener(String listener);
    B owner(String owner);
    B connections(Integer connections);
    B layer(String layer);
    B application(ApplicationConfigInterface application);
    B module(ModuleConfigInterface module);
    B addRegistries(List registries);
    B addRegistry(RegistryConfigInterface registry);
    B registryIds(String registryIds);
    B onconnect(String onconnect);
    B ondisconnect(String ondisconnect);
    B metadataReportConfig(MetadataReportConfigInterface metadataReportConfig);
    B configCenter(ConfigCenterConfigInterface configCenter);
    B callbacks(Integer callbacks);
    B scope(String scope);
    B tag(String tag);
    void build(T instance);
}