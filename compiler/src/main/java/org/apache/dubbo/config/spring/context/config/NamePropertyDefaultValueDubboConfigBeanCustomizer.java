package org.apache.dubbo.config.spring.context.config;

import java.lang.String;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class NamePropertyDefaultValueDubboConfigBeanCustomizer implements NamePropertyDefaultValueDubboConfigBeanCustomizerInterface {

    public void customize(String beanName, AbstractConfigInterface dubboConfigBean) {
        instance.customize(beanName, ((AbstractConfig) dubboConfigBean).getInternalInstance());
    }

    public int getOrder() {
        return instance.getOrder();
    }

    protected NamePropertyDefaultValueDubboConfigBeanCustomizerInterface instance;

    public NamePropertyDefaultValueDubboConfigBeanCustomizerInterface getInternalInstance() {
        return instance;
    }

    protected NamePropertyDefaultValueDubboConfigBeanCustomizer() {
        instance = (NamePropertyDefaultValueDubboConfigBeanCustomizerInterface) DubboClassLoader.getInstance(NamePropertyDefaultValueDubboConfigBeanCustomizer.class.getName());
    }
}
