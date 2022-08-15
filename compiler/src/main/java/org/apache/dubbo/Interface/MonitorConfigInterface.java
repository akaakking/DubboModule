package org.apache.dubbo.Interface;

import java.util.Map;

public interface MonitorConfigInterface extends AbstractConfig{
    String getAddress();
    void setAddress(String address);
    String getProtocol();
    void setProtocol(String protocol);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getGroup();
    void setGroup(String group);
    String getVersion();
    void setVersion(String version);
    Map getParameters();
    void setParameters(Map parameters);
    String getInterval();
    void setInterval(String interval);
    boolean isValid();
}