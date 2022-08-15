package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationContext;

public interface DubboConfigApplicationListenerInterface extends Object, org.springframework.context.ApplicationListener, org.springframework.context.ApplicationContextAware{
    void setApplicationContext(ApplicationContext applicationContext);
    void onApplicationEvent(DubboConfigInitEventInterface event);
}