package org.apache.dubbo.Interface;

import java.util.SortedSet;
import java.lang.String;
import java.util.Set;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.metadata.InstanceMetadataChangedListener;

public interface MetadataServiceInterface {

    String serviceName();

    String version();

    URLInterface getMetadataURL();

    SortedSet<String> getSubscribedURLs();

    SortedSet<String> getExportedURLs();

    SortedSet<String> getExportedURLs(String serviceInterface);

    SortedSet<String> getExportedURLs(String serviceInterface, String group);

    SortedSet<String> getExportedURLs(String serviceInterface, String group, String version);

    SortedSet<String> getExportedURLs(String serviceInterface, String group, String version, String protocol);

    Set<URLInterface> getExportedServiceURLs();

    String getServiceDefinition(String interfaceName, String version, String group);

    String getServiceDefinition(String serviceKey);

    MetadataInfoInterface getMetadataInfo(String revision);

    List<MetadataInfoInterface> getMetadataInfos();

    void exportInstanceMetadata(String instanceMetadata);

    Map<String, InstanceMetadataChangedListener> getInstanceMetadataChangedListenerMap();

    String getAndListenInstanceMetadata(String consumerId, InstanceMetadataChangedListener listener);
}
