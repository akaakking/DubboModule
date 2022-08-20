package org.apache.dubbo.rpc.model;

import java.lang.reflect.Method;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AsyncMethodInfo implements AsyncMethodInfoInterface {

    public ObjectInterface getOninvokeInstance() {
        return instance.getOninvokeInstance();
    }

    public void setOninvokeInstance(ObjectInterface oninvokeInstance) {
        instance.setOninvokeInstance(oninvokeInstance);
    }

    public MethodInterface getOninvokeMethod() {
        return instance.getOninvokeMethod();
    }

    public void setOninvokeMethod(MethodInterface oninvokeMethod) {
        instance.setOninvokeMethod(oninvokeMethod);
    }

    public ObjectInterface getOnreturnInstance() {
        return instance.getOnreturnInstance();
    }

    public void setOnreturnInstance(ObjectInterface onreturnInstance) {
        instance.setOnreturnInstance(onreturnInstance);
    }

    public MethodInterface getOnreturnMethod() {
        return instance.getOnreturnMethod();
    }

    public void setOnreturnMethod(MethodInterface onreturnMethod) {
        instance.setOnreturnMethod(onreturnMethod);
    }

    public ObjectInterface getOnthrowInstance() {
        return instance.getOnthrowInstance();
    }

    public void setOnthrowInstance(ObjectInterface onthrowInstance) {
        instance.setOnthrowInstance(onthrowInstance);
    }

    public MethodInterface getOnthrowMethod() {
        return instance.getOnthrowMethod();
    }

    public void setOnthrowMethod(MethodInterface onthrowMethod) {
        instance.setOnthrowMethod(onthrowMethod);
    }

    protected AsyncMethodInfoInterface instance;
}
