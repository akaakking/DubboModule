package org.apache.dubbo.config.spring.context.config;

import com.alibaba.spring.context.config.ConfigurationBeanCustomizer;
import org.springframework.core.Ordered;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigBeanCustomizer implements DubboConfigBeanCustomizerInterface {

    public void customize(String beanName, AbstractConfigInterface dubboConfigBean) {
        instance.customize(beanName, dubboConfigBean);
    }

    public void customize(String beanName, Object configurationBean) {
        instance.customize(beanName, configurationBean);
    }
}
