package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationContext;

public interface DubboConfigApplicationListenerInterface {
    void setApplicationContext(ApplicationContext applicationContext);
    void onApplicationEvent(DubboConfigInitEventInterface event);
}