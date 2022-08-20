package org.apache.dubbo.config.spring.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboDeployApplicationListener implements DubboDeployApplicationListenerInterface {

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void onApplicationEvent(ApplicationContextEventInterface event) {
        instance.onApplicationEvent(event);
    }

    public int getOrder() {
        return instance.getOrder();
    }

    protected DubboDeployApplicationListenerInterface instance;
}
