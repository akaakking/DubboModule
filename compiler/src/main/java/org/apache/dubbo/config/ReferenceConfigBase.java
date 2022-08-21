package org.apache.dubbo.config;

import java.util.List;
import java.util.Map;
import java.lang.Class;
import java.lang.String;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractReferenceConfig;
import java.lang.reflect.Method;
import java.lang.ClassLoader;

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

    public String getClient() {
        return instance.getClient();
    }

    public void setClient(String client) {
        instance.setClient(client);
    }

    public String getUrl() {
        return instance.getUrl();
    }

    public void setUrl(String url) {
        instance.setUrl(url);
    }

    public ConsumerConfigInterface getConsumer() {
        return instance.getConsumer();
    }

    public void setConsumer(ConsumerConfigInterface consumer) {
        instance.setConsumer(((ConsumerConfig) consumer).getInternalInstance());
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public ServiceMetadataInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public String getUniqueServiceName() {
        return instance.getUniqueServiceName();
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public Boolean shouldReferAsync() {
        return instance.shouldReferAsync();
    }

    public T get() {
        return instance.get();
    }

    public void destroy() {
        instance.destroy();
    }

    protected ReferenceConfigBaseInterface instance;

    public static Class<?> determineInterfaceClass(String generic, String interfaceName) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceConfigBase.class.getName());
        Method method = klass.getMethod("determineInterfaceClass", String.class, String.class);
        return (Class<?>)method.invoke(generic, interfaceName);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Class<?> determineInterfaceClass(String generic, String interfaceName, ClassLoader classLoader) {
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceConfigBase.class.getName());
        Method method = klass.getMethod("determineInterfaceClass", String.class, String.class, ClassLoader.class);
        return (Class<?>)method.invoke(generic, interfaceName, classLoader);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ReferenceConfigBaseInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceConfigBase() {
        instance = (ReferenceConfigBaseInterface) DubboClassLoader.getInstance(ReferenceConfigBase.class.getName());
        super.instance = this.instance;
    }
}
