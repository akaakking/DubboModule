package org.apache.dubbo.Interface;

import java.lang;

public interface AnnotatedInjectElementInterface<T>{
    Class getInjectedType();
    String getPropertyName();

}