package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class AbstractMethodBuilder<T extends AbstractMethodConfigInterface, B extends AbstractMethodBuilderInterface<T,B>> extends AbstractBuilder<T, B> implements AbstractMethodBuilderInterface<T, B> {

    public B timeout(IntegerInterface timeout) {
        return instance.timeout(timeout);
    }

    public B retries(IntegerInterface retries) {
        return instance.retries(retries);
    }

    public B actives(IntegerInterface actives) {
        return instance.actives(actives);
    }

    public B loadbalance(StringInterface loadbalance) {
        return instance.loadbalance(loadbalance);
    }

    public B async(BooleanInterface async) {
        return instance.async(async);
    }

    public B sent(BooleanInterface sent) {
        return instance.sent(sent);
    }

    public B mock(StringInterface mock) {
        return instance.mock(mock);
    }

    public B mock(BooleanInterface mock) {
        return instance.mock(mock);
    }

    public B merger(StringInterface merger) {
        return instance.merger(merger);
    }

    public B cache(StringInterface cache) {
        return instance.cache(cache);
    }

    public B validation(StringInterface validation) {
        return instance.validation(validation);
    }

    public B appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public B appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public B forks(IntegerInterface forks) {
        return instance.forks(forks);
    }

    public void build(T instance) {
        instance.build(instance);
    }
}
