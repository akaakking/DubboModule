package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapStatedEvent extends ApplicationEvent implements DubboBootstrapStatedEventInterface {

    public DubboBootstrapInterface getDubboBootstrap() {
        return instance.getDubboBootstrap();
    }

    public DubboBootstrapStatedEventInterface getInternalInstance() {
        return instance;
    }

    public DubboBootstrapStatedEvent(DubboBootstrapInterface bootstrap) {
        Class[] params = new Class[]{DubboBootstrapInterface.class};
        Object[] args = new Object[]{bootstrap};
        instance = (DubboBootstrapStatedEventInterface) DubboClassLoader.getInstance(DubboBootstrapStatedEvent.class.getName(), params, args);
        super.instance = instance;
    }

    protected DubboBootstrapStatedEvent() {
        instance = (DubboBootstrapStatedEventInterface) DubboClassLoader.getInstance(DubboBootstrapStatedEvent.class.getName());
        super.instance = instance;
    }
}
