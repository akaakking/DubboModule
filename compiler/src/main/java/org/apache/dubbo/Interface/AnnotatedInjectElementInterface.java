package org.apache.dubbo.Interface;


public interface AnnotatedInjectElementInterface<T> {
    Class getInjectedType();
    String getPropertyName();
}