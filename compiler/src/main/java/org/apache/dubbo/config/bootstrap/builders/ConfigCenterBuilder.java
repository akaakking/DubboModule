package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ConfigCenterBuilder extends AbstractBuilder<ConfigCenterConfig, ConfigCenterBuilder> implements ConfigCenterBuilderInterface {

    public ConfigCenterBuilderInterface protocol(String protocol) {
        return instance.protocol(protocol);
    }

    public ConfigCenterBuilderInterface address(String address) {
        return instance.address(address);
    }

    public ConfigCenterBuilderInterface cluster(String cluster) {
        return instance.cluster(cluster);
    }

    public ConfigCenterBuilderInterface namespace(String namespace) {
        return instance.namespace(namespace);
    }

    public ConfigCenterBuilderInterface group(String group) {
        return instance.group(group);
    }

    public ConfigCenterBuilderInterface username(String username) {
        return instance.username(username);
    }

    public ConfigCenterBuilderInterface password(String password) {
        return instance.password(password);
    }

    public ConfigCenterBuilderInterface timeout(Long timeout) {
        return instance.timeout(timeout);
    }

    public ConfigCenterBuilderInterface highestPriority(Boolean highestPriority) {
        return instance.highestPriority(highestPriority);
    }

    public ConfigCenterBuilderInterface check(Boolean check) {
        return instance.check(check);
    }

    public ConfigCenterBuilderInterface configFile(String configFile) {
        return instance.configFile(configFile);
    }

    public ConfigCenterBuilderInterface appConfigFile(String appConfigFile) {
        return instance.appConfigFile(appConfigFile);
    }

    public ConfigCenterBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ConfigCenterBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public ConfigCenterConfigInterface build() {
        return instance.build();
    }

    public ConfigCenterBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ConfigCenterBuilder() {
        instance = (ConfigCenterBuilderInterface) DubboClassLoader.getInstance(ConfigCenterBuilder.class.getName());
        super.instance = instance;
    }
}
