package org.apache.dubbo.Interface;

import java.util.Map;

public interface MonitorBuilderInterface {
    MonitorBuilderInterface protocol(String protocol);
    MonitorBuilderInterface address(String address);
    MonitorBuilderInterface username(String username);
    MonitorBuilderInterface password(String password);
    MonitorBuilderInterface group(String group);
    MonitorBuilderInterface version(String version);
    MonitorBuilderInterface interval(String interval);
    MonitorBuilderInterface isDefault(Boolean isDefault);
    MonitorBuilderInterface appendParameter(String key, String value);
    MonitorBuilderInterface appendParameters(Map appendParameters);
    MonitorConfigInterface build();
}