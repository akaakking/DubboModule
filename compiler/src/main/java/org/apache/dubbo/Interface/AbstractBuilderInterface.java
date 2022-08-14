package org.apache.dubbo.Interface;

import java.lang;

public interface AbstractBuilderInterface<T>{
    BInterface id(String id);
    CInterface build();

}