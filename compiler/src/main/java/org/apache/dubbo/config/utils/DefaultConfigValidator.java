package org.apache.dubbo.config.utils;

import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DefaultConfigValidator implements DefaultConfigValidatorInterface {

    public void validate(AbstractConfigInterface config) {
        instance.validate(((AbstractConfig) config).getInternalInstance());
    }

    protected DefaultConfigValidatorInterface instance;

    public DefaultConfigValidatorInterface getInternalInstance() {
        return instance;
    }

    protected DefaultConfigValidator() {
        instance = (DefaultConfigValidatorInterface) DubboClassLoader.getInstance(DefaultConfigValidator.class.getName());
    }
}
