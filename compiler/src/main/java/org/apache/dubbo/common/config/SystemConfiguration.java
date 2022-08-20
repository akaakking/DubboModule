package org.apache.dubbo.common.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SystemConfiguration implements SystemConfigurationInterface {

    public ObjectInterface getInternalProperty(StringInterface key) {
        return instance.getInternalProperty(key);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    protected SystemConfigurationInterface instance;
}
