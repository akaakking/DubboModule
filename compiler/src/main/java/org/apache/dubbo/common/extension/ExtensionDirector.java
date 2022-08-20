package org.apache.dubbo.common.extension;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionDirector implements ExtensionDirectorInterface {

    public void addExtensionPostProcessor(ExtensionPostProcessorInterface processor) {
        instance.addExtensionPostProcessor(processor.getInternalInstance());
    }

    public List<ExtensionPostProcessorInterface> getExtensionPostProcessors() {
        return instance.getExtensionPostProcessors();
    }

    public ExtensionDirectorInterface getExtensionDirector() {
        return instance.getExtensionDirector();
    }

    public <T> ExtensionLoaderInterface<T> getExtensionLoader(Class<T> type) {
        return instance.getExtensionLoader(type);
    }

    public ExtensionDirectorInterface getParent() {
        return instance.getParent();
    }

    public void removeAllCachedLoader() {
        instance.removeAllCachedLoader();
    }

    public void destroy() {
        instance.destroy();
    }

    protected ExtensionDirectorInterface instance;

    public ExtensionDirectorInterface getInternalInstance() {
        return instance;
    }

    public ExtensionDirector(ExtensionDirectorInterface parent, ExtensionScopeInterface scope, ScopeModelInterface scopeModel) {
        Class[] params = new Class[]{ExtensionDirectorInterface.class, ExtensionScopeInterface.class, ScopeModelInterface.class};
        Object[] args = new Object[]{parent, scope, scopeModel};
        instance = (ExtensionDirectorInterface) DubboClassLoader.getInstance(ExtensionDirector.class.getName(), params, args);
    }
}
