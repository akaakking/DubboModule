package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBuilder<T> implements ReferenceBuilderInterface<T> {

    public ReferenceBuilderInterface<T> id(String id) {
        return instance.id(id);
    }

    public ReferenceBuilderInterface<T> interfaceName(String interfaceName) {
        return instance.interfaceName(interfaceName);
    }

    public ReferenceBuilderInterface<T> interfaceClass(Class<?> interfaceClass) {
        return instance.interfaceClass(interfaceClass);
    }

    public ReferenceBuilderInterface<T> client(String client) {
        return instance.client(client);
    }

    public ReferenceBuilderInterface<T> url(String url) {
        return instance.url(url);
    }

    public ReferenceBuilderInterface<T> addMethods(List<MethodConfig> methods) {
        return instance.addMethods(methods);
    }

    public ReferenceBuilderInterface<T> addMethod(MethodConfigInterface method) {
        return instance.addMethod(method);
    }

    public ReferenceBuilderInterface<T> consumer(ConsumerConfigInterface consumer) {
        return instance.consumer(consumer);
    }

    public ReferenceBuilderInterface<T> protocol(String protocol) {
        return instance.protocol(protocol);
    }

    public ReferenceBuilderInterface<T> services(String service, String otherServices) {
        return instance.services(service, otherServices);
    }

    public ReferenceConfigInterface<T> build() {
        return instance.build();
    }

    protected ReferenceBuilderInterface instance;

    public static <T> ReferenceBuilderInterface<T> newBuilder() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }
}
