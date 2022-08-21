package org.apache.dubbo.common.config;

import java.util.Properties;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class PropertiesConfiguration implements PropertiesConfigurationInterface {

    public void refresh() {
        instance.refresh();
    }

    public String getProperty(String key) {
        return instance.getProperty(key);
    }

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    public void setProperty(String key, String value) {
        instance.setProperty(key, value);
    }

    public String remove(String key) {
        return instance.remove(key);
    }

    public void setProperties(Properties properties) {
        instance.setProperties(properties);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    protected PropertiesConfigurationInterface instance;

    public PropertiesConfigurationInterface getInternalInstance() {
        return instance;
    }

    public PropertiesConfiguration(ScopeModelInterface scopeModel) {
        Class[] params = new Class[]{ScopeModelInterface.class};
        Object[] args = new Object[]{scopeModel};
        instance = (PropertiesConfigurationInterface) DubboClassLoader.getInstance(PropertiesConfiguration.class.getName(), params, args);
    }

    protected PropertiesConfiguration() {
        instance = (PropertiesConfigurationInterface) DubboClassLoader.getInstance(PropertiesConfiguration.class.getName());
    }
}
