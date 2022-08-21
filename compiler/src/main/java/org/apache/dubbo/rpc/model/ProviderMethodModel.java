package org.apache.dubbo.rpc.model;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentMap;
import java.lang.reflect.Type;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ProviderMethodModel implements ProviderMethodModelInterface {

    public Method getMethod() {
        return instance.getMethod();
    }

    public String getMethodName() {
        return instance.getMethodName();
    }

    public String[] getMethodArgTypes() {
        return instance.getMethodArgTypes();
    }

    public ConcurrentMap<String, Object> getAttributeMap() {
        return instance.getAttributeMap();
    }

    public Class<?>[] getParameterClasses() {
        return instance.getParameterClasses();
    }

    public Type[] getGenericParameterTypes() {
        return instance.getGenericParameterTypes();
    }

    protected ProviderMethodModelInterface instance;

    public ProviderMethodModelInterface getInternalInstance() {
        return instance;
    }

    public ProviderMethodModel(Method method) {
        Class[] params = new Class[]{Method.class};
        Object[] args = new Object[]{method};
        instance = (ProviderMethodModelInterface) DubboClassLoader.getInstance(ProviderMethodModel.class.getName(), params, args);
    }

    protected ProviderMethodModel() {
        instance = (ProviderMethodModelInterface) DubboClassLoader.getInstance(ProviderMethodModel.class.getName());
    }
}
