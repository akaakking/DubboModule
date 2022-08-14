package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ReferenceBeanBuilderInterface{
    ReferenceBeanInterface build();
    ReferenceBeanBuilderInterface setServices(String services);
    ReferenceBeanBuilderInterface setInterface(String interfaceName);
    ReferenceBeanBuilderInterface setInterface(Class interfaceClass);
    ReferenceBeanBuilderInterface setClient(String client);
    ReferenceBeanBuilderInterface setUrl(String url);
    ReferenceBeanBuilderInterface setConsumer(ConsumerConfigInterface consumer);
    ReferenceBeanBuilderInterface setConsumer(String consumer);
    ReferenceBeanBuilderInterface setProtocol(String protocol);
    ReferenceBeanBuilderInterface setCheck(Boolean check);
    ReferenceBeanBuilderInterface setInit(Boolean init);
    ReferenceBeanBuilderInterface setGeneric(Boolean generic);
    ReferenceBeanBuilderInterface setInjvm(Boolean injvm);
    ReferenceBeanBuilderInterface setListener(String listener);
    ReferenceBeanBuilderInterface setLazy(Boolean lazy);
    ReferenceBeanBuilderInterface setOnconnect(String onconnect);
    ReferenceBeanBuilderInterface setOndisconnect(String ondisconnect);
    ReferenceBeanBuilderInterface setReconnect(String reconnect);
    ReferenceBeanBuilderInterface setSticky(Boolean sticky);
    ReferenceBeanBuilderInterface setVersion(String version);
    ReferenceBeanBuilderInterface setGroup(String group);
    ReferenceBeanBuilderInterface setProvidedBy(String providedBy);
    ReferenceBeanBuilderInterface setStub(String stub);
    ReferenceBeanBuilderInterface setCluster(String cluster);
    ReferenceBeanBuilderInterface setProxy(String proxy);
    ReferenceBeanBuilderInterface setConnections(Integer connections);
    ReferenceBeanBuilderInterface setFilter(String filter);
    ReferenceBeanBuilderInterface setLayer(String layer);
    ReferenceBeanBuilderInterface setRegistry(String registryIds);
    ReferenceBeanBuilderInterface setRegistry(RegistryConfigInterface registry);
    ReferenceBeanBuilderInterface setRegistries(List registries);
    ReferenceBeanBuilderInterface setMethods(List methods);
    ReferenceBeanBuilderInterface setMonitor(MonitorConfigInterface monitor);
    ReferenceBeanBuilderInterface setMonitor(String monitor);
    ReferenceBeanBuilderInterface setOwner(String owner);
    ReferenceBeanBuilderInterface setCallbacks(Integer callbacks);
    ReferenceBeanBuilderInterface setScope(String scope);
    ReferenceBeanBuilderInterface setTag(String tag);
    ReferenceBeanBuilderInterface setTimeout(Integer timeout);
    ReferenceBeanBuilderInterface setRetries(Integer retries);
    ReferenceBeanBuilderInterface setLoadBalance(String loadbalance);
    ReferenceBeanBuilderInterface setAsync(Boolean async);
    ReferenceBeanBuilderInterface setActives(Integer actives);
    ReferenceBeanBuilderInterface setSent(Boolean sent);
    ReferenceBeanBuilderInterface setMock(String mock);
    ReferenceBeanBuilderInterface setMerger(String merger);
    ReferenceBeanBuilderInterface setCache(String cache);
    ReferenceBeanBuilderInterface setValidation(String validation);
    ReferenceBeanBuilderInterface setParameters(Map parameters);

}