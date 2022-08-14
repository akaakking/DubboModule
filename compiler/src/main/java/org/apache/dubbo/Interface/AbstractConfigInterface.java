package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.rpc.model;

public interface AbstractConfigInterface{
    String getTagName(Class cls);
    String getPluralTagName(Class cls);
    void appendParameters(Map parameters, Object config);
    void appendParameters(Map parameters, Object config, String prefix);
    void appendAttributes(Map parameters, Object config);
    ApplicationModel getApplicationModel();
    ScopeModel getScopeModel();
    void setScopeModel(ScopeModel scopeModel);
    String getId();
    void setId(String id);
    Map getMetaData();
    List getPrefixes();
    String getTypePrefix(Class cls);
    ConfigModeInterface getConfigMode();
    void overrideWithConfig(AbstractConfigInterface newOne, boolean overrideAll);
    void refresh();
    boolean isRefreshed();
    boolean isValid();
    Boolean isDefault();
    void setDefault(Boolean isDefault);
    String toString();
    boolean equals(Object obj);
    int hashCode();

}