package org.apache.dubbo.Interface;

import java.lang.reflect.Type;
import java.lang.reflect.Method;
import java.lang.String;
import java.lang.Object;

public interface MethodDescriptorInterface {

    String getMethodName();

    String getParamDesc();

    String[] getCompatibleParamSignatures();

    Class<?>[] getParameterClasses();

    Class<?> getReturnClass();

    Type[] getReturnTypes();

    RpcTypeInterface getRpcType();

    boolean isGeneric();

    Method getMethod();

    void addAttribute(String key, Object value);

    Object getAttribute(String key);
}
