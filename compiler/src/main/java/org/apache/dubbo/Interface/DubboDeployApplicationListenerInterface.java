package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public interface DubboDeployApplicationListenerInterface {
    void setApplicationContext(ApplicationContext applicationContext);
    void onApplicationEvent(ApplicationContextEvent event);
    int getOrder();
}