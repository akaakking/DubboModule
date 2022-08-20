package org.apache.dubbo.common.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class InmemoryConfiguration implements InmemoryConfigurationInterface {

    public ObjectInterface getInternalProperty(StringInterface key) {
        return instance.getInternalProperty(key);
    }

    public void addProperty(StringInterface key, StringInterface value) {
        instance.addProperty(key, value);
    }

    public void addProperties(Map<String, String> properties) {
        instance.addProperties(properties);
    }

    public void setProperties(Map<String, String> properties) {
        instance.setProperties(properties);
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    protected InmemoryConfigurationInterface instance;

    public InmemoryConfiguration() {
        instance = (InmemoryConfigurationInterface) DubboClassLoader.getInstance(InmemoryConfiguration.class.getName());
    }

    public InmemoryConfiguration(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (InmemoryConfigurationInterface) DubboClassLoader.getInstance(InmemoryConfiguration.class.getName(), params, args);
    }

    public InmemoryConfiguration(Map<String, String> properties) {
        Class[] params = new Class[]{MapMap<String,String>.class};
        Object[] args = new Object[]{properties};
        instance = (InmemoryConfigurationInterface) DubboClassLoader.getInstance(InmemoryConfiguration.class.getName(), params, args);
    }
}
