package org.apache.dubbo.rpc.model;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentMap;
import java.lang.reflect.Type;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ProviderMethodModel implements ProviderMethodModelInterface {

    public MethodInterface getMethod() {
        return instance.getMethod();
    }

    public StringInterface getMethodName() {
        return instance.getMethodName();
    }

    public StringInterface[] getMethodArgTypes() {
        return instance.getMethodArgTypes();
    }

    public ConcurrentMap<String, Object> getAttributeMap() {
        return instance.getAttributeMap();
    }

    public Class<?>[] getParameterClasses() {
        return instance.getParameterClasses();
    }

    public TypeInterface[] getGenericParameterTypes() {
        return instance.getGenericParameterTypes();
    }

    protected ProviderMethodModelInterface instance;

    public ProviderMethodModel(Method method) {
        Class[] params = new Class[]{Method.class};
        Object[] args = new Object[]{method};
        instance = (ProviderMethodModelInterface) DubboClassLoader.getInstance(ProviderMethodModel.class.getName(), params, args);
    }
}
