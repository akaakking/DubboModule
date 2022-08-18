package org.apache.dubbo.rpc.model;

import java.util.Map;
import org.apache.dubbo.common.extension.ExtensionScope;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ScopeModel implements ScopeModelInterface {

    public void destroy() {
        instance.destroy();
    }

    public boolean isDestroyed() {
        return instance.isDestroyed();
    }

    public void addDestroyListener(ScopeModelDestroyListenerInterface listener) {
        instance.addDestroyListener(listener);
    }

    public Map<String, Object> getAttributes() {
        return instance.getAttributes();
    }

    public <T> T getAttribute(String key, Class<T> type) {
        return instance.getAttribute(key, type);
    }

    public Object getAttribute(String key) {
        return instance.getAttribute(key);
    }

    public void setAttribute(String key, Object value) {
        instance.setAttribute(key, value);
    }

    public ExtensionDirectorInterface getExtensionDirector() {
        return instance.getExtensionDirector();
    }

    public ScopeBeanFactoryInterface getBeanFactory() {
        return instance.getBeanFactory();
    }

    public ScopeModelInterface getParent() {
        return instance.getParent();
    }

    public ExtensionScope getScope() {
        return instance.getScope();
    }

    public void addClassLoader(ClassLoader classLoader) {
        instance.addClassLoader(classLoader);
    }

    public void removeClassLoader(ClassLoader classLoader) {
        instance.removeClassLoader(classLoader);
    }

    public Set<ClassLoader> getClassLoaders() {
        return instance.getClassLoaders();
    }

    public EnvironmentInterface getModelEnvironment() {
        return instance.getModelEnvironment();
    }

    public String getInternalId() {
        return instance.getInternalId();
    }

    public String getModelName() {
        return instance.getModelName();
    }

    public void setModelName(String modelName) {
        instance.setModelName(modelName);
    }

    public boolean isInternal() {
        return instance.isInternal();
    }

    public String getDesc() {
        return instance.getDesc();
    }

    public String toString() {
        return instance.toString();
    }
}
