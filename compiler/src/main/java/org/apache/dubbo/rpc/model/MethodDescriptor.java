package org.apache.dubbo.rpc.model;

import java.lang.reflect.Type;
import org.apache.dubbo.rpc.model.MethodDescriptor$RpcType;
import java.lang.reflect.Method;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MethodDescriptor implements MethodDescriptorInterface {

    public String getMethodName() {
        return instance.getMethodName();
    }

    public String getParamDesc() {
        return instance.getParamDesc();
    }

    public String[] getCompatibleParamSignatures() {
        return instance.getCompatibleParamSignatures();
    }

    public Class<?>[] getParameterClasses() {
        return instance.getParameterClasses();
    }

    public Class<?> getReturnClass() {
        return instance.getReturnClass();
    }

    public Type[] getReturnTypes() {
        return instance.getReturnTypes();
    }

    public RpcType getRpcType() {
        return instance.getRpcType();
    }

    public boolean isGeneric() {
        return instance.isGeneric();
    }

    public Method getMethod() {
        return instance.getMethod();
    }

    public void addAttribute(String key, Object value) {
        instance.addAttribute(key, value);
    }

    public Object getAttribute(String key) {
        return instance.getAttribute(key);
    }
}
