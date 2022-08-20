package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStartStopListenerSpringAdapter implements DubboBootstrapStartStopListenerSpringAdapterInterface {

    public void onStart(DubboBootstrapInterface bootstrap) {
        instance.onStart(bootstrap);
    }

    public void onStop(DubboBootstrapInterface bootstrap) {
        instance.onStop(bootstrap);
    }

    protected DubboBootstrapStartStopListenerSpringAdapterInterface instance;
}
