package org.apache.dubbo.rpc.model;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.BaseServiceMetadata;

public class ServiceMetadata extends BaseServiceMetadata implements ServiceMetadataInterface {

    public StringInterface getServiceKey() {
        return instance.getServiceKey();
    }

    public Map<String, Object> getAttachments() {
        return instance.getAttachments();
    }

    public Map<String, Object> getAttributeMap() {
        return instance.getAttributeMap();
    }

    public ObjectInterface getAttribute(StringInterface key) {
        return instance.getAttribute(key);
    }

    public void addAttribute(StringInterface key, ObjectInterface value) {
        instance.addAttribute(key, value);
    }

    public void addAttachment(StringInterface key, ObjectInterface value) {
        instance.addAttachment(key, value);
    }

    public Class<?> getServiceType() {
        return instance.getServiceType();
    }

    public StringInterface getDefaultGroup() {
        return instance.getDefaultGroup();
    }

    public void setDefaultGroup(StringInterface defaultGroup) {
        instance.setDefaultGroup(defaultGroup);
    }

    public void setServiceType(Class<?> serviceType) {
        instance.setServiceType(serviceType);
    }

    public ObjectInterface getTarget() {
        return instance.getTarget();
    }

    public void setTarget(ObjectInterface target) {
        instance.setTarget(target);
    }

    public ServiceMetadata(String serviceInterfaceName, String group, String version, Class<?> serviceType) {
        Class[] params = new Class[]{String.class, String.class, String.class, ClassClass<?>.class};
        Object[] args = new Object[]{serviceInterfaceName, group, version, serviceType};
        instance = (ServiceMetadataInterface) DubboClassLoader.getInstance(ServiceMetadata.class.getName(), params, args);
    }

    public ServiceMetadata() {
        instance = (ServiceMetadataInterface) DubboClassLoader.getInstance(ServiceMetadata.class.getName());
    }
}
