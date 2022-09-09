package org.apache.dubbo.Interface;

import org.apache.dubbo.common.extension.ExtensionAccessor;
import org.apache.dubbo.common.extension.ExtensionPostProcessor;
import java.util.List;
import org.apache.dubbo.Interface.ExtensionDirectorInterface;
import org.apache.dubbo.Interface.ExtensionLoaderInterface;
import java.lang.Class;

public interface ExtensionDirectorInterface extends ExtensionAccessor {

    void addExtensionPostProcessor(ExtensionPostProcessor processor);

    List<ExtensionPostProcessor> getExtensionPostProcessors();

    ExtensionDirectorInterface getExtensionDirector();

    <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type);

    ExtensionDirectorInterface getParent();

    void removeAllCachedLoader();

    void destroy();
}
