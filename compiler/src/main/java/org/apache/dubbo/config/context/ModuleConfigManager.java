package org.apache.dubbo.config.context;

import java.util.Optional;
import java.util.Collection;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ModuleConfigManager implements ModuleConfigManagerInterface {

    public void setModule(ModuleConfigInterface module) {
        instance.setModule(module);
    }

    public Optional<ModuleConfig> getModule() {
        return instance.getModule();
    }

    public void addService(ServiceConfigBaseInterface<?> serviceConfig) {
        instance.addService(serviceConfig);
    }

    public void addServices(Iterable<ServiceConfigBase<?>> serviceConfigs) {
        instance.addServices(serviceConfigs);
    }

    public Collection<ServiceConfigBase> getServices() {
        return instance.getServices();
    }

    public <T> ServiceConfigBaseInterface<T> getService(String id) {
        return instance.getService(id);
    }

    public void addReference(ReferenceConfigBaseInterface<?> referenceConfig) {
        instance.addReference(referenceConfig);
    }

    public void addReferences(Iterable<ReferenceConfigBase<?>> referenceConfigs) {
        instance.addReferences(referenceConfigs);
    }

    public Collection<ReferenceConfigBase<?>> getReferences() {
        return instance.getReferences();
    }

    public <T> ReferenceConfigBaseInterface<T> getReference(String id) {
        return instance.getReference(id);
    }

    public void addProvider(ProviderConfigInterface providerConfig) {
        instance.addProvider(providerConfig);
    }

    public void addProviders(Iterable<ProviderConfig> providerConfigs) {
        instance.addProviders(providerConfigs);
    }

    public Optional<ProviderConfig> getProvider(String id) {
        return instance.getProvider(id);
    }

    public Optional<ProviderConfig> getDefaultProvider() {
        return instance.getDefaultProvider();
    }

    public Collection<ProviderConfig> getProviders() {
        return instance.getProviders();
    }

    public void addConsumer(ConsumerConfigInterface consumerConfig) {
        instance.addConsumer(consumerConfig);
    }

    public void addConsumers(Iterable<ConsumerConfig> consumerConfigs) {
        instance.addConsumers(consumerConfigs);
    }

    public Optional<ConsumerConfig> getConsumer(String id) {
        return instance.getConsumer(id);
    }

    public Optional<ConsumerConfig> getDefaultConsumer() {
        return instance.getDefaultConsumer();
    }

    public Collection<ConsumerConfig> getConsumers() {
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

    public Optional<ApplicationConfig> getApplication() {
        return instance.getApplication();
    }

    public Optional<MonitorConfig> getMonitor() {
        return instance.getMonitor();
    }

    public Optional<MetricsConfig> getMetrics() {
        return instance.getMetrics();
    }

    public Optional<SslConfig> getSsl() {
        return instance.getSsl();
    }

    public Optional<Collection<ConfigCenterConfig>> getDefaultConfigCenter() {
        return instance.getDefaultConfigCenter();
    }

    public Optional<ConfigCenterConfig> getConfigCenter(String id) {
        return instance.getConfigCenter(id);
    }

    public Collection<ConfigCenterConfig> getConfigCenters() {
        return instance.getConfigCenters();
    }

    public Collection<MetadataReportConfig> getMetadataConfigs() {
        return instance.getMetadataConfigs();
    }

    public Collection<MetadataReportConfig> getDefaultMetadataConfigs() {
        return instance.getDefaultMetadataConfigs();
    }

    public Optional<ProtocolConfig> getProtocol(String idOrName) {
        return instance.getProtocol(idOrName);
    }

    public List<ProtocolConfig> getDefaultProtocols() {
        return instance.getDefaultProtocols();
    }

    public Collection<ProtocolConfig> getProtocols() {
        return instance.getProtocols();
    }

    public Optional<RegistryConfig> getRegistry(String id) {
        return instance.getRegistry(id);
    }

    public List<RegistryConfig> getDefaultRegistries() {
        return instance.getDefaultRegistries();
    }

    public Collection<RegistryConfig> getRegistries() {
        return instance.getRegistries();
    }

    protected ModuleConfigManagerInterface instance;

    public ModuleConfigManager(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleConfigManagerInterface) DubboClassLoader.getInstance(ModuleConfigManager.class.getName(), params, args);
    }
}
