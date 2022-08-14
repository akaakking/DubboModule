package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface AbstractInterfaceBuilderInterface<T>{
    BInterface local(String local);
    BInterface local(Boolean local);
    BInterface stub(String stub);
    BInterface stub(Boolean stub);
    BInterface monitor(MonitorConfigInterface monitor);
    BInterface monitor(String monitor);
    BInterface proxy(String proxy);
    BInterface cluster(String cluster);
    BInterface filter(String filter);
    BInterface listener(String listener);
    BInterface owner(String owner);
    BInterface connections(Integer connections);
    BInterface layer(String layer);
    BInterface application(ApplicationConfigInterface application);
    BInterface module(ModuleConfigInterface module);
    BInterface addRegistries(List registries);
    BInterface addRegistry(RegistryConfigInterface registry);
    BInterface registryIds(String registryIds);
    BInterface onconnect(String onconnect);
    BInterface ondisconnect(String ondisconnect);
    BInterface metadataReportConfig(MetadataReportConfigInterface metadataReportConfig);
    BInterface configCenter(ConfigCenterConfigInterface configCenter);
    BInterface callbacks(Integer callbacks);
    BInterface scope(String scope);
    BInterface tag(String tag);
    void build(TInterface instance);

}