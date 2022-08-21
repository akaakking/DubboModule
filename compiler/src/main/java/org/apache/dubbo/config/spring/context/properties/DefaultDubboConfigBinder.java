package org.apache.dubbo.config.spring.context.properties;

import java.lang.String;
import C;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.spring.context.properties.AbstractDubboConfigBinder;

public class DefaultDubboConfigBinder extends AbstractDubboConfigBinder implements DefaultDubboConfigBinderInterface {

    public <C extends AbstractConfigInterface> void bind(String prefix, C dubboConfig) {
        instance.bind(prefix, dubboConfig);
    }

    protected DefaultDubboConfigBinderInterface instance;

    public DefaultDubboConfigBinderInterface getInternalInstance() {
        return instance;
    }

    protected DefaultDubboConfigBinder() {
        instance = (DefaultDubboConfigBinderInterface) DubboClassLoader.getInstance(DefaultDubboConfigBinder.class.getName());
        super.instance = this.instance;
    }
}
