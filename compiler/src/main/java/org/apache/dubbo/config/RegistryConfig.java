package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class RegistryConfig extends AbstractConfig implements RegistryConfigInterface {

    public StringInterface getId() {
        return instance.getId();
    }

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
    }

    public StringInterface getAddress() {
        return instance.getAddress();
    }

    public void setAddress(StringInterface address) {
        instance.setAddress(address);
    }

    public IntegerInterface getPort() {
        return instance.getPort();
    }

    public void setPort(IntegerInterface port) {
        instance.setPort(port);
    }

    public StringInterface getUsername() {
        return instance.getUsername();
    }

    public void setUsername(StringInterface username) {
        instance.setUsername(username);
    }

    public StringInterface getPassword() {
        return instance.getPassword();
    }

    public void setPassword(StringInterface password) {
        instance.setPassword(password);
    }

    public IntegerInterface getWait() {
        return instance.getWait();
    }

    public void setWait(IntegerInterface wait) {
        instance.setWait(wait);
    }

    public BooleanInterface isCheck() {
        return instance.isCheck();
    }

    public void setCheck(BooleanInterface check) {
        instance.setCheck(check);
    }

    public StringInterface getFile() {
        return instance.getFile();
    }

    public void setFile(StringInterface file) {
        instance.setFile(file);
    }

    public StringInterface getTransport() {
        return instance.getTransport();
    }

    public void setTransport(StringInterface transport) {
        instance.setTransport(transport);
    }

    public StringInterface getTransporter() {
        return instance.getTransporter();
    }

    public void setTransporter(StringInterface transporter) {
        instance.setTransporter(transporter);
    }

    public StringInterface getServer() {
        return instance.getServer();
    }

    public void setServer(StringInterface server) {
        instance.setServer(server);
    }

    public StringInterface getClient() {
        return instance.getClient();
    }

    public void setClient(StringInterface client) {
        instance.setClient(client);
    }

    public IntegerInterface getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(IntegerInterface timeout) {
        instance.setTimeout(timeout);
    }

    public IntegerInterface getSession() {
        return instance.getSession();
    }

    public void setSession(IntegerInterface session) {
        instance.setSession(session);
    }

    public BooleanInterface isDynamic() {
        return instance.isDynamic();
    }

    public void setDynamic(BooleanInterface dynamic) {
        instance.setDynamic(dynamic);
    }

    public BooleanInterface isRegister() {
        return instance.isRegister();
    }

    public void setRegister(BooleanInterface register) {
        instance.setRegister(register);
    }

    public BooleanInterface isSubscribe() {
        return instance.isSubscribe();
    }

    public void setSubscribe(BooleanInterface subscribe) {
        instance.setSubscribe(subscribe);
    }

    public StringInterface getCluster() {
        return instance.getCluster();
    }

    public void setCluster(StringInterface cluster) {
        instance.setCluster(cluster);
    }

    public StringInterface getZone() {
        return instance.getZone();
    }

    public void setZone(StringInterface zone) {
        instance.setZone(zone);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public void updateParameters(Map<String, String> parameters) {
        instance.updateParameters(parameters);
    }

    public BooleanInterface getSimplified() {
        return instance.getSimplified();
    }

    public void setSimplified(BooleanInterface simplified) {
        instance.setSimplified(simplified);
    }

    public StringInterface getExtraKeys() {
        return instance.getExtraKeys();
    }

    public void setExtraKeys(StringInterface extraKeys) {
        instance.setExtraKeys(extraKeys);
    }

    public BooleanInterface getUseAsConfigCenter() {
        return instance.getUseAsConfigCenter();
    }

    public void setUseAsConfigCenter(BooleanInterface useAsConfigCenter) {
        instance.setUseAsConfigCenter(useAsConfigCenter);
    }

    public BooleanInterface getUseAsMetadataCenter() {
        return instance.getUseAsMetadataCenter();
    }

    public void setUseAsMetadataCenter(BooleanInterface useAsMetadataCenter) {
        instance.setUseAsMetadataCenter(useAsMetadataCenter);
    }

    public StringInterface getAccepts() {
        return instance.getAccepts();
    }

    public void setAccepts(StringInterface accepts) {
        instance.setAccepts(accepts);
    }

    public BooleanInterface getPreferred() {
        return instance.getPreferred();
    }

    public void setPreferred(BooleanInterface preferred) {
        instance.setPreferred(preferred);
    }

    public IntegerInterface getWeight() {
        return instance.getWeight();
    }

    public void setWeight(IntegerInterface weight) {
        instance.setWeight(weight);
    }

    public StringInterface getRegisterMode() {
        return instance.getRegisterMode();
    }

    public void setRegisterMode(StringInterface registerMode) {
        instance.setRegisterMode(registerMode);
    }

    public BooleanInterface getEnableEmptyProtection() {
        return instance.getEnableEmptyProtection();
    }

    public void setEnableEmptyProtection(BooleanInterface enableEmptyProtection) {
        instance.setEnableEmptyProtection(enableEmptyProtection);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public RegistryConfig() {
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName());
    }

    public RegistryConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
    }

    public RegistryConfig(String address) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{address};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
    }

    public RegistryConfig(ApplicationModelInterface applicationModel, String address) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, address};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
    }

    public RegistryConfig(String address, String protocol) {
        Class[] params = new Class[]{String.class, String.class};
        Object[] args = new Object[]{address, protocol};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
    }

    public RegistryConfig(ApplicationModelInterface applicationModel, String address, String protocol) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class, String.class};
        Object[] args = new Object[]{applicationModel, address, protocol};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
    }
}
