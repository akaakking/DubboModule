package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;
import org.apache.dubbo.common.config.configcenter.ConfigurationListener;
import java.lang.Object;

public interface DynamicConfigurationInterface extends Configuration, AutoCloseable {

    void addListener(String key, ConfigurationListener listener);

    void removeListener(String key, ConfigurationListener listener);

    void addListener(String key, String group, ConfigurationListener listener);

    void removeListener(String key, String group, ConfigurationListener listener);

    String getConfig(String key, String group);

    ConfigItemInterface getConfigItem(String key, String group);

    String getConfig(String key, String group, long timeout);

    String getProperties(String key, String group);

    String getProperties(String key, String group, long timeout);

    boolean publishConfig(String key, String content);

    boolean publishConfig(String key, String group, String content);

    boolean publishConfigCas(String key, String group, String content, Object ticket);

    String getDefaultGroup();

    long getDefaultTimeout();

    void close();

    boolean removeConfig(String key, String group);
}
