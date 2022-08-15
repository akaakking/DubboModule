package org.apache.dubbo.Interface;

import org.apache.dubbo.common.URL;
import java.util.Map;

public interface ConfigCenterConfigInterface extends AbstractConfig{
    URL toUrl();
    boolean checkOrUpdateInitialized(boolean update);
    void setInitialized(boolean val);
    Map getExternalConfiguration();
    Map getAppExternalConfiguration();
    void setExternalConfig(Map externalConfiguration);
    void setAppExternalConfig(Map appExternalConfiguration);
    String getProtocol();
    void setProtocol(String protocol);
    String getAddress();
    void setAddress(String address);
    Integer getPort();
    void setPort(Integer port);
    String getCluster();
    void setCluster(String cluster);
    String getNamespace();
    void setNamespace(String namespace);
    String getGroup();
    void setGroup(String group);
    Boolean isCheck();
    void setCheck(Boolean check);
    Boolean isHighestPriority();
    void setHighestPriority(Boolean highestPriority);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    Long getTimeout();
    void setTimeout(Long timeout);
    String getConfigFile();
    void setConfigFile(String configFile);
    String getAppConfigFile();
    void setAppConfigFile(String appConfigFile);
    Map getParameters();
    void setParameters(Map parameters);
    boolean isValid();
    void updateParameters(Map parameters);
}