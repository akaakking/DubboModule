package org.apache.dubbo.Interface;

import ;

public interface DubboBootstrapApplicationListenerInterface{
    void onApplicationEvent(org.springframework.context.ApplicationEvent event);
    int getOrder();
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    org.springframework.context.ApplicationContext getApplicationContext();

}