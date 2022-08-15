package org.apache.dubbo.Interface;

import org.springframework.beans.factory.BeanFactory;

public interface DubboConfigBeanInitializerInterface extends Object, org.springframework.beans.factory.BeanFactoryAware, org.springframework.beans.factory.InitializingBean{
    void setBeanFactory(BeanFactory beanFactory);
    void afterPropertiesSet();
}