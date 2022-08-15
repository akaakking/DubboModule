package org.apache.dubbo.Interface;


public interface AbstractReferenceBuilderInterface<T><B> {
    B check(Boolean check);
    B init(Boolean init);
    B generic(String generic);
    B generic(Boolean generic);
    B injvm(Boolean injvm);
    B lazy(Boolean lazy);
    B reconnect(String reconnect);
    B sticky(Boolean sticky);
    B version(String version);
    B group(String group);
    void build(T instance);
}