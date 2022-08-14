package org.apache.dubbo.Interface;

import java.lang;

public interface KeyGeneratorInterface<T>{
    String generateKey(ReferenceConfigBaseInterface referenceConfig);

}