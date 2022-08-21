package org.apache.dubbo.config.bootstrap.builders;

import java.lang.String;
import java.lang.Class;
import U;
import org.apache.dubbo.config.MethodConfig;
import java.util.List;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractServiceBuilder;
import java.lang.reflect.Method;

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
        return instance.addMethod(((MethodConfig) method).getInternalInstance());
    }

    public ServiceBuilderInterface<U> addMethods(List<? extends MethodConfigInterface> methods) {
        return instance.addMethods(methods);
    }

    public ServiceBuilderInterface<U> provider(ProviderConfigInterface provider) {
        return instance.provider(((ProviderConfig) provider).getInternalInstance());
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

    protected ServiceBuilderInterface instance;

    public static <T> ServiceBuilderInterface<T> newBuilder() {
        try { 
          Class klass = DubboClassLoader.getKlass(ServiceBuilder.class.getName());
        Method method = klass.getMethod("newBuilder");
        return (ServiceBuilderInterface<T>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ServiceBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ServiceBuilder() {
        instance = (ServiceBuilderInterface) DubboClassLoader.getInstance(ServiceBuilder.class.getName());
        super.instance = this.instance;
    }
}
