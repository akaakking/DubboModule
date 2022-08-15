package org.apache.dubbo.Interface;

import java.util.Collection;

public interface AnnotatedInjectionMetadataInterface<T> {
    Collection getFieldElements();
    Collection getMethodElements();
}