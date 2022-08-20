package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class MonitorBuilder extends AbstractBuilder<MonitorConfig, MonitorBuilder> implements MonitorBuilderInterface {

    public MonitorBuilderInterface protocol(StringInterface protocol) {
        return instance.protocol(protocol);
    }

    public MonitorBuilderInterface address(StringInterface address) {
        return instance.address(address);
    }

    public MonitorBuilderInterface username(StringInterface username) {
        return instance.username(username);
    }

    public MonitorBuilderInterface password(StringInterface password) {
        return instance.password(password);
    }

    public MonitorBuilderInterface group(StringInterface group) {
        return instance.group(group);
    }

    public MonitorBuilderInterface version(StringInterface version) {
        return instance.version(version);
    }

    public MonitorBuilderInterface interval(StringInterface interval) {
        return instance.interval(interval);
    }

    public MonitorBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public MonitorBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public MonitorBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public MonitorConfigInterface build() {
        return instance.build();
    }
}
