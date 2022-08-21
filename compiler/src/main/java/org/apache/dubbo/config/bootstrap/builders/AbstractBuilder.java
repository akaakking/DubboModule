package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractBuilder<C extends AbstractConfigInterface, B extends AbstractBuilderInterface> implements AbstractBuilderInterface<C, B> {

    public B id(String id) {
        return instance.id(id);
    }

    public C build() {
        return instance.build();
    }

    protected AbstractBuilderInterface instance;

    public AbstractBuilderInterface getInternalInstance() {
        return instance;
    }

    protected AbstractBuilder() {
    }
}
