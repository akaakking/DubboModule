package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.common;

public interface MetadataReportConfigInterface{
    URL toUrl();
    String getProtocol();
    void setProtocol(String protocol);
    String getAddress();
    void setAddress(String address);
    Integer getPort();
    void setPort(Integer port);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    Integer getTimeout();
    void setTimeout(Integer timeout);
    Map getParameters();
    void setParameters(Map parameters);
    Integer getRetryTimes();
    void setRetryTimes(Integer retryTimes);
    Integer getRetryPeriod();
    void setRetryPeriod(Integer retryPeriod);
    Boolean getCycleReport();
    void setCycleReport(Boolean cycleReport);
    Boolean getSyncReport();
    void setSyncReport(Boolean syncReport);
    boolean isValid();
    String getGroup();
    void setGroup(String group);
    Boolean getCluster();
    void setCluster(Boolean cluster);
    String getRegistry();
    void setRegistry(String registry);
    String getFile();
    void setFile(String file);
    void updateParameters(Map parameters);
    Boolean isCheck();
    void setCheck(Boolean check);
    Boolean getReportMetadata();
    void setReportMetadata(Boolean reportMetadata);
    Boolean getReportDefinition();
    void setReportDefinition(Boolean reportDefinition);

}