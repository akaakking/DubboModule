package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceListener implements ServiceListenerInterface {

    public void exported(ServiceConfigInterface sc) {
        instance.exported(sc);
    }

    public void unexported(ServiceConfigInterface sc) {
        instance.unexported(sc);
    }
}
