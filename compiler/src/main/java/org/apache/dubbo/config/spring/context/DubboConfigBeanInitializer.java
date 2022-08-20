package org.apache.dubbo.config.spring.context;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigBeanInitializer implements DubboConfigBeanInitializerInterface {

    public void setBeanFactory(BeanFactoryInterface beanFactory) {
        instance.setBeanFactory(beanFactory);
    }

    public void afterPropertiesSet() {
        instance.afterPropertiesSet();
    }

    protected DubboConfigBeanInitializerInterface instance;
}
