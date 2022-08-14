package org.apache.dubbo.Interface;

import java.util;
import java.lang;

public interface ConfigManagerInterface{
    void setApplication(ApplicationConfigInterface application);
    Optional getApplication();
    ApplicationConfigInterface getApplicationOrElseThrow();
    void setMonitor(MonitorConfigInterface monitor);
    Optional getMonitor();
    void setMetrics(MetricsConfigInterface metrics);
    Optional getMetrics();
    void setSsl(SslConfigInterface sslConfig);
    Optional getSsl();
    void addConfigCenter(ConfigCenterConfigInterface configCenter);
    void addConfigCenters(Iterable configCenters);
    Optional getDefaultConfigCenter();
    Optional getConfigCenter(String id);
    Collection getConfigCenters();
    void addMetadataReport(MetadataReportConfigInterface metadataReportConfig);
    void addMetadataReports(Iterable metadataReportConfigs);
    Collection getMetadataConfigs();
    Collection getDefaultMetadataConfigs();
    void addProtocol(ProtocolConfigInterface protocolConfig);
    void addProtocols(Iterable protocolConfigs);
    Optional getProtocol(String idOrName);
    List getDefaultProtocols();
    List getDefaultConfigs(Class cls);
    Collection getProtocols();
    void addRegistry(RegistryConfigInterface registryConfig);
    void addRegistries(Iterable registryConfigs);
    Optional getRegistry(String id);
    List getDefaultRegistries();
    Collection getRegistries();
    void refreshAll();
    void loadConfigs();
    ConfigModeInterface getConfigMode();

}