package org.apache.dubbo.Interface;


public interface NamePropertyDefaultValueDubboConfigBeanCustomizerInterface {
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    int getOrder();
}