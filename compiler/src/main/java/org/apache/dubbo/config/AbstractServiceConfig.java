package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractInterfaceConfig;

public class AbstractServiceConfig extends AbstractInterfaceConfig implements AbstractServiceConfigInterface {

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public IntegerInterface getDelay() {
        return instance.getDelay();
    }

    public void setDelay(IntegerInterface delay) {
        instance.setDelay(delay);
    }

    public BooleanInterface getExport() {
        return instance.getExport();
    }

    public void setExport(BooleanInterface export) {
        instance.setExport(export);
    }

    public IntegerInterface getWeight() {
        return instance.getWeight();
    }

    public void setWeight(IntegerInterface weight) {
        instance.setWeight(weight);
    }

    public StringInterface getDocument() {
        return instance.getDocument();
    }

    public void setDocument(StringInterface document) {
        instance.setDocument(document);
    }

    public StringInterface getToken() {
        return instance.getToken();
    }

    public void setToken(BooleanInterface token) {
        instance.setToken(token);
    }

    public void setToken(StringInterface token) {
        instance.setToken(token);
    }

    public BooleanInterface isDeprecated() {
        return instance.isDeprecated();
    }

    public void setDeprecated(BooleanInterface deprecated) {
        instance.setDeprecated(deprecated);
    }

    public BooleanInterface isDynamic() {
        return instance.isDynamic();
    }

    public void setDynamic(BooleanInterface dynamic) {
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
        instance.setProtocol(protocol);
    }

    public StringInterface getProtocolIds() {
        return instance.getProtocolIds();
    }

    public void setProtocolIds(StringInterface protocolIds) {
        instance.setProtocolIds(protocolIds);
    }

    public StringInterface getAccesslog() {
        return instance.getAccesslog();
    }

    public void setAccesslog(BooleanInterface accesslog) {
        instance.setAccesslog(accesslog);
    }

    public void setAccesslog(StringInterface accesslog) {
        instance.setAccesslog(accesslog);
    }

    public IntegerInterface getExecutes() {
        return instance.getExecutes();
    }

    public void setExecutes(IntegerInterface executes) {
        instance.setExecutes(executes);
    }

    public StringInterface getFilter() {
        return instance.getFilter();
    }

    public StringInterface getListener() {
        return instance.getListener();
    }

    public void setListener(StringInterface listener) {
        instance.setListener(listener);
    }

    public BooleanInterface isRegister() {
        return instance.isRegister();
    }

    public void setRegister(BooleanInterface register) {
        instance.setRegister(register);
    }

    public IntegerInterface getWarmup() {
        return instance.getWarmup();
    }

    public void setWarmup(IntegerInterface warmup) {
        instance.setWarmup(warmup);
    }

    public StringInterface getSerialization() {
        return instance.getSerialization();
    }

    public void setSerialization(StringInterface serialization) {
        instance.setSerialization(serialization);
    }

    public BooleanInterface getExportAsync() {
        return instance.getExportAsync();
    }

    public void setExportAsync(BooleanInterface exportAsync) {
        instance.setExportAsync(exportAsync);
    }
}
