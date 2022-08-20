package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigInitEvent extends ApplicationEvent implements DubboConfigInitEventInterface {

    public ApplicationContextInterface getApplicationContext() {
        return instance.getApplicationContext();
    }

    public DubboConfigInitEvent(ApplicationContext source) {
        Class[] params = new Class[]{ApplicationContext.class};
        Object[] args = new Object[]{source};
        instance = (DubboConfigInitEventInterface) DubboClassLoader.getInstance(DubboConfigInitEvent.class.getName(), params, args);
    }
}