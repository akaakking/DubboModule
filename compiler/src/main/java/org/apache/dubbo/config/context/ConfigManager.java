package org.apache.dubbo.config.context;

import java.util.Optional;
import java.util.Collection;
import java.util.List;
import org.apache.dubbo.config.context.ConfigMode;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.context.AbstractConfigManager;

public class ConfigManager extends AbstractConfigManager implements ConfigManagerInterface {

    public void setApplication(ApplicationConfigInterface application) {
        instance.setApplication(application.getInternalInstance());
    }

    public Optional<ApplicationConfigInterface> getApplication() {
        return instance.getApplication();
    }

    public ApplicationConfigInterface getApplicationOrElseThrow() {
        return instance.getApplicationOrElseThrow();
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor.getInternalInstance());
    }

    public Optional<MonitorConfigInterface> getMonitor() {
        return instance.getMonitor();
    }

    public void setMetrics(MetricsConfigInterface metrics) {
        instance.setMetrics(metrics.getInternalInstance());
    }

    public Optional<MetricsConfigInterface> getMetrics() {
        return instance.getMetrics();
    }

    public void setSsl(SslConfigInterface sslConfig) {
        instance.setSsl(sslConfig.getInternalInstance());
    }

    public Optional<SslConfigInterface> getSsl() {
        return instance.getSsl();
    }

    public void addConfigCenter(ConfigCenterConfigInterface configCenter) {
        instance.addConfigCenter(configCenter.getInternalInstance());
    }

    public void addConfigCenters(Iterable<ConfigCenterConfigInterface> configCenters) {
        instance.addConfigCenters(configCenters);
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

    public void addMetadataReport(MetadataReportConfigInterface metadataReportConfig) {
        instance.addMetadataReport(metadataReportConfig.getInternalInstance());
    }

    public void addMetadataReports(Iterable<MetadataReportConfigInterface> metadataReportConfigs) {
        instance.addMetadataReports(metadataReportConfigs);
    }

    public Collection<MetadataReportConfigInterface> getMetadataConfigs() {
        return instance.getMetadataConfigs();
    }

    public Collection<MetadataReportConfigInterface> getDefaultMetadataConfigs() {
        return instance.getDefaultMetadataConfigs();
    }

    public void addProtocol(ProtocolConfigInterface protocolConfig) {
        instance.addProtocol(protocolConfig.getInternalInstance());
    }

    public void addProtocols(Iterable<ProtocolConfigInterface> protocolConfigs) {
        instance.addProtocols(protocolConfigs);
    }

    public Optional<ProtocolConfigInterface> getProtocol(String idOrName) {
        return instance.getProtocol(idOrName);
    }

    public List<ProtocolConfigInterface> getDefaultProtocols() {
        return instance.getDefaultProtocols();
    }

    public <C extends AbstractConfigInterface> List<C> getDefaultConfigs(Class<C> cls) {
        return instance.getDefaultConfigs(cls);
    }

    public Collection<ProtocolConfigInterface> getProtocols() {
        return instance.getProtocols();
    }

    public void addRegistry(RegistryConfigInterface registryConfig) {
        instance.addRegistry(registryConfig.getInternalInstance());
    }

    public void addRegistries(Iterable<RegistryConfigInterface> registryConfigs) {
        instance.addRegistries(registryConfigs);
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

    public void refreshAll() {
        instance.refreshAll();
    }

    public void loadConfigs() {
        instance.loadConfigs();
    }

    public ConfigModeInterface getConfigMode() {
        return instance.getConfigMode();
    }

    public ConfigManagerInterface getInternalInstance() {
        return instance;
    }

    public ConfigManager(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigManagerInterface) DubboClassLoader.getInstance(ConfigManager.class.getName(), params, args);
        super.instance = instance;
    }

    protected ConfigManager() {
        instance = (ConfigManagerInterface) DubboClassLoader.getInstance(ConfigManager.class.getName());
        super.instance = instance;
    }
}
