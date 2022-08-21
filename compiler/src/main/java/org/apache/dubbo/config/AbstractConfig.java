package org.apache.dubbo.config;

import java.io.Serializable;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.lang.String;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.config.context.ConfigMode;
import org.apache.dubbo.config.AbstractConfig;
import java.lang.Boolean;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import java.lang.Class;

public class AbstractConfig implements AbstractConfigInterface {

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ScopeModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public void setScopeModel(ScopeModelInterface scopeModel) {
        instance.setScopeModel(((ScopeModel) scopeModel).getInternalInstance());
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
        instance.overrideWithConfig(((AbstractConfig) newOne).getInternalInstance(), overrideAll);
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
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("getTagName", Class.class);
        return (String)method.invoke(cls);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String getPluralTagName(Class<?> cls) {
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("getPluralTagName", Class.class);
        return (String)method.invoke(cls);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static void appendParameters(Map<String, String> parameters, Object config) {
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("appendParameters", Map.class, Object.class);
        method.invoke(parameters, config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void appendParameters(Map<String, String> parameters, Object config, String prefix) {
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("appendParameters", Map.class, Object.class, String.class);
        method.invoke(parameters, config, prefix);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void appendAttributes(Map<String, String> parameters, Object config) {
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("appendAttributes", Map.class, Object.class);
        method.invoke(parameters, config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static String getTypePrefix(Class<? extends AbstractConfigInterface> cls) {
        try { 
          Class klass = DubboClassLoader.getKlass(AbstractConfig.class.getName());
        Method method = klass.getMethod("getTypePrefix", Class.class);
        return (String)method.invoke(cls);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public AbstractConfigInterface getInternalInstance() {
        return instance;
    }

    protected AbstractConfig() {
        instance = (AbstractConfigInterface) DubboClassLoader.getInstance(AbstractConfig.class.getName());
    }
}
