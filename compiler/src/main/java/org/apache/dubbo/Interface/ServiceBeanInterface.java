package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationContext;

public interface ServiceBeanInterface<T> extends ServiceConfig, org.springframework.beans.factory.InitializingBean, org.springframework.beans.factory.DisposableBean, org.springframework.context.ApplicationContextAware, org.springframework.beans.factory.BeanNameAware, org.springframework.context.ApplicationEventPublisherAware{
    void setApplicationContext(ApplicationContext applicationContext);
    void setBeanName(String name);
    ServiceInterface getService();
    void afterPropertiesSet();
    String getBeanName();
    void destroy();
    void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher);
}