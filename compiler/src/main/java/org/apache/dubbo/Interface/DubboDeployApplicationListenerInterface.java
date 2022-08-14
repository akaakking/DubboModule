package org.apache.dubbo.Interface;

import ;

public interface DubboDeployApplicationListenerInterface{
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void onApplicationEvent(org.springframework.context.event.ApplicationContextEvent event);
    int getOrder();

}