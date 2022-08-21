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

    public String getCluster() {
        return instance.getCluster();
    }

    public void setCluster(String cluster) {
        instance.setCluster(cluster);
    }

    public String getNamespace() {
        return instance.getNamespace();
    }

    public void setNamespace(String namespace) {
        instance.setNamespace(namespace);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public Boolean isCheck() {
        return instance.isCheck();
    }

    public void setCheck(Boolean check) {
        instance.setCheck(check);
    }

    public Boolean isHighestPriority() {
        return instance.isHighestPriority();
    }

    public void setHighestPriority(Boolean highestPriority) {
        instance.setHighestPriority(highestPriority);
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

    public Long getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(Long timeout) {
        instance.setTimeout(timeout);
    }

    public String getConfigFile() {
        return instance.getConfigFile();
    }

    public void setConfigFile(String configFile) {
        instance.setConfigFile(configFile);
    }

    public String getAppConfigFile() {
        return instance.getAppConfigFile();
    }

    public void setAppConfigFile(String appConfigFile) {
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

    public ConfigCenterConfigInterface getInternalInstance() {
        return instance;
    }

    public protected ConfigCenterConfig() {
        instance = (ConfigCenterConfigInterface) DubboClassLoader.getInstance(ConfigCenterConfig.class.getName());
        super.instance = instance;
    }

    public ConfigCenterConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigCenterConfigInterface) DubboClassLoader.getInstance(ConfigCenterConfig.class.getName(), params, args);
        super.instance = instance;
    }
}
