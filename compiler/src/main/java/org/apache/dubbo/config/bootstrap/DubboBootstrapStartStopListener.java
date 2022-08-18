package org.apache.dubbo.config.bootstrap;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStartStopListener implements DubboBootstrapStartStopListenerInterface {

    public void onStart(DubboBootstrapInterface bootstrap) {
        instance.onStart(bootstrap);
    }

    public void onStop(DubboBootstrapInterface bootstrap) {
        instance.onStop(bootstrap);
    }
}
