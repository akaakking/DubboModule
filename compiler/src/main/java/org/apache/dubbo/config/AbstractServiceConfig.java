package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractInterfaceConfig;

public class AbstractServiceConfig extends AbstractInterfaceConfig implements AbstractServiceConfigInterface {

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public Integer getDelay() {
        return instance.getDelay();
    }

    public void setDelay(Integer delay) {
        instance.setDelay(delay);
    }

    public Boolean getExport() {
        return instance.getExport();
    }

    public void setExport(Boolean export) {
        instance.setExport(export);
    }

    public Integer getWeight() {
        return instance.getWeight();
    }

    public void setWeight(Integer weight) {
        instance.setWeight(weight);
    }

    public String getDocument() {
        return instance.getDocument();
    }

    public void setDocument(String document) {
        instance.setDocument(document);
    }

    public String getToken() {
        return instance.getToken();
    }

    public void setToken(Boolean token) {
        instance.setToken(token);
    }

    public void setToken(String token) {
        instance.setToken(token);
    }

    public Boolean isDeprecated() {
        return instance.isDeprecated();
    }

    public void setDeprecated(Boolean deprecated) {
        instance.setDeprecated(deprecated);
    }

    public Boolean isDynamic() {
        return instance.isDynamic();
    }

    public void setDynamic(Boolean dynamic) {
        instance.setDynamic(dynamic);
    }

    public List<ProtocolConfigInterface> getProtocols() {
        return instance.getProtocols();
    }

    public void setProtocols(List<? extends ProtocolConfigInterface> protocols) {
        instance.setProtocols(protocols);
    }

    public ProtocolConfigInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(ProtocolConfigInterface protocol) {
        instance.setProtocol(protocol.getInternalInstance());
    }

    public String getProtocolIds() {
        return instance.getProtocolIds();
    }

    public void setProtocolIds(String protocolIds) {
        instance.setProtocolIds(protocolIds);
    }

    public String getAccesslog() {
        return instance.getAccesslog();
    }

    public void setAccesslog(Boolean accesslog) {
        instance.setAccesslog(accesslog);
    }

    public void setAccesslog(String accesslog) {
        instance.setAccesslog(accesslog);
    }

    public Integer getExecutes() {
        return instance.getExecutes();
    }

    public void setExecutes(Integer executes) {
        instance.setExecutes(executes);
    }

    public String getFilter() {
        return instance.getFilter();
    }

    public String getListener() {
        return instance.getListener();
    }

    public void setListener(String listener) {
        instance.setListener(listener);
    }

    public Boolean isRegister() {
        return instance.isRegister();
    }

    public void setRegister(Boolean register) {
        instance.setRegister(register);
    }

    public Integer getWarmup() {
        return instance.getWarmup();
    }

    public void setWarmup(Integer warmup) {
        instance.setWarmup(warmup);
    }

    public String getSerialization() {
        return instance.getSerialization();
    }

    public void setSerialization(String serialization) {
        instance.setSerialization(serialization);
    }

    public Boolean getExportAsync() {
        return instance.getExportAsync();
    }

    public void setExportAsync(Boolean exportAsync) {
        instance.setExportAsync(exportAsync);
    }

    public AbstractServiceConfigInterface getInternalInstance() {
        return instance;
    }
}
