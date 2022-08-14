package org.apache.dubbo.Interface;

import java.lang;

public interface AbstractReferenceBuilderInterface<T>{
    BInterface check(Boolean check);
    BInterface init(Boolean init);
    BInterface generic(String generic);
    BInterface generic(Boolean generic);
    BInterface injvm(Boolean injvm);
    BInterface lazy(Boolean lazy);
    BInterface reconnect(String reconnect);
    BInterface sticky(Boolean sticky);
    BInterface version(String version);
    BInterface group(String group);
    void build(TInterface instance);

}