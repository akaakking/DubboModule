package org.apache.dubbo.Interface;

import ;

public interface DubboConfigBeanInitializerInterface{
    void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory);
    void afterPropertiesSet();

}