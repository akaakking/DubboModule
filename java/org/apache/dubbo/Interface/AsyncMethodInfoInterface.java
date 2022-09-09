package org.apache.dubbo.Interface;

import java.lang.Object;
import java.lang.reflect.Method;

public interface AsyncMethodInfoInterface {

    Object getOninvokeInstance();

    void setOninvokeInstance(Object oninvokeInstance);

    Method getOninvokeMethod();

    void setOninvokeMethod(Method oninvokeMethod);

    Object getOnreturnInstance();

    void setOnreturnInstance(Object onreturnInstance);

    Method getOnreturnMethod();

    void setOnreturnMethod(Method onreturnMethod);

    Object getOnthrowInstance();

    void setOnthrowInstance(Object onthrowInstance);

    Method getOnthrowMethod();

    void setOnthrowMethod(Method onthrowMethod);
}
