package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class MetadataReportConfig extends AbstractConfig implements MetadataReportConfigInterface {

    public URLInterface toUrl() {
        return instance.toUrl();
    }

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
    }

    public StringInterface getAddress() {
        return instance.getAddress();
    }

    public void setAddress(StringInterface address) {
        instance.setAddress(address);
    }

    public IntegerInterface getPort() {
        return instance.getPort();
    }

    public void setPort(IntegerInterface port) {
        instance.setPort(port);
    }

    public StringInterface getUsername() {
        return instance.getUsername();
    }

    public void setUsername(StringInterface username) {
        instance.setUsername(username);
    }

    public StringInterface getPassword() {
        return instance.getPassword();
    }

    public void setPassword(StringInterface password) {
        instance.setPassword(password);
    }

    public IntegerInterface getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(IntegerInterface timeout) {
        instance.setTimeout(timeout);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public IntegerInterface getRetryTimes() {
        return instance.getRetryTimes();
    }

    public void setRetryTimes(IntegerInterface retryTimes) {
        instance.setRetryTimes(retryTimes);
    }

    public IntegerInterface getRetryPeriod() {
        return instance.getRetryPeriod();
    }

    public void setRetryPeriod(IntegerInterface retryPeriod) {
        instance.setRetryPeriod(retryPeriod);
    }

    public BooleanInterface getCycleReport() {
        return instance.getCycleReport();
    }

    public void setCycleReport(BooleanInterface cycleReport) {
        instance.setCycleReport(cycleReport);
    }

    public BooleanInterface getSyncReport() {
        return instance.getSyncReport();
    }

    public void setSyncReport(BooleanInterface syncReport) {
        instance.setSyncReport(syncReport);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public BooleanInterface getCluster() {
        return instance.getCluster();
    }

    public void setCluster(BooleanInterface cluster) {
        instance.setCluster(cluster);
    }

    public StringInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(StringInterface registry) {
        instance.setRegistry(registry);
    }

    public StringInterface getFile() {
        return instance.getFile();
    }

    public void setFile(StringInterface file) {
        instance.setFile(file);
    }

    public void updateParameters(Map<String, String> parameters) {
        instance.updateParameters(parameters);
    }

    public BooleanInterface isCheck() {
        return instance.isCheck();
    }

    public void setCheck(BooleanInterface check) {
        instance.setCheck(check);
    }

    public BooleanInterface getReportMetadata() {
        return instance.getReportMetadata();
    }

    public void setReportMetadata(BooleanInterface reportMetadata) {
        instance.setReportMetadata(reportMetadata);
    }

    public BooleanInterface getReportDefinition() {
        return instance.getReportDefinition();
    }

    public void setReportDefinition(BooleanInterface reportDefinition) {
        instance.setReportDefinition(reportDefinition);
    }

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
