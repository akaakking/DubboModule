package org.apache.dubbo.config.spring.context.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class NamePropertyDefaultValueDubboConfigBeanCustomizer implements NamePropertyDefaultValueDubboConfigBeanCustomizerInterface {

    public void customize(StringInterface beanName, AbstractConfigInterface dubboConfigBean) {
        instance.customize(beanName, dubboConfigBean);
    }

    public int getOrder() {
        return instance.getOrder();
    }

    protected NamePropertyDefaultValueDubboConfigBeanCustomizerInterface instance;
}
