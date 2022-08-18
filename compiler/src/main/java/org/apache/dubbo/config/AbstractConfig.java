package org.apache.dubbo.config;

import org.apache.dubbo.config.annotation.Argument;
import java.io.Serializable;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.config.context.ConfigMode;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractConfig implements AbstractConfigInterface {

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ScopeModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public void setScopeModel(ScopeModelInterface scopeModel) {
        instance.setScopeModel(scopeModel);
    }

    public String getId() {
        return instance.getId();
    }

    public void setId(String id) {
        instance.setId(id);
    }

    public Map<String, String> getMetaData() {
        return instance.getMetaData();
    }

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public ConfigMode getConfigMode() {
        return instance.getConfigMode();
    }

    public void overrideWithConfig(AbstractConfigInterface newOne, boolean overrideAll) {
        instance.overrideWithConfig(newOne, overrideAll);
    }

    public void refresh() {
        instance.refresh();
    }

    public boolean isRefreshed() {
        return instance.isRefreshed();
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public Boolean isDefault() {
        return instance.isDefault();
    }

    public void setDefault(Boolean isDefault) {
        instance.setDefault(isDefault);
    }

    public String toString() {
        return instance.toString();
    }

    public boolean equals(Object obj) {
        return instance.equals(obj);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public static String getTagName(Class<?> cls) {
        Method method = instance.getClass().getMethod(Class.class);
        return method.invoke(cls);
    }

    public static String getPluralTagName(Class<?> cls) {
        Method method = instance.getClass().getMethod(Class.class);
        return method.invoke(cls);
    }

    public static void appendParameters(Map<String, String> parameters, Object config) {
        Method method = instance.getClass().getMethod(Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static void appendParameters(Map<String, String> parameters, Object config, String prefix) {
        Method method = instance.getClass().getMethod(Map.class, Object.class, String.class);
        method.invoke(parameters, config, prefix);
    }

    public static void appendAttributes(Map<String, String> parameters, Object config) {
        Method method = instance.getClass().getMethod(Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static String getTypePrefix(Class<? extends AbstractConfig> cls) {
        Method method = instance.getClass().getMethod(Class.class);
        return method.invoke(cls);
    }
}
