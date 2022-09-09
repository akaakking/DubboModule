package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.registry.client.ServiceInstance;
import org.apache.dubbo.Interface.MetadataInfoInterface;
import java.lang.String;
import java.util.Map;
import org.apache.dubbo.Interface.URLParamInterface;
import org.apache.dubbo.Interface.URLAddressInterface;
import org.apache.dubbo.Interface.FrameworkModelInterface;
import org.apache.dubbo.Interface.ApplicationModelInterface;
import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.Interface.ServiceModelInterface;
import java.util.Set;
import java.lang.Object;

public interface InstanceAddressURLInterface extends URLInterface {

    ServiceInstance getInstance();

    MetadataInfoInterface getMetadataInfo();

    String getServiceInterface();

    String getGroup();

    String getVersion();

    String getProtocol();

    String getProtocolServiceKey();

    String getServiceKey();

    URLInterface setProtocol(String protocol);

    URLInterface setHost(String host);

    URLInterface setPort(int port);

    URLInterface setPath(String path);

    String getAddress();

    String getHost();

    int getPort();

    String getIp();

    String getRemoteApplication();

    String getSide();

    String getPath();

    String getParameter(String key);

    String getServiceParameter(String service, String key);

    String getServiceMethodParameter(String protocolServiceKey, String method, String key);

    String getMethodParameter(String method, String key);

    boolean hasServiceMethodParameter(String protocolServiceKey, String method, String key);

    boolean hasMethodParameter(String method, String key);

    boolean hasServiceMethodParameter(String protocolServiceKey, String method);

    boolean hasMethodParameter(String method);

    Map<String, String> getServiceParameters(String protocolServiceKey);

    Map<String, String> getParameters();

    URLInterface addParameter(String key, String value);

    URLInterface addParameterIfAbsent(String key, String value);

    URLInterface addServiceParameter(String protocolServiceKey, String key, String value);

    URLInterface addServiceParameterIfAbsent(String protocolServiceKey, String key, String value);

    URLInterface addConsumerParams(String protocolServiceKey, Map<String, String> params);

    String getAnyMethodParameter(String key);

    URLParamInterface getUrlParam();

    URLAddressInterface getUrlAddress();

    FrameworkModelInterface getOrDefaultFrameworkModel();

    ApplicationModelInterface getOrDefaultApplicationModel();

    ApplicationModelInterface getApplicationModel();

    ScopeModelInterface getScopeModel();

    ServiceModelInterface getServiceModel();

    Set<String> getProviderFirstParams();

    void setProviderFirstParams(Set<String> providerFirstParams);

    boolean equals(Object obj);

    int hashCode();

    String toString();
}
