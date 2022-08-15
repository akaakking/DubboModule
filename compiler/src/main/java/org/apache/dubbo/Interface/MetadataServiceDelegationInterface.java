package org.apache.dubbo.Interface;

import org.apache.dubbo.common.URL;
import java.util.List;
import java.util.SortedSet;
import org.apache.dubbo.metadata.MetadataInfo;
import org.apache.dubbo.metadata.InstanceMetadataChangedListener;
import java.util.Map;
import java.util.Set;

public interface MetadataServiceDelegationInterface {
    String serviceName();
    URL getMetadataURL();
    void setMetadataURL(URL url);
    SortedSet getSubscribedURLs();
    SortedSet getExportedURLs(String serviceInterface, String group, String version, String protocol);
    Set getExportedServiceURLs();
    String getServiceDefinition(String interfaceName, String version, String group);
    String getServiceDefinition(String serviceKey);
    MetadataInfo getMetadataInfo(String revision);
    List getMetadataInfos();
    void exportInstanceMetadata(String instanceMetadata);
    Map getInstanceMetadataChangedListenerMap();
    String getAndListenInstanceMetadata(String consumerId, InstanceMetadataChangedListener listener);
    void destroy();
}