package org.apache.dubbo.registry.client;

import java.lang.String;
import java.util.Map;
import java.util.Set;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.URL;

public class InstanceAddressURL extends URL implements InstanceAddressURLInterface {

    public ServiceInstanceInterface getInstance() {
        return instance.getInstance();
    }

    public MetadataInfoInterface getMetadataInfo() {
        return instance.getMetadataInfo();
    }

    public String getServiceInterface() {
        return instance.getServiceInterface();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public String getProtocolServiceKey() {
        return instance.getProtocolServiceKey();
    }

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public String getHost() {
        return instance.getHost();
    }

    public int getPort() {
        return instance.getPort();
    }

    public String getIp() {
        return instance.getIp();
    }

    public String getRemoteApplication() {
        return instance.getRemoteApplication();
    }

    public String getSide() {
        return instance.getSide();
    }

    public String getPath() {
        return instance.getPath();
    }

    public String getParameter(String key) {
        return instance.getParameter(key);
    }

    public String getServiceParameter(String service, String key) {
        return instance.getServiceParameter(service, key);
    }

    public String getServiceMethodParameter(String protocolServiceKey, String method, String key) {
        return instance.getServiceMethodParameter(protocolServiceKey, method, key);
    }

    public String getMethodParameter(String method, String key) {
        return instance.getMethodParameter(method, key);
    }

    public boolean hasServiceMethodParameter(String protocolServiceKey, String method, String key) {
        return instance.hasServiceMethodParameter(protocolServiceKey, method, key);
    }

    public boolean hasMethodParameter(String method, String key) {
        return instance.hasMethodParameter(method, key);
    }

    public boolean hasServiceMethodParameter(String protocolServiceKey, String method) {
        return instance.hasServiceMethodParameter(protocolServiceKey, method);
    }

    public boolean hasMethodParameter(String method) {
        return instance.hasMethodParameter(method);
    }

    public Map<String, String> getServiceParameters(String protocolServiceKey) {
        return instance.getServiceParameters(protocolServiceKey);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public URLInterface addParameter(String key, String value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameterIfAbsent(String key, String value) {
        return instance.addParameterIfAbsent(key, value);
    }

    public URLInterface addServiceParameter(String protocolServiceKey, String key, String value) {
        return instance.addServiceParameter(protocolServiceKey, key, value);
    }

    public URLInterface addServiceParameterIfAbsent(String protocolServiceKey, String key, String value) {
        return instance.addServiceParameterIfAbsent(protocolServiceKey, key, value);
    }

    public URLInterface addConsumerParams(String protocolServiceKey, Map<String, String> params) {
        return instance.addConsumerParams(protocolServiceKey, params);
    }

    public String getAnyMethodParameter(String key) {
        return instance.getAnyMethodParameter(key);
    }

    public URLParamInterface getUrlParam() {
        return instance.getUrlParam();
    }

    public URLAddressInterface getUrlAddress() {
        return instance.getUrlAddress();
    }

    public FrameworkModelInterface getOrDefaultFrameworkModel() {
        return instance.getOrDefaultFrameworkModel();
    }

    public ApplicationModelInterface getOrDefaultApplicationModel() {
        return instance.getOrDefaultApplicationModel();
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ScopeModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public Set<String> getProviderFirstParams() {
        return instance.getProviderFirstParams();
    }

    public void setProviderFirstParams(Set<String> providerFirstParams) {
        instance.setProviderFirstParams(providerFirstParams);
    }

    public boolean equals(Object obj) {
        return instance.equals(obj);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public String toString() {
        return instance.toString();
    }

    protected InstanceAddressURLInterface instance;

    public InstanceAddressURLInterface getInternalInstance() {
        return instance;
    }

    public InstanceAddressURL(ServiceInstanceInterface instance, MetadataInfoInterface metadataInfo) {
        Class[] params = new Class[]{ServiceInstanceInterface.class, MetadataInfoInterface.class};
        Object[] args = new Object[]{instance, metadataInfo};
        instance = (InstanceAddressURLInterface) DubboClassLoader.getInstance(InstanceAddressURL.class.getName(), params, args);
        super.instance = this.instance;
    }

    public InstanceAddressURL(ServiceInstanceInterface instance, MetadataInfoInterface metadataInfo, String protocol) {
        Class[] params = new Class[]{ServiceInstanceInterface.class, MetadataInfoInterface.class, String.class};
        Object[] args = new Object[]{instance, metadataInfo, protocol};
        this.instance = (InstanceAddressURLInterface) DubboClassLoader.getInstance(InstanceAddressURL.class.getName(), params, args);
        super.instance = this.instance;
    }

    protected InstanceAddressURL() {
        instance = (InstanceAddressURLInterface) DubboClassLoader.getInstance(InstanceAddressURL.class.getName());
        super.instance = this.instance;
    }
}
