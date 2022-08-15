package org.apache.dubbo.Interface;

import java.util.List;

public interface ModuleConfigInterface {
    String getName();
    void setName(String name);
    String getVersion();
    void setVersion(String version);
    String getOwner();
    void setOwner(String owner);
    String getOrganization();
    void setOrganization(String organization);
    RegistryConfigInterface getRegistry();
    void setRegistry(RegistryConfigInterface registry);
    List getRegistries();
    void setRegistries(List registries);
    MonitorConfigInterface getMonitor();
    void setMonitor(MonitorConfigInterface monitor);
    void setMonitor(String monitor);
    Boolean getBackground();
    void setBackground(Boolean background);
    Integer getReferThreadNum();
    void setReferThreadNum(Integer referThreadNum);
    Integer getExportThreadNum();
    void setExportThreadNum(Integer exportThreadNum);
    Boolean getReferAsync();
    void setReferAsync(Boolean referAsync);
    Boolean getExportAsync();
    void setExportAsync(Boolean exportAsync);
}