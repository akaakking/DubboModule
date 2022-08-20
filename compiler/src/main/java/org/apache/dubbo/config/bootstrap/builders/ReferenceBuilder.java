package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractReferenceBuilder;

public class ReferenceBuilder<T> extends AbstractReferenceBuilder<ReferenceConfig<T>, ReferenceBuilder<T>> implements ReferenceBuilderInterface<T> {

    public ReferenceBuilderInterface<T> id(StringInterface id) {
        return instance.id(id);
    }

    public ReferenceBuilderInterface<T> interfaceName(StringInterface interfaceName) {
        return instance.interfaceName(interfaceName);
    }

    public ReferenceBuilderInterface<T> interfaceClass(Class<?> interfaceClass) {
        return instance.interfaceClass(interfaceClass);
    }

    public ReferenceBuilderInterface<T> client(StringInterface client) {
        return instance.client(client);
    }

    public ReferenceBuilderInterface<T> url(StringInterface url) {
        return instance.url(url);
    }

    public ReferenceBuilderInterface<T> addMethods(List<MethodConfigInterface> methods) {
        return instance.addMethods(methods);
    }

    public ReferenceBuilderInterface<T> addMethod(MethodConfigInterface method) {
        return instance.addMethod(method);
    }

    public ReferenceBuilderInterface<T> consumer(ConsumerConfigInterface consumer) {
        return instance.consumer(consumer);
    }

    public ReferenceBuilderInterface<T> protocol(StringInterface protocol) {
        return instance.protocol(protocol);
    }

    public ReferenceBuilderInterface<T> services(StringInterface service, StringInterface otherServices) {
        return instance.services(service, otherServices);
    }

    public ReferenceConfigInterface<T> build() {
        return instance.build();
    }

    public static <T> ReferenceBuilderInterface<T> newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }
}