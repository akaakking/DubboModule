package org.apache.dubbo.config.spring.reference;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBeanBuilder implements ReferenceBeanBuilderInterface {

    public <T> ReferenceBeanInterface<T> build() {
        return instance.build();
    }

    public ReferenceBeanBuilderInterface setServices(StringInterface services) {
        return instance.setServices(services);
    }

    public ReferenceBeanBuilderInterface setInterface(StringInterface interfaceName) {
        return instance.setInterface(interfaceName);
    }

    public ReferenceBeanBuilderInterface setInterface(ClassInterface interfaceClass) {
        return instance.setInterface(interfaceClass);
    }

    public ReferenceBeanBuilderInterface setClient(StringInterface client) {
        return instance.setClient(client);
    }

    public ReferenceBeanBuilderInterface setUrl(StringInterface url) {
        return instance.setUrl(url);
    }

    public ReferenceBeanBuilderInterface setConsumer(ConsumerConfigInterface consumer) {
        return instance.setConsumer(consumer);
    }

    public ReferenceBeanBuilderInterface setConsumer(StringInterface consumer) {
        return instance.setConsumer(consumer);
    }

    public ReferenceBeanBuilderInterface setProtocol(StringInterface protocol) {
        return instance.setProtocol(protocol);
    }

    public ReferenceBeanBuilderInterface setCheck(BooleanInterface check) {
        return instance.setCheck(check);
    }

    public ReferenceBeanBuilderInterface setInit(BooleanInterface init) {
        return instance.setInit(init);
    }

    public ReferenceBeanBuilderInterface setGeneric(BooleanInterface generic) {
        return instance.setGeneric(generic);
    }

    public ReferenceBeanBuilderInterface setInjvm(BooleanInterface injvm) {
        return instance.setInjvm(injvm);
    }

    public ReferenceBeanBuilderInterface setListener(StringInterface listener) {
        return instance.setListener(listener);
    }

    public ReferenceBeanBuilderInterface setLazy(BooleanInterface lazy) {
        return instance.setLazy(lazy);
    }

    public ReferenceBeanBuilderInterface setOnconnect(StringInterface onconnect) {
        return instance.setOnconnect(onconnect);
    }

    public ReferenceBeanBuilderInterface setOndisconnect(StringInterface ondisconnect) {
        return instance.setOndisconnect(ondisconnect);
    }

    public ReferenceBeanBuilderInterface setReconnect(StringInterface reconnect) {
        return instance.setReconnect(reconnect);
    }

    public ReferenceBeanBuilderInterface setSticky(BooleanInterface sticky) {
        return instance.setSticky(sticky);
    }

    public ReferenceBeanBuilderInterface setVersion(StringInterface version) {
        return instance.setVersion(version);
    }

    public ReferenceBeanBuilderInterface setGroup(StringInterface group) {
        return instance.setGroup(group);
    }

    public ReferenceBeanBuilderInterface setProvidedBy(StringInterface providedBy) {
        return instance.setProvidedBy(providedBy);
    }

    public ReferenceBeanBuilderInterface setStub(StringInterface stub) {
        return instance.setStub(stub);
    }

    public ReferenceBeanBuilderInterface setCluster(StringInterface cluster) {
        return instance.setCluster(cluster);
    }

    public ReferenceBeanBuilderInterface setProxy(StringInterface proxy) {
        return instance.setProxy(proxy);
    }

    public ReferenceBeanBuilderInterface setConnections(IntegerInterface connections) {
        return instance.setConnections(connections);
    }

    public ReferenceBeanBuilderInterface setFilter(StringInterface filter) {
        return instance.setFilter(filter);
    }

    public ReferenceBeanBuilderInterface setLayer(StringInterface layer) {
        return instance.setLayer(layer);
    }

    public ReferenceBeanBuilderInterface setRegistry(StringInterface[] registryIds) {
        return instance.setRegistry(registryIds);
    }

    public ReferenceBeanBuilderInterface setRegistry(RegistryConfigInterface registry) {
        return instance.setRegistry(registry);
    }

    public ReferenceBeanBuilderInterface setRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.setRegistries(registries);
    }

    public ReferenceBeanBuilderInterface setMethods(List<? extends MethodConfigInterface> methods) {
        return instance.setMethods(methods);
    }

    public ReferenceBeanBuilderInterface setMonitor(MonitorConfigInterface monitor) {
        return instance.setMonitor(monitor);
    }

    public ReferenceBeanBuilderInterface setMonitor(StringInterface monitor) {
        return instance.setMonitor(monitor);
    }

    public ReferenceBeanBuilderInterface setOwner(StringInterface owner) {
        return instance.setOwner(owner);
    }

    public ReferenceBeanBuilderInterface setCallbacks(IntegerInterface callbacks) {
        return instance.setCallbacks(callbacks);
    }

    public ReferenceBeanBuilderInterface setScope(StringInterface scope) {
        return instance.setScope(scope);
    }

    public ReferenceBeanBuilderInterface setTag(StringInterface tag) {
        return instance.setTag(tag);
    }

    public ReferenceBeanBuilderInterface setTimeout(IntegerInterface timeout) {
        return instance.setTimeout(timeout);
    }

    public ReferenceBeanBuilderInterface setRetries(IntegerInterface retries) {
        return instance.setRetries(retries);
    }

    public ReferenceBeanBuilderInterface setLoadBalance(StringInterface loadbalance) {
        return instance.setLoadBalance(loadbalance);
    }

    public ReferenceBeanBuilderInterface setAsync(BooleanInterface async) {
        return instance.setAsync(async);
    }

    public ReferenceBeanBuilderInterface setActives(IntegerInterface actives) {
        return instance.setActives(actives);
    }

    public ReferenceBeanBuilderInterface setSent(BooleanInterface sent) {
        return instance.setSent(sent);
    }

    public ReferenceBeanBuilderInterface setMock(StringInterface mock) {
        return instance.setMock(mock);
    }

    public ReferenceBeanBuilderInterface setMerger(StringInterface merger) {
        return instance.setMerger(merger);
    }

    public ReferenceBeanBuilderInterface setCache(StringInterface cache) {
        return instance.setCache(cache);
    }

    public ReferenceBeanBuilderInterface setValidation(StringInterface validation) {
        return instance.setValidation(validation);
    }

    public ReferenceBeanBuilderInterface setParameters(Map<String, String> parameters) {
        return instance.setParameters(parameters);
    }

    protected ReferenceBeanBuilderInterface instance;
}
