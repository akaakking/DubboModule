package org.apache.dubbo.config.spring.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContextAware;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigApplicationListener implements DubboConfigApplicationListenerInterface {

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void onApplicationEvent(DubboConfigInitEventInterface event) {
        instance.onApplicationEvent(event);
    }

    protected DubboConfigApplicationListenerInterface instance;
}
