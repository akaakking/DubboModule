package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface MonitorConfigInterface{
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