package org.apache.dubbo.Interface;

import java.lang.reflect.Method;
import java.lang.String;
import java.lang.Object;

public interface ConsumerMethodModelInterface {

    Method getMethod();

    void addAttribute(String key, Object value);

    Object getAttribute(String key);

    Class<?> getReturnClass();

    String getMethodName();

    String[] getParameterTypes();

    boolean isGeneric();

    Class<?>[] getParameterClasses();
}
