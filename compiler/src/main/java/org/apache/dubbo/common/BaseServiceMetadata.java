package org.apache.dubbo.common;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class BaseServiceMetadata implements BaseServiceMetadataInterface {

    public String getDisplayServiceKey() {
        return instance.getDisplayServiceKey();
    }

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public void generateServiceKey() {
        instance.generateServiceKey();
    }

    public void setServiceKey(String serviceKey) {
        instance.setServiceKey(serviceKey);
    }

    public String getServiceInterfaceName() {
        return instance.getServiceInterfaceName();
    }

    public void setServiceInterfaceName(String serviceInterfaceName) {
        instance.setServiceInterfaceName(serviceInterfaceName);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public void setServiceModel(ServiceModelInterface serviceModel) {
        instance.setServiceModel(serviceModel);
    }

    public static String buildServiceKey(String path, String group, String version) {
        Method method = instance.getClass().getMethod(String.class, String.class, String.class);
        return method.invoke(path, group, version);
    }

    public static String versionFromServiceKey(String serviceKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(serviceKey);
    }

    public static String groupFromServiceKey(String serviceKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(serviceKey);
    }

    public static String interfaceFromServiceKey(String serviceKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(serviceKey);
    }

    public static BaseServiceMetadataInterface revertDisplayServiceKey(String displayKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(displayKey);
    }

    public static String keyWithoutGroup(String interfaceName, String version) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        return method.invoke(interfaceName, version);
    }
}
