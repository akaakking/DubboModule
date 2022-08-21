package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class RegistryConfig extends AbstractConfig implements RegistryConfigInterface {

    public String getId() {
        return instance.getId();
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public void setAddress(String address) {
        instance.setAddress(address);
    }

    public Integer getPort() {
        return instance.getPort();
    }

    public void setPort(Integer port) {
        instance.setPort(port);
    }

    public String getUsername() {
        return instance.getUsername();
    }

    public void setUsername(String username) {
        instance.setUsername(username);
    }

    public String getPassword() {
        return instance.getPassword();
    }

    public void setPassword(String password) {
        instance.setPassword(password);
    }

    public Integer getWait() {
        return instance.getWait();
    }

    public void setWait(Integer wait) {
        instance.setWait(wait);
    }

    public Boolean isCheck() {
        return instance.isCheck();
    }

    public void setCheck(Boolean check) {
        instance.setCheck(check);
    }

    public String getFile() {
        return instance.getFile();
    }

    public void setFile(String file) {
        instance.setFile(file);
    }

    public String getTransport() {
        return instance.getTransport();
    }

    public void setTransport(String transport) {
        instance.setTransport(transport);
    }

    public String getTransporter() {
        return instance.getTransporter();
    }

    public void setTransporter(String transporter) {
        instance.setTransporter(transporter);
    }

    public String getServer() {
        return instance.getServer();
    }

    public void setServer(String server) {
        instance.setServer(server);
    }

    public String getClient() {
        return instance.getClient();
    }

    public void setClient(String client) {
        instance.setClient(client);
    }

    public Integer getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(Integer timeout) {
        instance.setTimeout(timeout);
    }

    public Integer getSession() {
        return instance.getSession();
    }

    public void setSession(Integer session) {
        instance.setSession(session);
    }

    public Boolean isDynamic() {
        return instance.isDynamic();
    }

    public void setDynamic(Boolean dynamic) {
        instance.setDynamic(dynamic);
    }

    public Boolean isRegister() {
        return instance.isRegister();
    }

    public void setRegister(Boolean register) {
        instance.setRegister(register);
    }

    public Boolean isSubscribe() {
        return instance.isSubscribe();
    }

    public void setSubscribe(Boolean subscribe) {
        instance.setSubscribe(subscribe);
    }

    public String getCluster() {
        return instance.getCluster();
    }

    public void setCluster(String cluster) {
        instance.setCluster(cluster);
    }

    public String getZone() {
        return instance.getZone();
    }

    public void setZone(String zone) {
        instance.setZone(zone);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
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

    public Boolean getSimplified() {
        return instance.getSimplified();
    }

    public void setSimplified(Boolean simplified) {
        instance.setSimplified(simplified);
    }

    public String getExtraKeys() {
        return instance.getExtraKeys();
    }

    public void setExtraKeys(String extraKeys) {
        instance.setExtraKeys(extraKeys);
    }

    public Boolean getUseAsConfigCenter() {
        return instance.getUseAsConfigCenter();
    }

    public void setUseAsConfigCenter(Boolean useAsConfigCenter) {
        instance.setUseAsConfigCenter(useAsConfigCenter);
    }

    public Boolean getUseAsMetadataCenter() {
        return instance.getUseAsMetadataCenter();
    }

    public void setUseAsMetadataCenter(Boolean useAsMetadataCenter) {
        instance.setUseAsMetadataCenter(useAsMetadataCenter);
    }

    public String getAccepts() {
        return instance.getAccepts();
    }

    public void setAccepts(String accepts) {
        instance.setAccepts(accepts);
    }

    public Boolean getPreferred() {
        return instance.getPreferred();
    }

    public void setPreferred(Boolean preferred) {
        instance.setPreferred(preferred);
    }

    public Integer getWeight() {
        return instance.getWeight();
    }

    public void setWeight(Integer weight) {
        instance.setWeight(weight);
    }

    public String getRegisterMode() {
        return instance.getRegisterMode();
    }

    public void setRegisterMode(String registerMode) {
        instance.setRegisterMode(registerMode);
    }

    public Boolean getEnableEmptyProtection() {
        return instance.getEnableEmptyProtection();
    }

    public void setEnableEmptyProtection(Boolean enableEmptyProtection) {
        instance.setEnableEmptyProtection(enableEmptyProtection);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    protected RegistryConfigInterface instance;

    public RegistryConfigInterface getInternalInstance() {
        return instance;
    }

    public RegistryConfig() {
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName());
        super.instance = instance;
    }

    public RegistryConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public RegistryConfig(String address) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{address};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public RegistryConfig(ApplicationModelInterface applicationModel, String address) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, address};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public RegistryConfig(String address, String protocol) {
        Class[] params = new Class[]{String.class, String.class};
        Object[] args = new Object[]{address, protocol};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public RegistryConfig(ApplicationModelInterface applicationModel, String address, String protocol) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class, String.class};
        Object[] args = new Object[]{applicationModel, address, protocol};
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class.getName(), params, args);
        super.instance = instance;
    }
}
