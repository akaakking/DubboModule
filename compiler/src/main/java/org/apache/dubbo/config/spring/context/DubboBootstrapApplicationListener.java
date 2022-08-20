package org.apache.dubbo.config.spring.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrapApplicationListener implements DubboBootstrapApplicationListenerInterface {

    public void onApplicationEvent(ApplicationEventInterface event) {
        instance.onApplicationEvent(event);
    }

    public int getOrder() {
        return instance.getOrder();
    }

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public ApplicationContextInterface getApplicationContext() {
        return instance.getApplicationContext();
    }

    protected DubboBootstrapApplicationListenerInterface instance;

    public DubboBootstrapApplicationListener() {
        instance = (DubboBootstrapApplicationListenerInterface) DubboClassLoader.getInstance(DubboBootstrapApplicationListener.class.getName());
    }

    public DubboBootstrapApplicationListener(boolean shouldInitConfigBeans) {
        Class[] params = new Class[]{boolean.class};
        Object[] args = new Object[]{shouldInitConfigBeans};
        instance = (DubboBootstrapApplicationListenerInterface) DubboClassLoader.getInstance(DubboBootstrapApplicationListener.class.getName(), params, args);
    }
}
