package org.apache.dubbo.rpc.model;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.BaseServiceMetadata;

public class ServiceMetadata extends BaseServiceMetadata implements ServiceMetadataInterface {

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public Map<String, Object> getAttachments() {
        return instance.getAttachments();
    }

    public Map<String, Object> getAttributeMap() {
        return instance.getAttributeMap();
    }

    public Object getAttribute(String key) {
        return instance.getAttribute(key);
    }

    public void addAttribute(String key, Object value) {
        instance.addAttribute(key, value);
    }

    public void addAttachment(String key, Object value) {
        instance.addAttachment(key, value);
    }

    public Class<?> getServiceType() {
        return instance.getServiceType();
    }

    public String getDefaultGroup() {
        return instance.getDefaultGroup();
    }

    public void setDefaultGroup(String defaultGroup) {
        instance.setDefaultGroup(defaultGroup);
    }

    public void setServiceType(Class<?> serviceType) {
        instance.setServiceType(serviceType);
    }

    public Object getTarget() {
        return instance.getTarget();
    }

    public void setTarget(Object target) {
        instance.setTarget(target);
    }

    public ServiceMetadataInterface getInternalInstance() {
        return instance;
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
