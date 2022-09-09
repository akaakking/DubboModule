package org.apache.dubbo.Interface;

import T;
import java.lang.Class;
import java.util.List;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.String;
import java.util.Set;

public interface ExtensionLoaderInterface<T> {

    void destroy();

    String getExtensionName(T extensionInstance);

    String getExtensionName(Class<?> extensionClass);

    List<T> getActivateExtension(URLInterface url, String key);

    List<T> getActivateExtension(URLInterface url, String[] values);

    List<T> getActivateExtension(URLInterface url, String key, String group);

    List<T> getActivateExtension(URLInterface url, String[] values, String group);

    List<T> getActivateExtensions();

    T getLoadedExtension(String name);

    Set<String> getLoadedExtensions();

    List<T> getLoadedExtensionInstances();

    T getExtension(String name);

    T getExtension(String name, boolean wrap);

    T getOrDefaultExtension(String name);

    T getDefaultExtension();

    boolean hasExtension(String name);

    Set<String> getSupportedExtensions();

    Set<T> getSupportedExtensionInstances();

    String getDefaultExtensionName();

    void addExtension(String name, Class<?> clazz);

    void replaceExtension(String name, Class<?> clazz);

    T getAdaptiveExtension();

    String toString();
}
