package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ReferenceBuilderInterface<T>{
    ReferenceBuilderInterface newBuilder();
    ReferenceBuilderInterface id(String id);
    ReferenceBuilderInterface interfaceName(String interfaceName);
    ReferenceBuilderInterface interfaceClass(Class interfaceClass);
    ReferenceBuilderInterface client(String client);
    ReferenceBuilderInterface url(String url);
    ReferenceBuilderInterface addMethods(List methods);
    ReferenceBuilderInterface addMethod(MethodConfigInterface method);
    ReferenceBuilderInterface consumer(ConsumerConfigInterface consumer);
    ReferenceBuilderInterface protocol(String protocol);
    ReferenceBuilderInterface services(String service, String otherServices);
    ReferenceConfigInterface build();

}