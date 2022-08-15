package org.apache.dubbo.Interface;

import java.util.List;

public interface ReferenceBuilderInterface<T> extends AbstractReferenceBuilder{
    ReferenceBuilderInterface<T> newBuilder();
    ReferenceBuilderInterface<T> id(String id);
    ReferenceBuilderInterface<T> interfaceName(String interfaceName);
    ReferenceBuilderInterface<T> interfaceClass(Class interfaceClass);
    ReferenceBuilderInterface<T> client(String client);
    ReferenceBuilderInterface<T> url(String url);
    ReferenceBuilderInterface<T> addMethods(List methods);
    ReferenceBuilderInterface<T> addMethod(MethodConfigInterface method);
    ReferenceBuilderInterface<T> consumer(ConsumerConfigInterface consumer);
    ReferenceBuilderInterface<T> protocol(String protocol);
    ReferenceBuilderInterface<T> services(String service, String otherServices);
    ReferenceConfigInterface<T> build();
}