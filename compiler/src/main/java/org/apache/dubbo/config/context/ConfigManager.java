package org.apache.dubbo.config.context;

import java.util.Collection;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import org.apache.dubbo.config.context.ConfigMode;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigManager implements ConfigManagerInterface {

    public void setApplication(ApplicationConfigInterface application) {
        instance.setApplication(application);
    }

    public Optional<ApplicationConfig> getApplication() {
        return instance.getApplication();
    }

    public ApplicationConfigInterface getApplicationOrElseThrow() {
        return instance.getApplicationOrElseThrow();
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor);
    }

    public Optional<MonitorConfig> getMonitor() {
        return instance.getMonitor();
    }

    public void setMetrics(MetricsConfigInterface metrics) {
        instance.setMetrics(metrics);
    }

    public Optional<MetricsConfig> getMetrics() {
        return instance.getMetrics();
    }

    public void setSsl(SslConfigInterface sslConfig) {
        instance.setSsl(sslConfig);
    }

    public Optional<SslConfig> getSsl() {
        return instance.getSsl();
    }

    public void addConfigCenter(ConfigCenterConfigInterface configCenter) {
        instance.addConfigCenter(configCenter);
    }

    public void addConfigCenters(Iterable<ConfigCenterConfig> configCenters) {
        instance.addConfigCenters(configCenters);
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

    public void addMetadataReport(MetadataReportConfigInterface metadataReportConfig) {
        instance.addMetadataReport(metadataReportConfig);
    }

    public void addMetadataReports(Iterable<MetadataReportConfig> metadataReportConfigs) {
        instance.addMetadataReports(metadataReportConfigs);
    }

    public Collection<MetadataReportConfig> getMetadataConfigs() {
        return instance.getMetadataConfigs();
    }

    public Collection<MetadataReportConfig> getDefaultMetadataConfigs() {
        return instance.getDefaultMetadataConfigs();
    }

    public void addProtocol(ProtocolConfigInterface protocolConfig) {
        instance.addProtocol(protocolConfig);
    }

    public void addProtocols(Iterable<ProtocolConfig> protocolConfigs) {
        instance.addProtocols(protocolConfigs);
    }

    public Optional<ProtocolConfig> getProtocol(String idOrName) {
        return instance.getProtocol(idOrName);
    }

    public List<ProtocolConfig> getDefaultProtocols() {
        return instance.getDefaultProtocols();
    }

    public <C extends AbstractConfigInterface> List<C> getDefaultConfigs(Class<C> cls) {
        return instance.getDefaultConfigs(cls);
    }

    public Collection<ProtocolConfig> getProtocols() {
        return instance.getProtocols();
    }

    public void addRegistry(RegistryConfigInterface registryConfig) {
        instance.addRegistry(registryConfig);
    }

    public void addRegistries(Iterable<RegistryConfig> registryConfigs) {
        instance.addRegistries(registryConfigs);
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

    public void refreshAll() {
        instance.refreshAll();
    }

    public void loadConfigs() {
        instance.loadConfigs();
    }

    public ConfigMode getConfigMode() {
        return instance.getConfigMode();
    }

    protected ConfigManagerInterface instance;

    public ConfigManager(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigManagerInterface) DubboClassLoader.getInstance(ConfigManager.class.getName(), params, args);
    }
}
