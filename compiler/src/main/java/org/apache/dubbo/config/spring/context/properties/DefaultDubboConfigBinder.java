package org.apache.dubbo.config.spring.context.properties;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.spring.context.properties.AbstractDubboConfigBinder;

public class DefaultDubboConfigBinder extends AbstractDubboConfigBinder implements DefaultDubboConfigBinderInterface {

    public <C extends AbstractConfigInterface> void bind(StringInterface prefix, C dubboConfig) {
        instance.bind(prefix, dubboConfig);
    }
}
