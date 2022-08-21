package org.apache.dubbo.common.config;

import java.lang.String;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SystemConfiguration implements SystemConfigurationInterface {

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    protected SystemConfigurationInterface instance;

    public SystemConfigurationInterface getInternalInstance() {
        return instance;
    }

    protected SystemConfiguration() {
        instance = (SystemConfigurationInterface) DubboClassLoader.getInstance(SystemConfiguration.class.getName());
    }
}
