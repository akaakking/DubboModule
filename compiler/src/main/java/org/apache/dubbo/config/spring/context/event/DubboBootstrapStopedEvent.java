package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStopedEvent extends ApplicationEvent implements DubboBootstrapStopedEventInterface {

    public DubboBootstrapInterface getDubboBootstrap() {
        return instance.getDubboBootstrap();
    }

    protected DubboBootstrapStopedEventInterface instance;

    public DubboBootstrapStopedEventInterface getInternalInstance() {
        return instance;
    }

    public DubboBootstrapStopedEvent(DubboBootstrapInterface bootstrap) {
        Class[] params = new Class[]{DubboBootstrapInterface.class};
        Object[] args = new Object[]{bootstrap};
        instance = (DubboBootstrapStopedEventInterface) DubboClassLoader.getInstance(DubboBootstrapStopedEvent.class.getName(), params, args);
        super.instance = this.instance;
    }

    protected DubboBootstrapStopedEvent() {
        instance = (DubboBootstrapStopedEventInterface) DubboClassLoader.getInstance(DubboBootstrapStopedEvent.class.getName());
        super.instance = this.instance;
    }
}
