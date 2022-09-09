package org.apache.dubbo.Interface;

import org.apache.dubbo.metadata.MetadataService;
import org.apache.dubbo.common.resource.Disposable;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.common.URL;
import java.util.SortedSet;
import java.lang.String;
import java.util.Set;
import org.apache.dubbo.Interface.MetadataInfoInterface;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.metadata.InstanceMetadataChangedListener;

public interface MetadataServiceDelegationInterface extends MetadataService, Disposable {

    String serviceName();

    URLInterface getMetadataURL();

    void setMetadataURL(URLInterface url);

    SortedSet<String> getSubscribedURLs();

    SortedSet<String> getExportedURLs(String serviceInterface, String group, String version, String protocol);

    Set<URLInterface> getExportedServiceURLs();

    String getServiceDefinition(String interfaceName, String version, String group);

    String getServiceDefinition(String serviceKey);

    MetadataInfoInterface getMetadataInfo(String revision);

    List<MetadataInfoInterface> getMetadataInfos();

    void exportInstanceMetadata(String instanceMetadata);

    Map<String, InstanceMetadataChangedListener> getInstanceMetadataChangedListenerMap();

    String getAndListenInstanceMetadata(String consumerId, InstanceMetadataChangedListener listener);

    void destroy();
}
