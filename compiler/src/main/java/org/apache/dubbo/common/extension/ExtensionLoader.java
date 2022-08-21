package org.apache.dubbo.common.extension;

import T;
import java.lang.Class;
import java.util.List;
import org.apache.dubbo.common.URL;
import java.lang.String;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.apache.dubbo.common.extension.LoadingStrategy;

public class ExtensionLoader<T> implements ExtensionLoaderInterface<T> {

    public void destroy() {
        instance.destroy();
    }

    public String getExtensionName(T extensionInstance) {
        return instance.getExtensionName(extensionInstance);
    }

    public String getExtensionName(Class<?> extensionClass) {
        return instance.getExtensionName(extensionClass);
    }

    public List<T> getActivateExtension(URLInterface url, String key) {
        return instance.getActivateExtension(((URL) url).getInternalInstance(), key);
    }

    public List<T> getActivateExtension(URLInterface url, String[] values) {
        return instance.getActivateExtension(((URL) url).getInternalInstance(), values);
    }

    public List<T> getActivateExtension(URLInterface url, String key, String group) {
        return instance.getActivateExtension(((URL) url).getInternalInstance(), key, group);
    }

    public List<T> getActivateExtension(URLInterface url, String[] values, String group) {
        return instance.getActivateExtension(((URL) url).getInternalInstance(), values, group);
    }

    public List<T> getActivateExtensions() {
        return instance.getActivateExtensions();
    }

    public T getLoadedExtension(String name) {
        return instance.getLoadedExtension(name);
    }

    public Set<String> getLoadedExtensions() {
        return instance.getLoadedExtensions();
    }

    public List<T> getLoadedExtensionInstances() {
        return instance.getLoadedExtensionInstances();
    }

    public T getExtension(String name) {
        return instance.getExtension(name);
    }

    public T getExtension(String name, boolean wrap) {
        return instance.getExtension(name, wrap);
    }

    public T getOrDefaultExtension(String name) {
        return instance.getOrDefaultExtension(name);
    }

    public T getDefaultExtension() {
        return instance.getDefaultExtension();
    }

    public boolean hasExtension(String name) {
        return instance.hasExtension(name);
    }

    public Set<String> getSupportedExtensions() {
        return instance.getSupportedExtensions();
    }

    public Set<T> getSupportedExtensionInstances() {
        return instance.getSupportedExtensionInstances();
    }

    public String getDefaultExtensionName() {
        return instance.getDefaultExtensionName();
    }

    public void addExtension(String name, Class<?> clazz) {
        instance.addExtension(name, clazz);
    }

    public void replaceExtension(String name, Class<?> clazz) {
        instance.replaceExtension(name, clazz);
    }

    public T getAdaptiveExtension() {
        return instance.getAdaptiveExtension();
    }

    public String toString() {
        return instance.toString();
    }

    protected ExtensionLoaderInterface instance;

    public static void setLoadingStrategies(LoadingStrategyInterface strategies) {
        try { 
          Class klass = DubboClassLoader.getKlass(ExtensionLoader.class.getName());
        Method method = klass.getMethod("setLoadingStrategies", LoadingStrategyInterface.class);
        method.invoke(strategies);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static List<LoadingStrategyInterface> getLoadingStrategies() {
        try { 
          Class klass = DubboClassLoader.getKlass(ExtensionLoader.class.getName());
        Method method = klass.getMethod("getLoadingStrategies");
        return (List<LoadingStrategyInterface>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type) {
        try { 
          Class klass = DubboClassLoader.getKlass(ExtensionLoader.class.getName());
        Method method = klass.getMethod("getExtensionLoader", Class.class);
        return (ExtensionLoaderInterface<T>)method.invoke(type);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static void resetExtensionLoader(Class type) {
        try { 
          Class klass = DubboClassLoader.getKlass(ExtensionLoader.class.getName());
        Method method = klass.getMethod("resetExtensionLoader", Class.class);
        method.invoke(type);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public ExtensionLoaderInterface getInternalInstance() {
        return instance;
    }

    protected ExtensionLoader() {
        instance = (ExtensionLoaderInterface) DubboClassLoader.getInstance(ExtensionLoader.class.getName());
    }
}
