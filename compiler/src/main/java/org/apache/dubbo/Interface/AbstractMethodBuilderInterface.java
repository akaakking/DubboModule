package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface AbstractMethodBuilderInterface<T>{
    BInterface timeout(Integer timeout);
    BInterface retries(Integer retries);
    BInterface actives(Integer actives);
    BInterface loadbalance(String loadbalance);
    BInterface async(Boolean async);
    BInterface sent(Boolean sent);
    BInterface mock(String mock);
    BInterface mock(Boolean mock);
    BInterface merger(String merger);
    BInterface cache(String cache);
    BInterface validation(String validation);
    BInterface appendParameters(Map appendParameters);
    BInterface appendParameter(String key, String value);
    BInterface forks(Integer forks);
    void build(TInterface instance);

}