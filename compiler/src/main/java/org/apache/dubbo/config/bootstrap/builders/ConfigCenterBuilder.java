package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ConfigCenterBuilder extends AbstractBuilder<ConfigCenterConfig, ConfigCenterBuilder> implements ConfigCenterBuilderInterface {

    public ConfigCenterBuilderInterface protocol(StringInterface protocol) {
        return instance.protocol(protocol);
    }

    public ConfigCenterBuilderInterface address(StringInterface address) {
        return instance.address(address);
    }

    public ConfigCenterBuilderInterface cluster(StringInterface cluster) {
        return instance.cluster(cluster);
    }

    public ConfigCenterBuilderInterface namespace(StringInterface namespace) {
        return instance.namespace(namespace);
    }

    public ConfigCenterBuilderInterface group(StringInterface group) {
        return instance.group(group);
    }

    public ConfigCenterBuilderInterface username(StringInterface username) {
        return instance.username(username);
    }

    public ConfigCenterBuilderInterface password(StringInterface password) {
        return instance.password(password);
    }

    public ConfigCenterBuilderInterface timeout(LongInterface timeout) {
        return instance.timeout(timeout);
    }

    public ConfigCenterBuilderInterface highestPriority(BooleanInterface highestPriority) {
        return instance.highestPriority(highestPriority);
    }

    public ConfigCenterBuilderInterface check(BooleanInterface check) {
        return instance.check(check);
    }

    public ConfigCenterBuilderInterface configFile(StringInterface configFile) {
        return instance.configFile(configFile);
    }

    public ConfigCenterBuilderInterface appConfigFile(StringInterface appConfigFile) {
        return instance.appConfigFile(appConfigFile);
    }

    public ConfigCenterBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ConfigCenterBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public ConfigCenterConfigInterface build() {
        return instance.build();
    }
}
