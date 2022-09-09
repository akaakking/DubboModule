package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;
import java.util.Map;

public interface EnvironmentConfigurationInterface extends Configuration {

    Object getInternalProperty(String key);

    Map<String, String> getProperties();
}
