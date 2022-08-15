package org.apache.dubbo.Interface;


public interface AbstractBuilderInterface<C><B> extends Object{
    B id(String id);
    C build();
}