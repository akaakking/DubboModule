package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.Invocation;
import java.io.Serializable;
import org.apache.dubbo.rpc.Invoker;
import java.lang.Object;
import java.util.Map;
import java.lang.String;
import java.lang.Class;
import java.util.function.Consumer;
import java.util.Map$Entry;
import java.lang.reflect.Type;
import org.apache.dubbo.rpc.InvokeMode;
import org.apache.dubbo.rpc.model.ServiceModel;
import org.apache.dubbo.Interface.ServiceModelInterface;

public interface RpcInvocationInterface extends Invocation, Serializable {

    Invoker<?> getInvoker();

    void setInvoker(Invoker<?> invoker);

    Object put(Object key, Object value);

    Object get(Object key);

    Map<Object, Object> getAttributes();

    String getTargetServiceUniqueName();

    void setTargetServiceUniqueName(String targetServiceUniqueName);

    String getProtocolServiceKey();

    String getMethodName();

    void setMethodName(String methodName);

    String getServiceName();

    void setServiceName(String interfaceName);

    Class<?>[] getParameterTypes();

    void setParameterTypes(Class<?>[] parameterTypes);

    String getParameterTypesDesc();

    void setParameterTypesDesc(String parameterTypesDesc);

    String[] getCompatibleParamSignatures();

    void setCompatibleParamSignatures(String[] compatibleParamSignatures);

    Object[] getArguments();

    void setArguments(Object[] arguments);

    Map<String, Object> getObjectAttachments();

    Map<String, Object> copyObjectAttachments();

    void foreachAttachment(Consumer<Map.Entry<String, Object>> consumer);

    void setObjectAttachments(Map<String, Object> attachments);

    void setAttachment(String key, String value);

    Map<String, String> getAttachments();

    void setAttachments(Map<String, String> attachments);

    void setAttachment(String key, Object value);

    void setObjectAttachment(String key, Object value);

    void setAttachmentIfAbsent(String key, String value);

    void setAttachmentIfAbsent(String key, Object value);

    void setObjectAttachmentIfAbsent(String key, Object value);

    void addAttachments(Map<String, String> attachments);

    void addObjectAttachments(Map<String, Object> attachments);

    void addAttachmentsIfAbsent(Map<String, String> attachments);

    void addObjectAttachmentsIfAbsent(Map<String, Object> attachments);

    String getAttachment(String key);

    Object getObjectAttachment(String key);

    String getAttachment(String key, String defaultValue);

    Object getObjectAttachment(String key, Object defaultValue);

    Object getObjectAttachmentWithoutConvert(String key);

    Class<?> getReturnType();

    void setReturnType(Class<?> returnType);

    Type[] getReturnTypes();

    void setReturnTypes(Type[] returnTypes);

    InvokeMode getInvokeMode();

    void setInvokeMode(InvokeMode invokeMode);

    void setServiceModel(ServiceModelInterface serviceModel);

    ServiceModelInterface getServiceModel();

    String toString();
}
