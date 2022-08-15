package org.apache.dubbo.Interface;


public interface DubboConfigBeanCustomizerInterface extends com.alibaba.spring.context.config.ConfigurationBeanCustomizer, org.springframework.core.Ordered{
    void customize(String beanName, AbstractConfigInterface dubboConfigBean);
    void customize(String beanName, Object configurationBean);
}