package org.apache.dubbo.Interface;


public interface AnnotatedInjectElementInterface<T> extends InjectedElement{
    Class getInjectedType();
    String getPropertyName();
}