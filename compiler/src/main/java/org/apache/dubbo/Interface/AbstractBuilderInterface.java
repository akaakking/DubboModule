package org.apache.dubbo.Interface;


public interface AbstractBuilderInterface<C><B> {
    B id(String id);
    C build();
}