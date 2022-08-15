package org.apache.dubbo.Interface;

import org.springframework.beans.factory.BeanFactory;

public interface DubboConfigBeanInitializerInterface {
    void setBeanFactory(BeanFactory beanFactory);
    void afterPropertiesSet();
}