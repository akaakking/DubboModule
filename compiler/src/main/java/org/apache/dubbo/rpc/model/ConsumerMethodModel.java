package org.apache.dubbo.rpc.model;

import java.lang.reflect.Method;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConsumerMethodModel implements ConsumerMethodModelInterface {

    public MethodInterface getMethod() {
        return instance.getMethod();
    }

    public void addAttribute(StringInterface key, ObjectInterface value) {
        instance.addAttribute(key, value);
    }

    public ObjectInterface getAttribute(StringInterface key) {
        return instance.getAttribute(key);
    }

    public Class<?> getReturnClass() {
        return instance.getReturnClass();
    }

    public StringInterface getMethodName() {
        return instance.getMethodName();
    }

    public StringInterface[] getParameterTypes() {
        return instance.getParameterTypes();
    }

    public boolean isGeneric() {
        return instance.isGeneric();
    }

    public Class<?>[] getParameterClasses() {
        return instance.getParameterClasses();
    }

    protected ConsumerMethodModelInterface instance;

    public ConsumerMethodModel(Method method) {
        Class[] params = new Class[]{Method.class};
        Object[] args = new Object[]{method};
        instance = (ConsumerMethodModelInterface) DubboClassLoader.getInstance(ConsumerMethodModel.class.getName(), params, args);
    }
}
