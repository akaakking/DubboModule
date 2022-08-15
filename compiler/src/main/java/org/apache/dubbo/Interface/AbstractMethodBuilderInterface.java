package org.apache.dubbo.Interface;

import java.util.Map;

public interface AbstractMethodBuilderInterface<T><B> extends AbstractBuilder{
    B timeout(Integer timeout);
    B retries(Integer retries);
    B actives(Integer actives);
    B loadbalance(String loadbalance);
    B async(Boolean async);
    B sent(Boolean sent);
    B mock(String mock);
    B mock(Boolean mock);
    B merger(String merger);
    B cache(String cache);
    B validation(String validation);
    B appendParameters(Map appendParameters);
    B appendParameter(String key, String value);
    B forks(Integer forks);
    void build(T instance);
}