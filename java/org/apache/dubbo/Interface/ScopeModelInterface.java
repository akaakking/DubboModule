package org.apache.dubbo.Interface;

import org.apache.dubbo.common.extension.ExtensionAccessor;
import org.apache.dubbo.rpc.model.ScopeModelDestroyListener;
import org.apache.dubbo.rpc.model.ScopeClassLoaderListener;
import java.util.Map;
import java.lang.String;
import java.lang.Class;
import java.lang.Object;
import org.apache.dubbo.Interface.ExtensionDirectorInterface;
import org.apache.dubbo.Interface.ScopeBeanFactoryInterface;
import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.common.extension.ExtensionScope;
import java.lang.ClassLoader;
import java.util.Set;
import org.apache.dubbo.Interface.EnvironmentInterface;

public interface ScopeModelInterface extends ExtensionAccessor {

    void destroy();

    boolean isDestroyed();

    void addDestroyListener(ScopeModelDestroyListener listener);

    void addClassLoaderListener(ScopeClassLoaderListener listener);

    Map<String, Object> getAttributes();

    <T> T getAttribute(String key, Class<T> type);

    Object getAttribute(String key);

    void setAttribute(String key, Object value);

    ExtensionDirectorInterface getExtensionDirector();

    ScopeBeanFactoryInterface getBeanFactory();

    ScopeModelInterface getParent();

    ExtensionScope getScope();

    void addClassLoader(ClassLoader classLoader);

    void removeClassLoader(ClassLoader classLoader);

    Set<ClassLoader> getClassLoaders();

    EnvironmentInterface getModelEnvironment();

    String getInternalId();

    String getModelName();

    void setModelName(String modelName);

    boolean isInternal();

    String getDesc();

    String toString();
}
