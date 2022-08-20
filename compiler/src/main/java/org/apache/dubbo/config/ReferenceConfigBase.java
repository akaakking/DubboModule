package org.apache.dubbo.config;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractReferenceConfig;

public class ReferenceConfigBase<T> extends AbstractReferenceConfig implements ReferenceConfigBaseInterface<T> {

    public boolean shouldCheck() {
        return instance.shouldCheck();
    }

    public boolean shouldInit() {
        return instance.shouldInit();
    }

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public Map<String, String> getMetaData() {
        return instance.getMetaData();
    }

    public Class<?> getServiceInterfaceClass() {
        return instance.getServiceInterfaceClass();
    }

    public Class<?> getInterfaceClass() {
        return instance.getInterfaceClass();
    }

    public void setInterface(Class<?> interfaceClass) {
        instance.setInterface(interfaceClass);
    }

    public StringInterface getClient() {
        return instance.getClient();
    }

    public void setClient(StringInterface client) {
        instance.setClient(client);
    }

    public StringInterface getUrl() {
        return instance.getUrl();
    }

    public void setUrl(StringInterface url) {
        instance.setUrl(url);
    }

    public ConsumerConfigInterface getConsumer() {
        return instance.getConsumer();
    }

    public void setConsumer(ConsumerConfigInterface consumer) {
        instance.setConsumer(consumer);
    }

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
    }

    public ServiceMetadataInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public StringInterface getUniqueServiceName() {
        return instance.getUniqueServiceName();
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public BooleanInterface shouldReferAsync() {
        return instance.shouldReferAsync();
    }

    public T get() {
        return instance.get();
    }

    public void destroy() {
        instance.destroy();
    }

    public static Class<?> determineInterfaceClass(StringInterface generic, StringInterface interfaceName) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(determineInterfaceClass, String.class, String.class);
        return method.invoke(generic, interfaceName);
    }

    public static Class<?> determineInterfaceClass(StringInterface generic, StringInterface interfaceName, ClassLoaderInterface classLoader) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(determineInterfaceClass, String.class, String.class, ClassLoader.class);
        return method.invoke(generic, interfaceName, classLoader);
    }
}
