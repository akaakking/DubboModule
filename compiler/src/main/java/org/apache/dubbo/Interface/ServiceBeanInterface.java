package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface ServiceBeanInterface<T>{
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void setBeanName(String name);
    ServiceInterface getService();
    void afterPropertiesSet();
    String getBeanName();
    void destroy();
    void setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher applicationEventPublisher);

}