package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationContext;

public interface DubboBootstrapApplicationListenerInterface extends Object, org.springframework.context.ApplicationListener, org.springframework.context.ApplicationContextAware, org.springframework.core.Ordered{
    void onApplicationEvent(ApplicationEvent event);
    int getOrder();
    void setApplicationContext(ApplicationContext applicationContext);
    ApplicationContext getApplicationContext();
}