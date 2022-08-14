package org.apache.dubbo.Interface;

import java.lang;

public interface NamePropertyDefaultValueDubboConfigBeanCustomizerInterface{
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    int getOrder();

}