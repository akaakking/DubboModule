package org.apache.dubbo.config.spring.context.annotation;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigConfiguration implements DubboConfigConfigurationInterface {

    protected DubboConfigConfigurationInterface instance;

    public DubboConfigConfigurationInterface getInternalInstance() {
        return instance;
    }

    protected DubboConfigConfiguration() {
        instance = (DubboConfigConfigurationInterface) DubboClassLoader.getInstance(DubboConfigConfiguration.class.getName());
    }
}
