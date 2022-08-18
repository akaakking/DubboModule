package org.apache.dubbo.rpc;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Invoker<T> implements InvokerInterface<T> {

    public Class<T> getInterface() {
        return instance.getInterface();
    }

    public ResultInterface invoke(InvocationInterface invocation) {
        return instance.invoke(invocation);
    }

    public void destroyAll() {
        instance.destroyAll();
    }
}
