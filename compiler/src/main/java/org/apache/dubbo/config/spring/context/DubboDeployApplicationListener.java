package org.apache.dubbo.config.spring.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboDeployApplicationListener implements DubboDeployApplicationListenerInterface {

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void onApplicationEvent(ApplicationContextEvent event) {
        instance.onApplicationEvent(event);
    }

    public int getOrder() {
        return instance.getOrder();
    }
}
