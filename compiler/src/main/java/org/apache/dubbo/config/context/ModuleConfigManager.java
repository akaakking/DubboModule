package org.apache.dubbo.config.context;

import java.util.Optional;
import java.util.Collection;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.context.AbstractConfigManager;

public class ModuleConfigManager extends AbstractConfigManager implements ModuleConfigManagerInterface {

    public void setModule(ModuleConfigInterface module) {
        instance.setModule(module.getInternalInstance(), module);
    }

    public Optional<ModuleConfigInterface> getModule() {
        return instance.getModule();
    }

    public void addService(ServiceConfigBaseInterface<?> serviceConfig) {
        instance.addService(serviceConfig);
    }

    public void addServices(Iterable<ServiceConfigBaseInterface<?>> serviceConfigs) {
        instance.addServices(serviceConfigs);
    }

    public Collection<ServiceConfigBaseInterface> getServices() {
        return instance.getServices();
    }

    public <T> ServiceConfigBaseInterface<T> getService(String id) {
        return instance.getService(id);
    }

    public void addReference(ReferenceConfigBaseInterface<?> referenceConfig) {
        instance.addReference(referenceConfig);
    }

    public void addReferences(Iterable<ReferenceConfigBaseInterface<?>> referenceConfigs) {
        instance.addReferences(referenceConfigs);
    }

    public Collection<ReferenceConfigBaseInterface<?>> getReferences() {
        return instance.getReferences();
    }

    public <T> ReferenceConfigBaseInterface<T> getReference(String id) {
        return instance.getReference(id);
    }

    public void addProvider(ProviderConfigInterface providerConfig) {
        instance.addProvider(providerConfig.getInternalInstance(), providerConfig);
    }

    public void addProviders(Iterable<ProviderConfigInterface> providerConfigs) {
        instance.addProviders(providerConfigs);
    }

    public Optional<ProviderConfigInterface> getProvider(String id) {
        return instance.getProvider(id);
    }

    public Optional<ProviderConfigInterface> getDefaultProvider() {
        return instance.getDefaultProvider();
    }

    public Collection<ProviderConfigInterface> getProviders() {
        return instance.getProviders();
    }

    public void addConsumer(ConsumerConfigInterface consumerConfig) {
        instance.addConsumer(consumerConfig.getInternalInstance(), consumerConfig);
    }

    public void addConsumers(Iterable<ConsumerConfigInterface> consumerConfigs) {
        instance.addConsumers(consumerConfigs);
    }

    public Optional<ConsumerConfigInterface> getConsumer(String id) {
        return instance.getConsumer(id);
    }

    public Optional<ConsumerConfigInterface> getDefaultConsumer() {
        return instance.getDefaultConsumer();
    }

    public Collection<ConsumerConfigInterface> getConsumers() {
        return instance.getConsumers();
    }

    public void refreshAll() {
        instance.refreshAll();
    }

    public void clear() {
        instance.clear();
    }

    public void loadConfigs() {
        instance.loadConfigs();
    }

    public ConfigManagerInterface getApplicationConfigManager() {
        return instance.getApplicationConfigManager();
    }

    public <C extends AbstractConfigInterface> Map<String, C> getConfigsMap(Class<C> cls) {
        return instance.getConfigsMap(cls);
    }

    public <C extends AbstractConfigInterface> Collection<C> getConfigs(Class<C> configType) {
        return instance.getConfigs(configType);
    }

    public <T extends AbstractConfigInterface> Optional<T> getConfig(Class<T> cls, String idOrName) {
        return instance.getConfig(cls, idOrName);
    }

    public <C extends AbstractConfigInterface> List<C> getDefaultConfigs(Class<C> cls) {
        return instance.getDefaultConfigs(cls);
    }

    public Optional<ApplicationConfigInterface> getApplication() {
        return instance.getApplication();
    }

    public Optional<MonitorConfigInterface> getMonitor() {
        return instance.getMonitor();
    }

    public Optional<MetricsConfigInterface> getMetrics() {
        return instance.getMetrics();
    }

    public Optional<SslConfigInterface> getSsl() {
        return instance.getSsl();
    }

    public Optional<Collection<ConfigCenterConfigInterface>> getDefaultConfigCenter() {
        return instance.getDefaultConfigCenter();
    }

    public Optional<ConfigCenterConfigInterface> getConfigCenter(String id) {
        return instance.getConfigCenter(id);
    }

    public Collection<ConfigCenterConfigInterface> getConfigCenters() {
        return instance.getConfigCenters();
    }

    public Collection<MetadataReportConfigInterface> getMetadataConfigs() {
        return instance.getMetadataConfigs();
    }

    public Collection<MetadataReportConfigInterface> getDefaultMetadataConfigs() {
        return instance.getDefaultMetadataConfigs();
    }

    public Optional<ProtocolConfigInterface> getProtocol(String idOrName) {
        return instance.getProtocol(idOrName);
    }

    public List<ProtocolConfigInterface> getDefaultProtocols() {
        return instance.getDefaultProtocols();
    }

    public Collection<ProtocolConfigInterface> getProtocols() {
        return instance.getProtocols();
    }

    public Optional<RegistryConfigInterface> getRegistry(String id) {
        return instance.getRegistry(id);
    }

    public List<RegistryConfigInterface> getDefaultRegistries() {
        return instance.getDefaultRegistries();
    }

    public Collection<RegistryConfigInterface> getRegistries() {
        return instance.getRegistries();
    }

    public ModuleConfigManagerInterface getInternalInstance() {
        return instance;
    }

    public ModuleConfigManagerInterface getInternalInstance() {
        return instance;
    }

    public ModuleConfigManager(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleConfigManagerInterface) DubboClassLoader.getInstance(ModuleConfigManager.class.getName(), params, args);
    }
}
