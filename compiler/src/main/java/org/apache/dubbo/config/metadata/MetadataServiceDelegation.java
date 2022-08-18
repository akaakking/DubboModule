package org.apache.dubbo.config.metadata;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.SortedSet;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataServiceDelegation implements MetadataServiceDelegationInterface {

    public String serviceName() {
        return instance.serviceName();
    }

    public URLInterface getMetadataURL() {
        return instance.getMetadataURL();
    }

    public void setMetadataURL(URLInterface url) {
        instance.setMetadataURL(url);
    }

    public SortedSet<String> getSubscribedURLs() {
        return instance.getSubscribedURLs();
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

    public void destroy() {
        instance.destroy();
    }

    public MetadataServiceDelegation(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (MetadataServiceDelegationInterface) DubboClassLoader.getInstance(MetadataServiceDelegation.class.getName(), params, args);
    }
}
