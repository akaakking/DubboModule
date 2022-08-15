package org.apache.dubbo.Interface;

import java.util.Map;

public interface ConfigCenterBuilderInterface {
    ConfigCenterBuilderInterface protocol(String protocol);
    ConfigCenterBuilderInterface address(String address);
    ConfigCenterBuilderInterface cluster(String cluster);
    ConfigCenterBuilderInterface namespace(String namespace);
    ConfigCenterBuilderInterface group(String group);
    ConfigCenterBuilderInterface username(String username);
    ConfigCenterBuilderInterface password(String password);
    ConfigCenterBuilderInterface timeout(Long timeout);
    ConfigCenterBuilderInterface highestPriority(Boolean highestPriority);
    ConfigCenterBuilderInterface check(Boolean check);
    ConfigCenterBuilderInterface configFile(String configFile);
    ConfigCenterBuilderInterface appConfigFile(String appConfigFile);
    ConfigCenterBuilderInterface appendParameters(Map appendParameters);
    ConfigCenterBuilderInterface appendParameter(String key, String value);
    ConfigCenterConfigInterface build();
}