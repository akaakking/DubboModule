package org.apache.dubbo.registry.client;

import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceInstance implements ServiceInstanceInterface {

    public String getServiceName() {
        return instance.getServiceName();
    }

    public String getHost() {
        return instance.getHost();
    }

    public int getPort() {
        return instance.getPort();
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public boolean isEnabled() {
        return instance.isEnabled();
    }

    public boolean isHealthy() {
        return instance.isHealthy();
    }

    public Map<String, String> getMetadata() {
        return instance.getMetadata();
    }

    public SortedMap<String, String> getSortedMetadata() {
        return instance.getSortedMetadata();
    }

    public String getRegistryCluster() {
        return instance.getRegistryCluster();
    }

    public void setRegistryCluster(String registryCluster) {
        instance.setRegistryCluster(registryCluster);
    }

    public Map<String, String> getExtendParams() {
        return instance.getExtendParams();
    }

    public String getExtendParam(String key) {
        return instance.getExtendParam(key);
    }

    public String putExtendParam(String key, String value) {
        return instance.putExtendParam(key, value);
    }

    public String putExtendParamIfAbsent(String key, String value) {
        return instance.putExtendParamIfAbsent(key, value);
    }

    public String removeExtendParam(String key) {
        return instance.removeExtendParam(key);
    }

    public Map<String, String> getAllParams() {
        return instance.getAllParams();
    }

    public void setApplicationModel(ApplicationModelInterface applicationModel) {
        instance.setApplicationModel(applicationModel);
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ApplicationModelInterface getOrDefaultApplicationModel() {
        return instance.getOrDefaultApplicationModel();
    }

    public String getMetadata(String name) {
        return instance.getMetadata(name);
    }

    public String getMetadata(String name, String defaultValue) {
        return instance.getMetadata(name, defaultValue);
    }

    public MetadataInfoInterface getServiceMetadata() {
        return instance.getServiceMetadata();
    }

    public void setServiceMetadata(MetadataInfoInterface serviceMetadata) {
        instance.setServiceMetadata(serviceMetadata);
    }

    public InstanceAddressURLInterface toURL(String protocol) {
        return instance.toURL(protocol);
    }
}
