package org.apache.dubbo.config.spring.context.properties;

import org.springframework.context.EnvironmentAware;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboConfigBinder implements DubboConfigBinderInterface {

    public void setIgnoreUnknownFields(boolean ignoreUnknownFields) {
        instance.setIgnoreUnknownFields(ignoreUnknownFields);
    }

    public void setIgnoreInvalidFields(boolean ignoreInvalidFields) {
        instance.setIgnoreInvalidFields(ignoreInvalidFields);
    }

    public <C extends AbstractConfigInterface> void bind(String prefix, C dubboConfig) {
        instance.bind(prefix, dubboConfig);
    }
}
