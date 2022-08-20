package org.apache.dubbo.common.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class PropertiesConfiguration implements PropertiesConfigurationInterface {

    public void refresh() {
        instance.refresh();
    }

    public StringInterface getProperty(StringInterface key) {
        return instance.getProperty(key);
    }

    public ObjectInterface getInternalProperty(StringInterface key) {
        return instance.getInternalProperty(key);
    }

    public void setProperty(StringInterface key, StringInterface value) {
        instance.setProperty(key, value);
    }

    public StringInterface remove(StringInterface key) {
        return instance.remove(key);
    }

    public void setProperties(PropertiesInterface properties) {
        instance.setProperties(properties);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    protected PropertiesConfigurationInterface instance;

    public PropertiesConfiguration(ScopeModelInterface scopeModel) {
        Class[] params = new Class[]{ScopeModelInterface.class};
        Object[] args = new Object[]{scopeModel};
        instance = (PropertiesConfigurationInterface) DubboClassLoader.getInstance(PropertiesConfiguration.class.getName(), params, args);
    }
}
