package org.apache.dubbo.Interface;

import java.lang.Class;
import java.lang.String;

public interface ExtensionAccessorInterface {

    ExtensionDirectorInterface getExtensionDirector();

    <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type);

    <T> T getExtension(Class<T> type, String name);

    <T> T getAdaptiveExtension(Class<T> type);

    <T> T getDefaultExtension(Class<T> type);
}
