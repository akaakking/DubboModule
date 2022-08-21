package org.apache.dubbo.common.config;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class CompositeConfiguration implements CompositeConfigurationInterface {

    public boolean isDynamicIncluded() {
        return instance.isDynamicIncluded();
    }

    public void setDynamicIncluded(boolean dynamicIncluded) {
        instance.setDynamicIncluded(dynamicIncluded);
    }

    public void addConfiguration(ConfigurationInterface configuration) {
        instance.addConfiguration(((Configuration) configuration).getInternalInstance());
    }

    public void addConfigurationFirst(ConfigurationInterface configuration) {
        instance.addConfigurationFirst(((Configuration) configuration).getInternalInstance());
    }

    public void addConfiguration(int pos, ConfigurationInterface configuration) {
        instance.addConfiguration(pos, ((Configuration) configuration).getInternalInstance());
    }

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    protected CompositeConfigurationInterface instance;

    public CompositeConfigurationInterface getInternalInstance() {
        return instance;
    }

    public CompositeConfiguration() {
        instance = (CompositeConfigurationInterface) DubboClassLoader.getInstance(CompositeConfiguration.class.getName());
    }

    public CompositeConfiguration(ConfigurationInterface configurations) {
        Class[] params = new Class[]{ConfigurationInterface.class};
        Object[] args = new Object[]{configurations};
        instance = (CompositeConfigurationInterface) DubboClassLoader.getInstance(CompositeConfiguration.class.getName(), params, args);
    }
}
