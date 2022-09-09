package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;
import java.util.Properties;
import java.util.Map;

public interface PropertiesConfigurationInterface extends Configuration {

    void refresh();

    String getProperty(String key);

    Object getInternalProperty(String key);

    void setProperty(String key, String value);

    String remove(String key);

    void setProperties(Properties properties);

    Map<String, String> getProperties();
}
