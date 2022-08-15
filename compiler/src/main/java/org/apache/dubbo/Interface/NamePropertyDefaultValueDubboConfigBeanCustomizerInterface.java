package org.apache.dubbo.Interface;


public interface NamePropertyDefaultValueDubboConfigBeanCustomizerInterface extends Object, DubboConfigBeanCustomizer{
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    int getOrder();
}