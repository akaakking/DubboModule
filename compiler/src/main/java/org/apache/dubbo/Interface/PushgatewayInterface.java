package org.apache.dubbo.Interface;


public interface PushgatewayInterface extends Object{
    Boolean getEnabled();
    void setEnabled(Boolean enabled);
    String getBaseUrl();
    void setBaseUrl(String baseUrl);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    Integer getPushInterval();
    void setPushInterval(Integer pushInterval);
    String getJob();
    void setJob(String job);
}