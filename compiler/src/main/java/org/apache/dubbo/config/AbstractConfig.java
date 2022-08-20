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
        instance.setScopeModel(scopeModel.getInternalInstance(), scopeModel);
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

    public ConfigModeInterface getConfigMode() {
        return instance.getConfigMode();
    }

    public void overrideWithConfig(AbstractConfigInterface newOne, boolean overrideAll) {
        instance.overrideWithConfig(newOne.getInternalInstance(), newOne, overrideAll);
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

    protected AbstractConfigInterface instance;

    public static String getTagName(Class<?> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getTagName, Class.class);
        return method.invoke(cls);
    }

    public static String getPluralTagName(Class<?> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getPluralTagName, Class.class);
        return method.invoke(cls);
    }

    public static void appendParameters(Map<String, String> parameters, Object config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendParameters, Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static void appendParameters(Map<String, String> parameters, Object config, String prefix) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendParameters, Map.class, Object.class, String.class);
        method.invoke(parameters, config, prefix);
    }

    public static void appendAttributes(Map<String, String> parameters, Object config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendAttributes, Map.class, Object.class);
        method.invoke(parameters, config);
    }

    public static String getTypePrefix(Class<? extends AbstractConfigInterface> cls) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getTypePrefix, Class.class);
        return method.invoke(cls);
    }

    public AbstractConfigInterface getInternalInstance() {
        return instance;
    }

    public AbstractConfigInterface getInternalInstance() {
        return instance;
    }
}
