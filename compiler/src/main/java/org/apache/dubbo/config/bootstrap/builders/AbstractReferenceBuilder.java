package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractInterfaceBuilder;

public class AbstractReferenceBuilder<T extends AbstractReferenceConfigInterface, B extends AbstractReferenceBuilderInterface<T,B>> extends AbstractInterfaceBuilder<T, B> implements AbstractReferenceBuilderInterface<T, B> {

    public B check(BooleanInterface check) {
        return instance.check(check);
    }

    public B init(BooleanInterface init) {
        return instance.init(init);
    }

    public B generic(StringInterface generic) {
        return instance.generic(generic);
    }

    public B generic(BooleanInterface generic) {
        return instance.generic(generic);
    }

    public B injvm(BooleanInterface injvm) {
        return instance.injvm(injvm);
    }

    public B lazy(BooleanInterface lazy) {
        return instance.lazy(lazy);
    }

    public B reconnect(StringInterface reconnect) {
        return instance.reconnect(reconnect);
    }

    public B sticky(BooleanInterface sticky) {
        return instance.sticky(sticky);
    }

    public B version(StringInterface version) {
        return instance.version(version);
    }

    public B group(StringInterface group) {
        return instance.group(group);
    }

    public void build(T instance) {
        instance.build(instance);
    }
}
