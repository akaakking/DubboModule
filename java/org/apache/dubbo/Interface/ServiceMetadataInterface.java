package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.BaseServiceMetadataInterface;
import java.util.Map;
import java.lang.String;
import java.lang.Object;
import java.lang.Class;

public interface ServiceMetadataInterface extends BaseServiceMetadataInterface {

    String getServiceKey();

    Map<String, Object> getAttachments();

    Map<String, Object> getAttributeMap();

    Object getAttribute(String key);

    void addAttribute(String key, Object value);

    void addAttachment(String key, Object value);

    Class<?> getServiceType();

    String getDefaultGroup();

    void setDefaultGroup(String defaultGroup);

    void setServiceType(Class<?> serviceType);

    Object getTarget();

    void setTarget(Object target);
}
