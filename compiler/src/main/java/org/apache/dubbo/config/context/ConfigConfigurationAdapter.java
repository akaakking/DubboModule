package org.apache.dubbo.config.context;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigConfigurationAdapter implements ConfigConfigurationAdapterInterface {

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    public ConfigConfigurationAdapter(AbstractConfigInterface config, String prefix) {
        Class[] params = new Class[]{AbstractConfigInterface.class, String.class};
        Object[] args = new Object[]{config, prefix};
        instance = (ConfigConfigurationAdapterInterface) DubboClassLoader.getInstance(ConfigConfigurationAdapter.class.getName(), params, args);
    }
}
