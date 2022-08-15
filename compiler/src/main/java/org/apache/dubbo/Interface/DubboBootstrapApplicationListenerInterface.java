package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationContext;

public interface DubboBootstrapApplicationListenerInterface {
    void onApplicationEvent(ApplicationEvent event);
    int getOrder();
    void setApplicationContext(ApplicationContext applicationContext);
    ApplicationContext getApplicationContext();
}