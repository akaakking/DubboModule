package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface ModuleConfigManagerInterface {
    void setModule(ModuleConfigInterface module);
    Optional getModule();
    void addService(ServiceConfigBaseInterface<T> serviceConfig);
    void addServices(Iterable serviceConfigs);
    Collection getServices();
    ServiceConfigBaseInterface<T> getService(String id);
    void addReference(ReferenceConfigBaseInterface<T> referenceConfig);
    void addReferences(Iterable referenceConfigs);
    Collection getReferences();
    ReferenceConfigBaseInterface<T> getReference(String id);
    void addProvider(ProviderConfigInterface providerConfig);
    void addProviders(Iterable providerConfigs);
    Optional getProvider(String id);
    Optional getDefaultProvider();
    Collection getProviders();
    void addConsumer(ConsumerConfigInterface consumerConfig);
    void addConsumers(Iterable consumerConfigs);
    Optional getConsumer(String id);
    Optional getDefaultConsumer();
    Collection getConsumers();
    void refreshAll();
    void clear();
    void loadConfigs();
    ConfigManagerInterface getApplicationConfigManager();
    Map getConfigsMap(Class cls);
    Collection getConfigs(Class configType);
    Optional getConfig(Class cls, String idOrName);
    List getDefaultConfigs(Class cls);
    Optional getApplication();
    Optional getMonitor();
    Optional getMetrics();
    Optional getSsl();
    Optional getDefaultConfigCenter();
    Optional getConfigCenter(String id);
    Collection getConfigCenters();
    Collection getMetadataConfigs();
    Collection getDefaultMetadataConfigs();
    Optional getProtocol(String idOrName);
    List getDefaultProtocols();
    Collection getProtocols();
    Optional getRegistry(String id);
    List getDefaultRegistries();
    Collection getRegistries();
}