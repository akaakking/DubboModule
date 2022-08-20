package org.apache.dubbo.metadata;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.SortedSet;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataInfo implements MetadataInfoInterface {

    public void init() {
        instance.init();
    }

    public void addService(URLInterface url) {
        instance.addService(url);
    }

    public void removeService(URLInterface url) {
        instance.removeService(url);
    }

    public StringInterface getRevision() {
        return instance.getRevision();
    }

    public StringInterface calAndGetRevision() {
        return instance.calAndGetRevision();
    }

    public void setRevision(StringInterface revision) {
        instance.setRevision(revision);
    }

    public StringInterface getContent() {
        return instance.getContent();
    }

    public StringInterface getApp() {
        return instance.getApp();
    }

    public void setApp(StringInterface app) {
        instance.setApp(app);
    }

    public Map<String, ServiceInfoInterface> getServices() {
        return instance.getServices();
    }

    public ServiceInfoInterface getServiceInfo(StringInterface protocolServiceKey) {
        return instance.getServiceInfo(protocolServiceKey);
    }

    public ServiceInfoInterface getNoProtocolServiceInfo(StringInterface serviceKeyWithoutProtocol) {
        return instance.getNoProtocolServiceInfo(serviceKeyWithoutProtocol);
    }

    public ServiceInfoInterface getValidServiceInfo(StringInterface serviceKey) {
        return instance.getValidServiceInfo(serviceKey);
    }

    public Map<String, String> getExtendParams() {
        return instance.getExtendParams();
    }

    public Map<String, String> getInstanceParams() {
        return instance.getInstanceParams();
    }

    public StringInterface getParameter(StringInterface key, StringInterface serviceKey) {
        return instance.getParameter(key, serviceKey);
    }

    public Map<String, String> getParameters(StringInterface serviceKey) {
        return instance.getParameters(serviceKey);
    }

    public StringInterface getServiceString(StringInterface protocolServiceKey) {
        return instance.getServiceString(protocolServiceKey);
    }

    public void addSubscribedURL(URLInterface url) {
        instance.addSubscribedURL(url);
    }

    public boolean removeSubscribedURL(URLInterface url) {
        return instance.removeSubscribedURL(url);
    }

    public ConcurrentNavigableMap<String, SortedSet<URLInterface>> getSubscribedServiceURLs() {
        return instance.getSubscribedServiceURLs();
    }

    public ConcurrentNavigableMap<String, SortedSet<URLInterface>> getExportedServiceURLs() {
        return instance.getExportedServiceURLs();
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public boolean equals(ObjectInterface obj) {
        return instance.equals(obj);
    }

    public StringInterface toString() {
        return instance.toString();
    }

    public StringInterface toFullString() {
        return instance.toFullString();
    }

    public MetadataInfoInterface clone() {
        return instance.clone();
    }

    protected MetadataInfoInterface instance;

    public MetadataInfo() {
        instance = (MetadataInfoInterface) DubboClassLoader.getInstance(MetadataInfo.class.getName());
    }

    public MetadataInfo(String app) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{app};
        instance = (MetadataInfoInterface) DubboClassLoader.getInstance(MetadataInfo.class.getName(), params, args);
    }

    public MetadataInfo(String app, String revision, Map<String, ServiceInfo> services) {
        Class[] params = new Class[]{String.class, String.class, MapMap<String,ServiceInfo>.class};
        Object[] args = new Object[]{app, revision, services};
        instance = (MetadataInfoInterface) DubboClassLoader.getInstance(MetadataInfo.class.getName(), params, args);
    }
}
