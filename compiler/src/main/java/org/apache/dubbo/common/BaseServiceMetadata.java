package org.apache.dubbo.common;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class BaseServiceMetadata implements BaseServiceMetadataInterface {

    public StringInterface getDisplayServiceKey() {
        return instance.getDisplayServiceKey();
    }

    public StringInterface getServiceKey() {
        return instance.getServiceKey();
    }

    public void generateServiceKey() {
        instance.generateServiceKey();
    }

    public void setServiceKey(StringInterface serviceKey) {
        instance.setServiceKey(serviceKey);
    }

    public StringInterface getServiceInterfaceName() {
        return instance.getServiceInterfaceName();
    }

    public void setServiceInterfaceName(StringInterface serviceInterfaceName) {
        instance.setServiceInterfaceName(serviceInterfaceName);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public void setServiceModel(ServiceModelInterface serviceModel) {
        instance.setServiceModel(serviceModel);
    }

    protected BaseServiceMetadataInterface instance;

    public static StringInterface buildServiceKey(StringInterface path, StringInterface group, StringInterface version) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(buildServiceKey, String.class, String.class, String.class);
        return method.invoke(path, group, version);
    }

    public static StringInterface versionFromServiceKey(StringInterface serviceKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(versionFromServiceKey, String.class);
        return method.invoke(serviceKey);
    }

    public static StringInterface groupFromServiceKey(StringInterface serviceKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(groupFromServiceKey, String.class);
        return method.invoke(serviceKey);
    }

    public static StringInterface interfaceFromServiceKey(StringInterface serviceKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(interfaceFromServiceKey, String.class);
        return method.invoke(serviceKey);
    }

    public static BaseServiceMetadataInterface revertDisplayServiceKey(StringInterface displayKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(revertDisplayServiceKey, String.class);
        return method.invoke(displayKey);
    }

    public static StringInterface keyWithoutGroup(StringInterface interfaceName, StringInterface version) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(keyWithoutGroup, String.class, String.class);
        return method.invoke(interfaceName, version);
    }
}
