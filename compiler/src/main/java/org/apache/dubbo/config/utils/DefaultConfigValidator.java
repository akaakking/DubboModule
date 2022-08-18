package org.apache.dubbo.config.utils;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DefaultConfigValidator implements DefaultConfigValidatorInterface {

    public void validate(AbstractConfigInterface config) {
        instance.validate(config);
    }
}
