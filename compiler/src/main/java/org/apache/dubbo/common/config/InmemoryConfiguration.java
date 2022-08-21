package org.apache.dubbo.common.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class InmemoryConfiguration implements InmemoryConfigurationInterface {

    public Object getInternalProperty(String key) {
        return instance.getInternalProperty(key);
    }

    public void addProperty(String key, String value) {
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

    public InmemoryConfigurationInterface getInternalInstance() {
        return instance;
    }

    public protected InmemoryConfiguration() {
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
