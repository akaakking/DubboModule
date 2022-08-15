package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public interface DubboDeployApplicationListenerInterface extends Object, org.springframework.context.ApplicationListener, org.springframework.context.ApplicationContextAware, org.springframework.core.Ordered{
    void setApplicationContext(ApplicationContext applicationContext);
    void onApplicationEvent(ApplicationContextEvent event);
    int getOrder();
}