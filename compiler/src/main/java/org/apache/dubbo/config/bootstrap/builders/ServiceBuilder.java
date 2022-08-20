package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractServiceBuilder;

public class ServiceBuilder<U> extends AbstractServiceBuilder<ServiceConfig<U>, ServiceBuilder<U>> implements ServiceBuilderInterface<U> {

    public ServiceBuilderInterface<U> id(String id) {
        return instance.id(id);
    }

    public ServiceBuilderInterface<U> interfaceName(String interfaceName) {
        return instance.interfaceName(interfaceName);
    }

    public ServiceBuilderInterface<U> interfaceClass(Class<?> interfaceClass) {
        return instance.interfaceClass(interfaceClass);
    }

    public ServiceBuilderInterface<U> ref(U ref) {
        return instance.ref(ref);
    }

    public ServiceBuilderInterface<U> path(String path) {
        return instance.path(path);
    }

    public ServiceBuilderInterface<U> addMethod(MethodConfigInterface method) {
        return instance.addMethod(method.getInternalInstance(), method);
    }

    public ServiceBuilderInterface<U> addMethods(List<? extends MethodConfigInterface> methods) {
        return instance.addMethods(methods);
    }

    public ServiceBuilderInterface<U> provider(ProviderConfigInterface provider) {
        return instance.provider(provider.getInternalInstance(), provider);
    }

    public ServiceBuilderInterface<U> providerIds(String providerIds) {
        return instance.providerIds(providerIds);
    }

    public ServiceBuilderInterface<U> generic(String generic) {
        return instance.generic(generic);
    }

    public ServiceConfigInterface<U> build() {
        return instance.build();
    }

    public static <T> ServiceBuilderInterface<T> newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }

    public ServiceBuilderInterface getInternalInstance() {
        return instance;
    }

    public ServiceBuilderInterface getInternalInstance() {
        return instance;
    }
}
