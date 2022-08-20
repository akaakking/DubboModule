package org.apache.dubbo.config.metadata;

import java.util.SortedSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataServiceDelegation implements MetadataServiceDelegationInterface {

    public StringInterface serviceName() {
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

    public SortedSet<String> getExportedURLs(StringInterface serviceInterface, StringInterface group, StringInterface version, StringInterface protocol) {
        return instance.getExportedURLs(serviceInterface, group, version, protocol);
    }

    public Set<URLInterface> getExportedServiceURLs() {
        return instance.getExportedServiceURLs();
    }

    public StringInterface getServiceDefinition(StringInterface interfaceName, StringInterface version, StringInterface group) {
        return instance.getServiceDefinition(interfaceName, version, group);
    }

    public StringInterface getServiceDefinition(StringInterface serviceKey) {
        return instance.getServiceDefinition(serviceKey);
    }

    public MetadataInfoInterface getMetadataInfo(StringInterface revision) {
        return instance.getMetadataInfo(revision);
    }

    public List<MetadataInfoInterface> getMetadataInfos() {
        return instance.getMetadataInfos();
    }

    public void exportInstanceMetadata(StringInterface instanceMetadata) {
        instance.exportInstanceMetadata(instanceMetadata);
    }

    public Map<String, InstanceMetadataChangedListenerInterface> getInstanceMetadataChangedListenerMap() {
        return instance.getInstanceMetadataChangedListenerMap();
    }

    public StringInterface getAndListenInstanceMetadata(StringInterface consumerId, InstanceMetadataChangedListenerInterface listener) {
        return instance.getAndListenInstanceMetadata(consumerId, listener);
    }

    public void destroy() {
        instance.destroy();
    }

    protected MetadataServiceDelegationInterface instance;

    public MetadataServiceDelegation(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (MetadataServiceDelegationInterface) DubboClassLoader.getInstance(MetadataServiceDelegation.class.getName(), params, args);
    }
}
