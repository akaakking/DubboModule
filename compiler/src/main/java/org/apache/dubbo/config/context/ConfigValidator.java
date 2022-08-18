package org.apache.dubbo.config.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigValidator implements ConfigValidatorInterface {

    public void validate(AbstractConfigInterface config) {
        instance.validate(config);
    }
}
