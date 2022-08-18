package org.apache.dubbo.common.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Lifecycle implements LifecycleInterface {

    public void initialize() {
        instance.initialize();
    }

    public void start() {
        instance.start();
    }

    public void destroy() {
        instance.destroy();
    }
}
