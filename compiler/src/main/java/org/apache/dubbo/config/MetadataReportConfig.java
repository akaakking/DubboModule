package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataReportConfig implements MetadataReportConfigInterface {

    public URLInterface toUrl() {
        return instance.toUrl();
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public void setAddress(String address) {
        instance.setAddress(address);
    }

    public Integer getPort() {
        return instance.getPort();
    }

    public void setPort(Integer port) {
        instance.setPort(port);
    }

    public String getUsername() {
        return instance.getUsername();
    }

    public void setUsername(String username) {
        instance.setUsername(username);
    }

    public String getPassword() {
        return instance.getPassword();
    }

    public void setPassword(String password) {
        instance.setPassword(password);
    }

    public Integer getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(Integer timeout) {
        instance.setTimeout(timeout);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public Integer getRetryTimes() {
        return instance.getRetryTimes();
    }

    public void setRetryTimes(Integer retryTimes) {
        instance.setRetryTimes(retryTimes);
    }

    public Integer getRetryPeriod() {
        return instance.getRetryPeriod();
    }

    public void setRetryPeriod(Integer retryPeriod) {
        instance.setRetryPeriod(retryPeriod);
    }

    public Boolean getCycleReport() {
        return instance.getCycleReport();
    }

    public void setCycleReport(Boolean cycleReport) {
        instance.setCycleReport(cycleReport);
    }

    public Boolean getSyncReport() {
        return instance.getSyncReport();
    }

    public void setSyncReport(Boolean syncReport) {
        instance.setSyncReport(syncReport);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public Boolean getCluster() {
        return instance.getCluster();
    }

    public void setCluster(Boolean cluster) {
        instance.setCluster(cluster);
    }

    public String getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(String registry) {
        instance.setRegistry(registry);
    }

    public String getFile() {
        return instance.getFile();
    }

    public void setFile(String file) {
        instance.setFile(file);
    }

    public void updateParameters(Map<String, String> parameters) {
        instance.updateParameters(parameters);
    }

    public Boolean isCheck() {
        return instance.isCheck();
    }

    public void setCheck(Boolean check) {
        instance.setCheck(check);
    }

    public Boolean getReportMetadata() {
        return instance.getReportMetadata();
    }

    public void setReportMetadata(Boolean reportMetadata) {
        instance.setReportMetadata(reportMetadata);
    }

    public Boolean getReportDefinition() {
        return instance.getReportDefinition();
    }

    public void setReportDefinition(Boolean reportDefinition) {
        instance.setReportDefinition(reportDefinition);
    }

    protected MetadataReportConfigInterface instance;

    public MetadataReportConfig() {
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class.getName());
    }

    public MetadataReportConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class.getName(), params, args);
    }

    public MetadataReportConfig(String address) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{address};
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class.getName(), params, args);
    }

    public MetadataReportConfig(ApplicationModelInterface applicationModel, String address) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, address};
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class.getName(), params, args);
    }
}
