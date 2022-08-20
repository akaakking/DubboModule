package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractMethodBuilder;

public class AbstractInterfaceBuilder<T extends AbstractInterfaceConfigInterface, B extends AbstractInterfaceBuilderInterface<T,B>> extends AbstractMethodBuilder<T, B> implements AbstractInterfaceBuilderInterface<T, B> {

    public B local(StringInterface local) {
        return instance.local(local);
    }

    public B local(BooleanInterface local) {
        return instance.local(local);
    }

    public B stub(StringInterface stub) {
        return instance.stub(stub);
    }

    public B stub(BooleanInterface stub) {
        return instance.stub(stub);
    }

    public B monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor);
    }

    public B monitor(StringInterface monitor) {
        return instance.monitor(monitor);
    }

    public B proxy(StringInterface proxy) {
        return instance.proxy(proxy);
    }

    public B cluster(StringInterface cluster) {
        return instance.cluster(cluster);
    }

    public B filter(StringInterface filter) {
        return instance.filter(filter);
    }

    public B listener(StringInterface listener) {
        return instance.listener(listener);
    }

    public B owner(StringInterface owner) {
        return instance.owner(owner);
    }

    public B connections(IntegerInterface connections) {
        return instance.connections(connections);
    }

    public B layer(StringInterface layer) {
        return instance.layer(layer);
    }

    public B application(ApplicationConfigInterface application) {
        return instance.application(application);
    }

    public B module(ModuleConfigInterface module) {
        return instance.module(module);
    }

    public B addRegistries(List<RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public B addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(registry);
    }

    public B registryIds(StringInterface registryIds) {
        return instance.registryIds(registryIds);
    }

    public B onconnect(StringInterface onconnect) {
        return instance.onconnect(onconnect);
    }

    public B ondisconnect(StringInterface ondisconnect) {
        return instance.ondisconnect(ondisconnect);
    }

    public B metadataReportConfig(MetadataReportConfigInterface metadataReportConfig) {
        return instance.metadataReportConfig(metadataReportConfig);
    }

    public B configCenter(ConfigCenterConfigInterface configCenter) {
        return instance.configCenter(configCenter);
    }

    public B callbacks(IntegerInterface callbacks) {
        return instance.callbacks(callbacks);
    }

    public B scope(StringInterface scope) {
        return instance.scope(scope);
    }

    public B tag(StringInterface tag) {
        return instance.tag(tag);
    }

    public void build(T instance) {
        instance.build(instance);
    }
}
