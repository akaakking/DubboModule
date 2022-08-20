package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ConfigCenterConfig extends AbstractConfig implements ConfigCenterConfigInterface {

    public URLInterface toUrl() {
        return instance.toUrl();
    }

    public boolean checkOrUpdateInitialized(boolean update) {
        return instance.checkOrUpdateInitialized(update);
    }

    public void setInitialized(boolean val) {
        instance.setInitialized(val);
    }

    public Map<String, String> getExternalConfiguration() {
        return instance.getExternalConfiguration();
    }

    public Map<String, String> getAppExternalConfiguration() {
        return instance.getAppExternalConfiguration();
    }

    public void setExternalConfig(Map<String, String> externalConfiguration) {
        instance.setExternalConfig(externalConfiguration);
    }

    public void setAppExternalConfig(Map<String, String> appExternalConfiguration) {
        instance.setAppExternalConfig(appExternalConfiguration);
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

    public StringInterface getCluster() {
        return instance.getCluster();
    }

    public void setCluster(StringInterface cluster) {
        instance.setCluster(cluster);
    }

    public StringInterface getNamespace() {
        return instance.getNamespace();
    }

    public void setNamespace(StringInterface namespace) {
        instance.setNamespace(namespace);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public BooleanInterface isCheck() {
        return instance.isCheck();
    }

    public void setCheck(BooleanInterface check) {
        instance.setCheck(check);
    }

    public BooleanInterface isHighestPriority() {
        return instance.isHighestPriority();
    }

    public void setHighestPriority(BooleanInterface highestPriority) {
        instance.setHighestPriority(highestPriority);
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

    public LongInterface getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(LongInterface timeout) {
        instance.setTimeout(timeout);
    }

    public StringInterface getConfigFile() {
        return instance.getConfigFile();
    }

    public void setConfigFile(StringInterface configFile) {
        instance.setConfigFile(configFile);
    }

    public StringInterface getAppConfigFile() {
        return instance.getAppConfigFile();
    }

    public void setAppConfigFile(StringInterface appConfigFile) {
        instance.setAppConfigFile(appConfigFile);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public void updateParameters(Map<String, String> parameters) {
        instance.updateParameters(parameters);
    }

    public ConfigCenterConfig() {
        instance = (ConfigCenterConfigInterface) DubboClassLoader.getInstance(ConfigCenterConfig.class.getName());
    }

    public ConfigCenterConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigCenterConfigInterface) DubboClassLoader.getInstance(ConfigCenterConfig.class.getName(), params, args);
    }
}
