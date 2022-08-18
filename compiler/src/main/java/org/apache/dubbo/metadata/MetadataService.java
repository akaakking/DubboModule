package org.apache.dubbo.metadata;

import java.util.SortedSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataService implements MetadataServiceInterface {

    public String serviceName() {
        return instance.serviceName();
    }

    public String version() {
        return instance.version();
    }

    public URLInterface getMetadataURL() {
        return instance.getMetadataURL();
    }

    public SortedSet<String> getSubscribedURLs() {
        return instance.getSubscribedURLs();
    }

    public SortedSet<String> getExportedURLs() {
        return instance.getExportedURLs();
    }

    public SortedSet<String> getExportedURLs(String serviceInterface) {
        return instance.getExportedURLs(serviceInterface);
    }

    public SortedSet<String> getExportedURLs(String serviceInterface, String group) {
        return instance.getExportedURLs(serviceInterface, group);
    }

    public SortedSet<String> getExportedURLs(String serviceInterface, String group, String version) {
        return instance.getExportedURLs(serviceInterface, group, version);
    }

    public SortedSet<String> getExportedURLs(String serviceInterface, String group, String version, String protocol) {
        return instance.getExportedURLs(serviceInterface, group, version, protocol);
    }

    public Set<URL> getExportedServiceURLs() {
        return instance.getExportedServiceURLs();
    }

    public String getServiceDefinition(String interfaceName, String version, String group) {
        return instance.getServiceDefinition(interfaceName, version, group);
    }

    public String getServiceDefinition(String serviceKey) {
        return instance.getServiceDefinition(serviceKey);
    }

    public MetadataInfoInterface getMetadataInfo(String revision) {
        return instance.getMetadataInfo(revision);
    }

    public List<MetadataInfo> getMetadataInfos() {
        return instance.getMetadataInfos();
    }

    public void exportInstanceMetadata(String instanceMetadata) {
        instance.exportInstanceMetadata(instanceMetadata);
    }

    public Map<String, InstanceMetadataChangedListener> getInstanceMetadataChangedListenerMap() {
        return instance.getInstanceMetadataChangedListenerMap();
    }

    public String getAndListenInstanceMetadata(String consumerId, InstanceMetadataChangedListenerInterface listener) {
        return instance.getAndListenInstanceMetadata(consumerId, listener);
    }

    public static SortedSet<String> toSortedStrings(Iterable<URL> iterable) {
        Method method = instance.getClass().getMethod(Iterable.class);
        return method.invoke(iterable);
    }

    public static SortedSet<String> toSortedStrings(Stream<URL> stream) {
        Method method = instance.getClass().getMethod(Stream.class);
        return method.invoke(stream);
    }

    public static boolean isMetadataService(String interfaceName) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(interfaceName);
    }
}
