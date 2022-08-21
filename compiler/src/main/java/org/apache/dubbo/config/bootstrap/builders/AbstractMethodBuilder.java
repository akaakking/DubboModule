package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class AbstractMethodBuilder<T extends AbstractMethodConfigInterface, B extends AbstractMethodBuilderInterface<T,B>> extends AbstractBuilder<T, B> implements AbstractMethodBuilderInterface<T, B> {

    public B timeout(Integer timeout) {
        return instance.timeout(timeout);
    }

    public B retries(Integer retries) {
        return instance.retries(retries);
    }

    public B actives(Integer actives) {
        return instance.actives(actives);
    }

    public B loadbalance(String loadbalance) {
        return instance.loadbalance(loadbalance);
    }

    public B async(Boolean async) {
        return instance.async(async);
    }

    public B sent(Boolean sent) {
        return instance.sent(sent);
    }

    public B mock(String mock) {
        return instance.mock(mock);
    }

    public B mock(Boolean mock) {
        return instance.mock(mock);
    }

    public B merger(String merger) {
        return instance.merger(merger);
    }

    public B cache(String cache) {
        return instance.cache(cache);
    }

    public B validation(String validation) {
        return instance.validation(validation);
    }

    public B appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public B appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public B forks(Integer forks) {
        return instance.forks(forks);
    }

    public void build(T instance) {
        instance.build(instance);
    }

    public AbstractMethodBuilderInterface getInternalInstance() {
        return instance;
    }

    protected AbstractMethodBuilder() {
    }
}
