package org.apache.dubbo.Interface;

import java.util.Map;
import java.util.function.Consumer;
import java.util.Map$Entry;
import java.lang.String;
import java.lang.Object;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.model.ServiceModel;

public interface InvocationInterface {

    String getTargetServiceUniqueName();

    String getProtocolServiceKey();

    String getMethodName();

    String getServiceName();

    Class<?>[] getParameterTypes();

    String[] getCompatibleParamSignatures();

    Object[] getArguments();

    Map<String, String> getAttachments();

    Map<String, Object> getObjectAttachments();

    Map<String, Object> copyObjectAttachments();

    void foreachAttachment(Consumer<Map.Entry<String, Object>> consumer);

    void setAttachment(String key, String value);

    void setAttachment(String key, Object value);

    void setObjectAttachment(String key, Object value);

    void setAttachmentIfAbsent(String key, String value);

    void setAttachmentIfAbsent(String key, Object value);

    void setObjectAttachmentIfAbsent(String key, Object value);

    String getAttachment(String key);

    Object getObjectAttachment(String key);

    Object getObjectAttachmentWithoutConvert(String key);

    String getAttachment(String key, String defaultValue);

    Object getObjectAttachment(String key, Object defaultValue);

    Invoker<?> getInvoker();

    void setServiceModel(ServiceModelInterface serviceModel);

    ServiceModelInterface getServiceModel();

    ModuleModelInterface getModuleModel();

    Object put(Object key, Object value);

    Object get(Object key);

    Map<Object, Object> getAttributes();
}
