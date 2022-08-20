package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStartStopListenerSpringAdapter implements DubboBootstrapStartStopListenerSpringAdapterInterface {

    public void onStart(DubboBootstrapInterface bootstrap) {
        instance.onStart(bootstrap.getInternalInstance(), bootstrap);
    }

    public void onStop(DubboBootstrapInterface bootstrap) {
        instance.onStop(bootstrap.getInternalInstance(), bootstrap);
    }

    protected DubboBootstrapStartStopListenerSpringAdapterInterface instance;

    public DubboBootstrapStartStopListenerSpringAdapterInterface getInternalInstance() {
        return instance;
    }

    public DubboBootstrapStartStopListenerSpringAdapterInterface getInternalInstance() {
        return instance;
    }
}
