package org.apache.dubbo.Interface;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentMap;
import java.lang.reflect.Type;

public interface ProviderMethodModelInterface {

    Method getMethod();

    String getMethodName();

    String[] getMethodArgTypes();

    ConcurrentMap<String, Object> getAttributeMap();

    Class<?>[] getParameterClasses();

    Type[] getGenericParameterTypes();
}
