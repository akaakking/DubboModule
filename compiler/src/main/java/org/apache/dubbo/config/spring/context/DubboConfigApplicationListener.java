package org.apache.dubbo.config.spring.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigApplicationListener implements DubboConfigApplicationListenerInterface {

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void onApplicationEvent(DubboConfigInitEventInterface event) {
        instance.onApplicationEvent(event.getInternalInstance());
    }

    protected DubboConfigApplicationListenerInterface instance;

    public DubboConfigApplicationListenerInterface getInternalInstance() {
        return instance;
    }
}
