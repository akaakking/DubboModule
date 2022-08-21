package org.apache.dubbo.common.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class LifecycleAdapter implements LifecycleAdapterInterface {

    public void initialize() {
        instance.initialize();
    }

    public void start() {
        instance.start();
    }

    public void destroy() {
        instance.destroy();
    }

    protected LifecycleAdapterInterface instance;

    public LifecycleAdapterInterface getInternalInstance() {
        return instance;
    }

    protected LifecycleAdapter() {
    }
}
