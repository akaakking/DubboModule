package org.apache.dubbo.config.spring.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigurableSourceBeanMetadataElement implements ConfigurableSourceBeanMetadataElementInterface {

    public void setSource(BeanMetadataElement beanMetadataElement) {
        instance.setSource(beanMetadataElement);
    }
}
