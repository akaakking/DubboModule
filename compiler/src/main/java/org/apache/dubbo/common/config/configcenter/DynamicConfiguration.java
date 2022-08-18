package org.apache.dubbo.common.config.configcenter;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DynamicConfiguration implements DynamicConfigurationInterface {

    public void addListener(String key, ConfigurationListenerInterface listener) {
        instance.addListener(key, listener);
    }

    public void removeListener(String key, ConfigurationListenerInterface listener) {
        instance.removeListener(key, listener);
    }

    public void addListener(String key, String group, ConfigurationListenerInterface listener) {
        instance.addListener(key, group, listener);
    }

    public void removeListener(String key, String group, ConfigurationListenerInterface listener) {
        instance.removeListener(key, group, listener);
    }

    public String getConfig(String key, String group) {
        return instance.getConfig(key, group);
    }

    public ConfigItemInterface getConfigItem(String key, String group) {
        return instance.getConfigItem(key, group);
    }

    public String getConfig(String key, String group, long timeout) {
        return instance.getConfig(key, group, timeout);
    }

    public String getProperties(String key, String group) {
        return instance.getProperties(key, group);
    }

    public String getProperties(String key, String group, long timeout) {
        return instance.getProperties(key, group, timeout);
    }

    public boolean publishConfig(String key, String content) {
        return instance.publishConfig(key, content);
    }

    public boolean publishConfig(String key, String group, String content) {
        return instance.publishConfig(key, group, content);
    }

    public boolean publishConfigCas(String key, String group, String content, Object ticket) {
        return instance.publishConfigCas(key, group, content, ticket);
    }

    public String getDefaultGroup() {
        return instance.getDefaultGroup();
    }

    public long getDefaultTimeout() {
        return instance.getDefaultTimeout();
    }

    public void close() {
        instance.close();
    }

    public boolean removeConfig(String key, String group) {
        return instance.removeConfig(key, group);
    }

    public static String getRuleKey(URLInterface url) {
        Method method = instance.getClass().getMethod(URLInterface.class);
        return method.invoke(url);
    }
}
