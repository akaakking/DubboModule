package org.apache.dubbo.common.extension;

import java.util.List;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionLoader<T> implements ExtensionLoaderInterface<T> {

    public void destroy() {
        instance.destroy();
    }

    public StringInterface getExtensionName(T extensionInstance) {
        return instance.getExtensionName(extensionInstance);
    }

    public StringInterface getExtensionName(Class<?> extensionClass) {
        return instance.getExtensionName(extensionClass);
    }

    public List<T> getActivateExtension(URLInterface url, StringInterface key) {
        return instance.getActivateExtension(url, key);
    }

    public List<T> getActivateExtension(URLInterface url, StringInterface[] values) {
        return instance.getActivateExtension(url, values);
    }

    public List<T> getActivateExtension(URLInterface url, StringInterface key, StringInterface group) {
        return instance.getActivateExtension(url, key, group);
    }

    public List<T> getActivateExtension(URLInterface url, StringInterface[] values, StringInterface group) {
        return instance.getActivateExtension(url, values, group);
    }

    public List<T> getActivateExtensions() {
        return instance.getActivateExtensions();
    }

    public T getLoadedExtension(StringInterface name) {
        return instance.getLoadedExtension(name);
    }

    public Set<String> getLoadedExtensions() {
        return instance.getLoadedExtensions();
    }

    public List<T> getLoadedExtensionInstances() {
        return instance.getLoadedExtensionInstances();
    }

    public T getExtension(StringInterface name) {
        return instance.getExtension(name);
    }

    public T getExtension(StringInterface name, boolean wrap) {
        return instance.getExtension(name, wrap);
    }

    public T getOrDefaultExtension(StringInterface name) {
        return instance.getOrDefaultExtension(name);
    }

    public T getDefaultExtension() {
        return instance.getDefaultExtension();
    }

    public boolean hasExtension(StringInterface name) {
        return instance.hasExtension(name);
    }

    public Set<String> getSupportedExtensions() {
        return instance.getSupportedExtensions();
    }

    public Set<T> getSupportedExtensionInstances() {
        return instance.getSupportedExtensionInstances();
    }

    public StringInterface getDefaultExtensionName() {
        return instance.getDefaultExtensionName();
    }

    public void addExtension(StringInterface name, Class<?> clazz) {
        instance.addExtension(name, clazz);
    }

    public void replaceExtension(StringInterface name, Class<?> clazz) {
        instance.replaceExtension(name, clazz);
    }

    public T getAdaptiveExtension() {
        return instance.getAdaptiveExtension();
    }

    public StringInterface toString() {
        return instance.toString();
    }

    protected ExtensionLoaderInterface instance;

    public static void setLoadingStrategies(LoadingStrategyInterface strategies) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(setLoadingStrategies, LoadingStrategyInterface.class);
        method.invoke(strategies);
    }

    public static List<LoadingStrategyInterface> getLoadingStrategies() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getLoadingStrategies);
        return method.invoke();
    }

    public static <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getExtensionLoader, Class.class);
        return method.invoke(type);
    }

    public static void resetExtensionLoader(ClassInterface type) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(resetExtensionLoader, Class.class);
        method.invoke(type);
    }
}
