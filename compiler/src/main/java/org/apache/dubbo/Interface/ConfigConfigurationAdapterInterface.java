package org.apache.dubbo.Interface;

import java.util.Map;

public interface ConfigConfigurationAdapterInterface extends Object, Configuration{
    Object getInternalProperty(String key);
    Map getProperties();
}