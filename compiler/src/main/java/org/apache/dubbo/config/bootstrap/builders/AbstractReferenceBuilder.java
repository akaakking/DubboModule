package org.apache.dubbo.config.bootstrap.builders;

import java.lang.Boolean;
import java.lang.String;
import T;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractInterfaceBuilder;

public class AbstractReferenceBuilder<T extends AbstractReferenceConfigInterface, B extends AbstractReferenceBuilderInterface<T,B>> extends AbstractInterfaceBuilder<T, B> implements AbstractReferenceBuilderInterface<T, B> {

    public B check(Boolean check) {
        return instance.check(check);
    }

    public B init(Boolean init) {
        return instance.init(init);
    }

    public B generic(String generic) {
        return instance.generic(generic);
    }

    public B generic(Boolean generic) {
        return instance.generic(generic);
    }

    public B injvm(Boolean injvm) {
        return instance.injvm(injvm);
    }

    public B lazy(Boolean lazy) {
        return instance.lazy(lazy);
    }

    public B reconnect(String reconnect) {
        return instance.reconnect(reconnect);
    }

    public B sticky(Boolean sticky) {
        return instance.sticky(sticky);
    }

    public B version(String version) {
        return instance.version(version);
    }

    public B group(String group) {
        return instance.group(group);
    }

    public void build(T instance) {
        instance.build(instance);
    }

    protected AbstractReferenceBuilderInterface instance;

    public AbstractReferenceBuilderInterface getInternalInstance() {
        return instance;
    }

    protected AbstractReferenceBuilder() {
        instance = (AbstractReferenceBuilderInterface) DubboClassLoader.getInstance(AbstractReferenceBuilder.class.getName());
        super.instance = this.instance;
    }
}
