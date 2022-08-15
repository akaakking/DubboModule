package org.apache.dubbo.Interface;


public interface DubboConfigBeanCustomizerInterface {
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    void customize(String beanName, Object configurationBean);
}