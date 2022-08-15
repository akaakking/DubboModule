package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationContext;

public interface ServiceBeanInterface<T> {
    void setApplicationContext(ApplicationContext applicationContext);
    void setBeanName(String name);
    ServiceInterface getService();
    void afterPropertiesSet();
    String getBeanName();
    void destroy();
    void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher);
}