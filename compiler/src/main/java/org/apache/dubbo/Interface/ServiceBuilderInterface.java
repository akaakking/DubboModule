package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ServiceBuilderInterface<T>{
    ServiceBuilderInterface newBuilder();
    ServiceBuilderInterface id(String id);
    ServiceBuilderInterface interfaceName(String interfaceName);
    ServiceBuilderInterface interfaceClass(Class interfaceClass);
    ServiceBuilderInterface ref(UInterface ref);
    ServiceBuilderInterface path(String path);
    ServiceBuilderInterface addMethod(MethodConfigInterface method);
    ServiceBuilderInterface addMethods(List methods);
    ServiceBuilderInterface provider(ProviderConfigInterface provider);
    ServiceBuilderInterface providerIds(String providerIds);
    ServiceBuilderInterface generic(String generic);
    ServiceConfigInterface build();

}