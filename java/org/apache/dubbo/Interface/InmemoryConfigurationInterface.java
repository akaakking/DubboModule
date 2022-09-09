package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;
import java.util.Map;

public interface InmemoryConfigurationInterface extends Configuration {

    Object getInternalProperty(String key);

    void addProperty(String key, String value);

    void addProperties(Map<String, String> properties);

    void setProperties(Map<String, String> properties);

    Map<String, String> getProperties();
}
