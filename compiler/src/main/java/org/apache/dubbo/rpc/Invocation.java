package org.apache.dubbo.rpc;

import java.util.Map;
import java.util.function.Consumer;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Invocation implements InvocationInterface {

    public String getTargetServiceUniqueName() {
        return instance.getTargetServiceUniqueName();
    }

    public String getProtocolServiceKey() {
        return instance.getProtocolServiceKey();
    }

    public String getMethodName() {
        return instance.getMethodName();
    }

    public String getServiceName() {
        return instance.getServiceName();
    }

    public Class<?>[] getParameterTypes() {
        return instance.getParameterTypes();
    }

    public String[] getCompatibleParamSignatures() {
        return instance.getCompatibleParamSignatures();
    }

    public Object[] getArguments() {
        return instance.getArguments();
    }

    public Map<String, String> getAttachments() {
        return instance.getAttachments();
    }

    public Map<String, Object> getObjectAttachments() {
        return instance.getObjectAttachments();
    }

    public Map<String, Object> copyObjectAttachments() {
        return instance.copyObjectAttachments();
    }

    public void foreachAttachment(Consumer<Map.Entry<String, Object>> consumer) {
        instance.foreachAttachment(consumer);
    }

    public void setAttachment(String key, String value) {
        instance.setAttachment(key, value);
    }

    public void setAttachment(String key, Object value) {
        instance.setAttachment(key, value);
    }

    public void setObjectAttachment(String key, Object value) {
        instance.setObjectAttachment(key, value);
    }

    public void setAttachmentIfAbsent(String key, String value) {
        instance.setAttachmentIfAbsent(key, value);
    }

    public void setAttachmentIfAbsent(String key, Object value) {
        instance.setAttachmentIfAbsent(key, value);
    }

    public void setObjectAttachmentIfAbsent(String key, Object value) {
        instance.setObjectAttachmentIfAbsent(key, value);
    }

    public String getAttachment(String key) {
        return instance.getAttachment(key);
    }

    public Object getObjectAttachment(String key) {
        return instance.getObjectAttachment(key);
    }

    public Object getObjectAttachmentWithoutConvert(String key) {
        return instance.getObjectAttachmentWithoutConvert(key);
    }

    public String getAttachment(String key, String defaultValue) {
        return instance.getAttachment(key, defaultValue);
    }

    public Object getObjectAttachment(String key, Object defaultValue) {
        return instance.getObjectAttachment(key, defaultValue);
    }

    public InvokerInterface<?> getInvoker() {
        return instance.getInvoker();
    }

    public void setServiceModel(ServiceModelInterface serviceModel) {
        instance.setServiceModel(serviceModel);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public ModuleModelInterface getModuleModel() {
        return instance.getModuleModel();
    }

    public Object put(Object key, Object value) {
        return instance.put(key, value);
    }

    public Object get(Object key) {
        return instance.get(key);
    }

    public Map<Object, Object> getAttributes() {
        return instance.getAttributes();
    }
}
