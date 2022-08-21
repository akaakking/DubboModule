package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractMethodBuilder;

public class AbstractInterfaceBuilder<T extends AbstractInterfaceConfigInterface, B extends AbstractInterfaceBuilderInterface<T,B>> extends AbstractMethodBuilder<T, B> implements AbstractInterfaceBuilderInterface<T, B> {

    public B local(String local) {
        return instance.local(local);
    }

    public B local(Boolean local) {
        return instance.local(local);
    }

    public B stub(String stub) {
        return instance.stub(stub);
    }

    public B stub(Boolean stub) {
        return instance.stub(stub);
    }

    public B monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor.getInternalInstance());
    }

    public B monitor(String monitor) {
        return instance.monitor(monitor);
    }

    public B proxy(String proxy) {
        return instance.proxy(proxy);
    }

    public B cluster(String cluster) {
        return instance.cluster(cluster);
    }

    public B filter(String filter) {
        return instance.filter(filter);
    }

    public B listener(String listener) {
        return instance.listener(listener);
    }

    public B owner(String owner) {
        return instance.owner(owner);
    }

    public B connections(Integer connections) {
        return instance.connections(connections);
    }

    public B layer(String layer) {
        return instance.layer(layer);
    }

    public B application(ApplicationConfigInterface application) {
        return instance.application(application.getInternalInstance());
    }

    public B module(ModuleConfigInterface module) {
        return instance.module(module.getInternalInstance());
    }

    public B addRegistries(List<RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public B addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(registry.getInternalInstance());
    }

    public B registryIds(String registryIds) {
        return instance.registryIds(registryIds);
    }

    public B onconnect(String onconnect) {
        return instance.onconnect(onconnect);
    }

    public B ondisconnect(String ondisconnect) {
        return instance.ondisconnect(ondisconnect);
    }

    public B metadataReportConfig(MetadataReportConfigInterface metadataReportConfig) {
        return instance.metadataReportConfig(metadataReportConfig.getInternalInstance());
    }

    public B configCenter(ConfigCenterConfigInterface configCenter) {
        return instance.configCenter(configCenter.getInternalInstance());
    }

    public B callbacks(Integer callbacks) {
        return instance.callbacks(callbacks);
    }

    public B scope(String scope) {
        return instance.scope(scope);
    }

    public B tag(String tag) {
        return instance.tag(tag);
    }

    public void build(T instance) {
        instance.build(instance);
    }

    public AbstractInterfaceBuilderInterface getInternalInstance() {
        return instance;
    }

    protected AbstractInterfaceBuilder() {
    }
}
