package org.apache.dubbo.config.spring.reference;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBeanBuilder implements ReferenceBeanBuilderInterface {

    public <T> ReferenceBeanInterface<T> build() {
        return instance.build();
    }

    public ReferenceBeanBuilderInterface setServices(String services) {
        return instance.setServices(services);
    }

    public ReferenceBeanBuilderInterface setInterface(String interfaceName) {
        return instance.setInterface(interfaceName);
    }

    public ReferenceBeanBuilderInterface setInterface(Class interfaceClass) {
        return instance.setInterface(interfaceClass);
    }

    public ReferenceBeanBuilderInterface setClient(String client) {
        return instance.setClient(client);
    }

    public ReferenceBeanBuilderInterface setUrl(String url) {
        return instance.setUrl(url);
    }

    public ReferenceBeanBuilderInterface setConsumer(ConsumerConfigInterface consumer) {
        return instance.setConsumer(consumer.getInternalInstance());
    }

    public ReferenceBeanBuilderInterface setConsumer(String consumer) {
        return instance.setConsumer(consumer);
    }

    public ReferenceBeanBuilderInterface setProtocol(String protocol) {
        return instance.setProtocol(protocol);
    }

    public ReferenceBeanBuilderInterface setCheck(Boolean check) {
        return instance.setCheck(check);
    }

    public ReferenceBeanBuilderInterface setInit(Boolean init) {
        return instance.setInit(init);
    }

    public ReferenceBeanBuilderInterface setGeneric(Boolean generic) {
        return instance.setGeneric(generic);
    }

    public ReferenceBeanBuilderInterface setInjvm(Boolean injvm) {
        return instance.setInjvm(injvm);
    }

    public ReferenceBeanBuilderInterface setListener(String listener) {
        return instance.setListener(listener);
    }

    public ReferenceBeanBuilderInterface setLazy(Boolean lazy) {
        return instance.setLazy(lazy);
    }

    public ReferenceBeanBuilderInterface setOnconnect(String onconnect) {
        return instance.setOnconnect(onconnect);
    }

    public ReferenceBeanBuilderInterface setOndisconnect(String ondisconnect) {
        return instance.setOndisconnect(ondisconnect);
    }

    public ReferenceBeanBuilderInterface setReconnect(String reconnect) {
        return instance.setReconnect(reconnect);
    }

    public ReferenceBeanBuilderInterface setSticky(Boolean sticky) {
        return instance.setSticky(sticky);
    }

    public ReferenceBeanBuilderInterface setVersion(String version) {
        return instance.setVersion(version);
    }

    public ReferenceBeanBuilderInterface setGroup(String group) {
        return instance.setGroup(group);
    }

    public ReferenceBeanBuilderInterface setProvidedBy(String providedBy) {
        return instance.setProvidedBy(providedBy);
    }

    public ReferenceBeanBuilderInterface setStub(String stub) {
        return instance.setStub(stub);
    }

    public ReferenceBeanBuilderInterface setCluster(String cluster) {
        return instance.setCluster(cluster);
    }

    public ReferenceBeanBuilderInterface setProxy(String proxy) {
        return instance.setProxy(proxy);
    }

    public ReferenceBeanBuilderInterface setConnections(Integer connections) {
        return instance.setConnections(connections);
    }

    public ReferenceBeanBuilderInterface setFilter(String filter) {
        return instance.setFilter(filter);
    }

    public ReferenceBeanBuilderInterface setLayer(String layer) {
        return instance.setLayer(layer);
    }

    public ReferenceBeanBuilderInterface setRegistry(String[] registryIds) {
        return instance.setRegistry(registryIds);
    }

    public ReferenceBeanBuilderInterface setRegistry(RegistryConfigInterface registry) {
        return instance.setRegistry(registry.getInternalInstance());
    }

    public ReferenceBeanBuilderInterface setRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.setRegistries(registries);
    }

    public ReferenceBeanBuilderInterface setMethods(List<? extends MethodConfigInterface> methods) {
        return instance.setMethods(methods);
    }

    public ReferenceBeanBuilderInterface setMonitor(MonitorConfigInterface monitor) {
        return instance.setMonitor(monitor.getInternalInstance());
    }

    public ReferenceBeanBuilderInterface setMonitor(String monitor) {
        return instance.setMonitor(monitor);
    }

    public ReferenceBeanBuilderInterface setOwner(String owner) {
        return instance.setOwner(owner);
    }

    public ReferenceBeanBuilderInterface setCallbacks(Integer callbacks) {
        return instance.setCallbacks(callbacks);
    }

    public ReferenceBeanBuilderInterface setScope(String scope) {
        return instance.setScope(scope);
    }

    public ReferenceBeanBuilderInterface setTag(String tag) {
        return instance.setTag(tag);
    }

    public ReferenceBeanBuilderInterface setTimeout(Integer timeout) {
        return instance.setTimeout(timeout);
    }

    public ReferenceBeanBuilderInterface setRetries(Integer retries) {
        return instance.setRetries(retries);
    }

    public ReferenceBeanBuilderInterface setLoadBalance(String loadbalance) {
        return instance.setLoadBalance(loadbalance);
    }

    public ReferenceBeanBuilderInterface setAsync(Boolean async) {
        return instance.setAsync(async);
    }

    public ReferenceBeanBuilderInterface setActives(Integer actives) {
        return instance.setActives(actives);
    }

    public ReferenceBeanBuilderInterface setSent(Boolean sent) {
        return instance.setSent(sent);
    }

    public ReferenceBeanBuilderInterface setMock(String mock) {
        return instance.setMock(mock);
    }

    public ReferenceBeanBuilderInterface setMerger(String merger) {
        return instance.setMerger(merger);
    }

    public ReferenceBeanBuilderInterface setCache(String cache) {
        return instance.setCache(cache);
    }

    public ReferenceBeanBuilderInterface setValidation(String validation) {
        return instance.setValidation(validation);
    }

    public ReferenceBeanBuilderInterface setParameters(Map<String, String> parameters) {
        return instance.setParameters(parameters);
    }

    protected ReferenceBeanBuilderInterface instance;

    public ReferenceBeanBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceBeanBuilder() {
        instance = (ReferenceBeanBuilderInterface) DubboClassLoader.getInstance(ReferenceBeanBuilder.class.getName());
    }
}
