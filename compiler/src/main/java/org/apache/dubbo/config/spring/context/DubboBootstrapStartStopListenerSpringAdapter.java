package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStartStopListenerSpringAdapter implements DubboBootstrapStartStopListenerSpringAdapterInterface {

    public void onStart(DubboBootstrapInterface bootstrap) {
        instance.onStart(bootstrap.getInternalInstance());
    }

    public void onStop(DubboBootstrapInterface bootstrap) {
        instance.onStop(bootstrap.getInternalInstance());
    }

    protected DubboBootstrapStartStopListenerSpringAdapterInterface instance;

    public DubboBootstrapStartStopListenerSpringAdapterInterface getInternalInstance() {
        return instance;
    }

    protected DubboBootstrapStartStopListenerSpringAdapter() {
        instance = (DubboBootstrapStartStopListenerSpringAdapterInterface) DubboClassLoader.getInstance(DubboBootstrapStartStopListenerSpringAdapter.class.getName());
    }
}
