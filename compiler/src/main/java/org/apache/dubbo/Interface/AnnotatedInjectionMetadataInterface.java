package org.apache.dubbo.Interface;

import java.util;

public interface AnnotatedInjectionMetadataInterface<T>{
    Collection getFieldElements();
    Collection getMethodElements();

}