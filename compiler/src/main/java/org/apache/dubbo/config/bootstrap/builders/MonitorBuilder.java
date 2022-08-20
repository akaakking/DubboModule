package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class MonitorBuilder extends AbstractBuilder<MonitorConfig, MonitorBuilder> implements MonitorBuilderInterface {

    public MonitorBuilderInterface protocol(String protocol) {
        return instance.protocol(protocol);
    }

    public MonitorBuilderInterface address(String address) {
        return instance.address(address);
    }

    public MonitorBuilderInterface username(String username) {
        return instance.username(username);
    }

    public MonitorBuilderInterface password(String password) {
        return instance.password(password);
    }

    public MonitorBuilderInterface group(String group) {
        return instance.group(group);
    }

    public MonitorBuilderInterface version(String version) {
        return instance.version(version);
    }

    public MonitorBuilderInterface interval(String interval) {
        return instance.interval(interval);
    }

    public MonitorBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public MonitorBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public MonitorBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public MonitorConfigInterface build() {
        return instance.build();
    }

    public MonitorBuilderInterface getInternalInstance() {
        return instance;
    }
}
