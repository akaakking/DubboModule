package org.apache.dubbo.rpc.model;

import java.lang.reflect.Method;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AsyncMethodInfo implements AsyncMethodInfoInterface {

    public Object getOninvokeInstance() {
        return instance.getOninvokeInstance();
    }

    public void setOninvokeInstance(Object oninvokeInstance) {
        instance.setOninvokeInstance(oninvokeInstance);
    }

    public Method getOninvokeMethod() {
        return instance.getOninvokeMethod();
    }

    public void setOninvokeMethod(Method oninvokeMethod) {
        instance.setOninvokeMethod(oninvokeMethod);
    }

    public Object getOnreturnInstance() {
        return instance.getOnreturnInstance();
    }

    public void setOnreturnInstance(Object onreturnInstance) {
        instance.setOnreturnInstance(onreturnInstance);
    }

    public Method getOnreturnMethod() {
        return instance.getOnreturnMethod();
    }

    public void setOnreturnMethod(Method onreturnMethod) {
        instance.setOnreturnMethod(onreturnMethod);
    }

    public Object getOnthrowInstance() {
        return instance.getOnthrowInstance();
    }

    public void setOnthrowInstance(Object onthrowInstance) {
        instance.setOnthrowInstance(onthrowInstance);
    }

    public Method getOnthrowMethod() {
        return instance.getOnthrowMethod();
    }

    public void setOnthrowMethod(Method onthrowMethod) {
        instance.setOnthrowMethod(onthrowMethod);
    }

    protected AsyncMethodInfoInterface instance;

    public AsyncMethodInfoInterface getInternalInstance() {
        return instance;
    }

    public AsyncMethodInfoInterface getInternalInstance() {
        return instance;
    }
}
