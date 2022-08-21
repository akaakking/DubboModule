package org.apache.dubbo.config.bootstrap.builders;

import java.lang.String;
import java.lang.Class;
import java.util.List;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractReferenceBuilder;
import java.lang.reflect.Method;

public class ReferenceBuilder<T> extends AbstractReferenceBuilder<ReferenceConfig<T>, ReferenceBuilder<T>> implements ReferenceBuilderInterface<T> {

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

    public ReferenceBuilderInterface<T> addMethods(List<MethodConfigInterface> methods) {
        return instance.addMethods(methods);
    }

    public ReferenceBuilderInterface<T> addMethod(MethodConfigInterface method) {
        return instance.addMethod(((MethodConfig) method).getInternalInstance());
    }

    public ReferenceBuilderInterface<T> consumer(ConsumerConfigInterface consumer) {
        return instance.consumer(((ConsumerConfig) consumer).getInternalInstance());
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
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceBuilder.class.getName());
        Method method = klass.getMethod("newBuilder");
        return (ReferenceBuilderInterface<T>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ReferenceBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceBuilder() {
        instance = (ReferenceBuilderInterface) DubboClassLoader.getInstance(ReferenceBuilder.class.getName());
        super.instance = this.instance;
    }
}
