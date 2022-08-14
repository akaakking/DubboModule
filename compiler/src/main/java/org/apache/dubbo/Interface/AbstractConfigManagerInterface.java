package org.apache.dubbo.Interface;

import java.util;
import java.lang;

public interface AbstractConfigManagerInterface{
    void initialize();
    TInterface addConfig(AbstractConfigInterface config);
    Map getConfigsMap(Class cls);
    Collection getConfigs(Class configType);
    Optional getConfig(Class cls, String idOrName);
    List getDefaultConfigs(Class cls);
    void loadConfigs();
    List loadConfigsOfTypeFromProps(Class cls);
    void refreshAll();
    boolean removeConfig(AbstractConfigInterface config);
    void destroy();
    void clear();
    boolean isInitialized();

}