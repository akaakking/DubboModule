package org.apache.dubbo.Interface;

import java.io.Serializable;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.String;
import java.util.Map;
import org.apache.dubbo.Interface.MetadataInfo$ServiceInfoInterface;
import java.util.List;
import org.apache.dubbo.common.ProtocolServiceKey;
import org.apache.dubbo.Interface.ProtocolServiceKeyInterface;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.SortedSet;
import java.lang.Object;
import org.apache.dubbo.Interface.MetadataInfoInterface;

public interface MetadataInfoInterface extends Serializable {

    void init();

    void addService(URLInterface url);

    void removeService(URLInterface url);

    String getRevision();

    String calAndGetRevision();

    void setRevision(String revision);

    String getContent();

    String getApp();

    void setApp(String app);

    Map<String, ServiceInfoInterface> getServices();

    ServiceInfoInterface getServiceInfo(String protocolServiceKey);

    ServiceInfoInterface getNoProtocolServiceInfo(String serviceKeyWithoutProtocol);

    ServiceInfoInterface getValidServiceInfo(String serviceKey);

    List<ServiceInfoInterface> getMatchedServiceInfos(ProtocolServiceKeyInterface consumerProtocolServiceKey);

    Map<String, String> getExtendParams();

    Map<String, String> getInstanceParams();

    String getParameter(String key, String serviceKey);

    Map<String, String> getParameters(String serviceKey);

    String getServiceString(String protocolServiceKey);

    void addSubscribedURL(URLInterface url);

    boolean removeSubscribedURL(URLInterface url);

    ConcurrentNavigableMap<String, SortedSet<URLInterface>> getSubscribedServiceURLs();

    ConcurrentNavigableMap<String, SortedSet<URLInterface>> getExportedServiceURLs();

    int hashCode();

    boolean equals(Object obj);

    String toString();

    String toFullString();

    MetadataInfoInterface clone();
}
