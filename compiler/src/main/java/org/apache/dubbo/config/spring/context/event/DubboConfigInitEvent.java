package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigInitEvent extends ApplicationEvent implements DubboConfigInitEventInterface {

    public ApplicationContext getApplicationContext() {
        return instance.getApplicationContext();
    }

    protected DubboConfigInitEventInterface instance;

    public DubboConfigInitEventInterface getInternalInstance() {
        return instance;
    }

    public DubboConfigInitEvent(ApplicationContext source) {
        Class[] params = new Class[]{ApplicationContext.class};
        Object[] args = new Object[]{source};
        instance = (DubboConfigInitEventInterface) DubboClassLoader.getInstance(DubboConfigInitEvent.class.getName(), params, args);
        super.instance = this.instance;
    }

    protected DubboConfigInitEvent() {
        instance = (DubboConfigInitEventInterface) DubboClassLoader.getInstance(DubboConfigInitEvent.class.getName());
        super.instance = this.instance;
    }
}
