package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.Optional;

public interface AbstractConfigManagerInterface {
    void initialize();
    T addConfig(AbstractConfigInterface config);
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