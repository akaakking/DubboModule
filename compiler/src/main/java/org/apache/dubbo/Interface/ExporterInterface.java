package org.apache.dubbo.Interface;


public interface ExporterInterface {
    Boolean getEnabled();
    void setEnabled(Boolean enabled);
    Boolean getEnableHttpServiceDiscovery();
    void setEnableHttpServiceDiscovery(Boolean enableHttpServiceDiscovery);
    String getHttpServiceDiscoveryUrl();
    void setHttpServiceDiscoveryUrl(String httpServiceDiscoveryUrl);
    Integer getMetricsPort();
    void setMetricsPort(Integer metricsPort);
    String getMetricsPath();
    void setMetricsPath(String metricsPath);
}