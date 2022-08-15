package org.apache.dubbo.Interface;

import java.util.Collection;

public interface AnnotatedInjectionMetadataInterface<T> extends org.springframework.beans.factory.annotation.InjectionMetadata{
    Collection getFieldElements();
    Collection getMethodElements();
}