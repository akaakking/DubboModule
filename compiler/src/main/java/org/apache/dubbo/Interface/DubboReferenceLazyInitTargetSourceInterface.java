package org.apache.dubbo.Interface;


public interface DubboReferenceLazyInitTargetSourceInterface<T> extends org.springframework.aop.target.AbstractLazyCreationTargetSource{
    Class getTargetClass();
}