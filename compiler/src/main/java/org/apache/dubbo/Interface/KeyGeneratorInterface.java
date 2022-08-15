package org.apache.dubbo.Interface;


public interface KeyGeneratorInterface<T> {
    String generateKey(ReferenceConfigBaseInterface<T> referenceConfig);
}