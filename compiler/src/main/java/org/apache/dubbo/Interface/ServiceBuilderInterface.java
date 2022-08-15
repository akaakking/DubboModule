package org.apache.dubbo.Interface;

import java.util.List;

public interface ServiceBuilderInterface<U> {
    ServiceBuilderInterface<U> newBuilder();
    ServiceBuilderInterface<U> id(String id);
    ServiceBuilderInterface<U> interfaceName(String interfaceName);
    ServiceBuilderInterface<U> interfaceClass(Class interfaceClass);
    ServiceBuilderInterface<U> ref(U ref);
    ServiceBuilderInterface<U> path(String path);
    ServiceBuilderInterface<U> addMethod(MethodConfigInterface method);
    ServiceBuilderInterface<U> addMethods(List methods);
    ServiceBuilderInterface<U> provider(ProviderConfigInterface provider);
    ServiceBuilderInterface<U> providerIds(String providerIds);
    ServiceBuilderInterface<U> generic(String generic);
    ServiceConfigInterface<T> build();
}