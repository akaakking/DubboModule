package org.apache.dubbo.Interface;

import java.util.Map;

public interface ConfigConfigurationAdapterInterface {
    Object getInternalProperty(String key);
    Map getProperties();
}