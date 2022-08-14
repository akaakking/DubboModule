package org.apache.dubbo.Interface;

import java.lang;

public interface DubboConfigBeanCustomizerInterface{
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    void customize(String beanName, Object configurationBean);

}