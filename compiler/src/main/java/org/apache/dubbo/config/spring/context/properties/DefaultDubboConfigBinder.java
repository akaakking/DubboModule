package org.apache.dubbo.config.spring.context.properties;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DefaultDubboConfigBinder implements DefaultDubboConfigBinderInterface {

    public <C extends AbstractConfigInterface> void bind(String prefix, C dubboConfig) {
        instance.bind(prefix, dubboConfig);
    }

    protected DefaultDubboConfigBinderInterface instance;
}
