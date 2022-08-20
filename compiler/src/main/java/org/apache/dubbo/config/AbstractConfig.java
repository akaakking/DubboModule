package org.apache.dubbo.config;

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

    public StringInterface getId() {
        return instance.getId();
    }

    public void setId(StringInterface id) {
        instance.setId(id);
    }

    public Map<String, String> getMetaData() {
        return instance.getMetaData();
    }

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public ConfigModeInterface getConfigMode() {
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

    public BooleanInterface isDefault() {
        return instance.isDefault();
    }

    public void setDefault(BooleanInterface isDefault) {
        instance.setDefault(isDefault);
    }

    public StringInterface toString() {
        return instance.toString();
    }

    public boolean equals(ObjectInterface obj) {
        return instance.equals(obj);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    protected AbstractConfigInterface instance;

    public static StringInterface getTagName(Class<?> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getTagName, Class.class);
        return method.invoke(cls);
    }

    public static StringInterface getPluralTagName(Class<?> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getPluralTagName, Class.class);
        return method.invoke(cls);
    }

    public static void appendParameters(Map<String, String> parameters, ObjectInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendParameters, Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static void appendParameters(Map<String, String> parameters, ObjectInterface config, StringInterface prefix) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendParameters, Map.class, Object.class, String.class);
        method.invoke(parameters, config, prefix);
    }

    public static void appendAttributes(Map<String, String> parameters, ObjectInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendAttributes, Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static StringInterface getTypePrefix(Class<? extends AbstractConfigInterface> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getTypePrefix, Class.class);
        return method.invoke(cls);
    }
}
