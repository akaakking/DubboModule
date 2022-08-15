package org.apache.dubbo.Interface;

import java.util.Map;

public interface RegistryConfigInterface {
    String getId();
    String getProtocol();
    void setProtocol(String protocol);
    String getAddress();
    void setAddress(String address);
    Integer getPort();
    void setPort(Integer port);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    Integer getWait();
    void setWait(Integer wait);
    Boolean isCheck();
    void setCheck(Boolean check);
    String getFile();
    void setFile(String file);
    String getTransport();
    void setTransport(String transport);
    String getTransporter();
    void setTransporter(String transporter);
    String getServer();
    void setServer(String server);
    String getClient();
    void setClient(String client);
    Integer getTimeout();
    void setTimeout(Integer timeout);
    Integer getSession();
    void setSession(Integer session);
    Boolean isDynamic();
    void setDynamic(Boolean dynamic);
    Boolean isRegister();
    void setRegister(Boolean register);
    Boolean isSubscribe();
    void setSubscribe(Boolean subscribe);
    String getCluster();
    void setCluster(String cluster);
    String getZone();
    void setZone(String zone);
    String getGroup();
    void setGroup(String group);
    String getVersion();
    void setVersion(String version);
    Map getParameters();
    void setParameters(Map parameters);
    void updateParameters(Map parameters);
    Boolean getSimplified();
    void setSimplified(Boolean simplified);
    String getExtraKeys();
    void setExtraKeys(String extraKeys);
    Boolean getUseAsConfigCenter();
    void setUseAsConfigCenter(Boolean useAsConfigCenter);
    Boolean getUseAsMetadataCenter();
    void setUseAsMetadataCenter(Boolean useAsMetadataCenter);
    String getAccepts();
    void setAccepts(String accepts);
    Boolean getPreferred();
    void setPreferred(Boolean preferred);
    Integer getWeight();
    void setWeight(Integer weight);
    String getRegisterMode();
    void setRegisterMode(String registerMode);
    Boolean getEnableEmptyProtection();
    void setEnableEmptyProtection(Boolean enableEmptyProtection);
    boolean isValid();
}