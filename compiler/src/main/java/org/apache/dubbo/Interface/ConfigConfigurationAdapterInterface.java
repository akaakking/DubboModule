package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ConfigConfigurationAdapterInterface{
    Object getInternalProperty(String key);
    Map getProperties();

}