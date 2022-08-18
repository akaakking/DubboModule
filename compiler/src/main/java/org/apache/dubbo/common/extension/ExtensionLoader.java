package org.apache.dubbo.common.extension;

import java.util.List;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

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
        return instance.getActivateExtension(url, key);
    }

    public List<T> getActivateExtension(URLInterface url, String[] values) {
        return instance.getActivateExtension(url, values);
    }

    public List<T> getActivateExtension(URLInterface url, String key, String group) {
        return instance.getActivateExtension(url, key, group);
    }

    public List<T> getActivateExtension(URLInterface url, String[] values, String group) {
        return instance.getActivateExtension(url, values, group);
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

    public static void setLoadingStrategies(LoadingStrategyInterface strategies) {
        Method method = instance.getClass().getMethod(LoadingStrategyInterface.class);
        method.invoke(strategies);
    }

    public static List<LoadingStrategy> getLoadingStrategies() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type) {
        Method method = instance.getClass().getMethod(Class.class);
        return method.invoke(type);
    }

    public static void resetExtensionLoader(Class type) {
        Method method = instance.getClass().getMethod(Class.class);
        method.invoke(type);
    }
}
