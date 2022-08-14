package org.apache.dubbo.Interface;

import ;

public interface DubboConfigApplicationListenerInterface{
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void onApplicationEvent(DubboConfigInitEventInterface event);

}