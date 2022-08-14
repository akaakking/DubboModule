package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface AbstractServiceConfigInterface{
    String getVersion();
    void setVersion(String version);
    String getGroup();
    void setGroup(String group);
    Integer getDelay();
    void setDelay(Integer delay);
    Boolean getExport();
    void setExport(Boolean export);
    Integer getWeight();
    void setWeight(Integer weight);
    String getDocument();
    void setDocument(String document);
    String getToken();
    void setToken(Boolean token);
    void setToken(String token);
    Boolean isDeprecated();
    void setDeprecated(Boolean deprecated);
    Boolean isDynamic();
    void setDynamic(Boolean dynamic);
    List getProtocols();
    void setProtocols(List protocols);
    ProtocolConfigInterface getProtocol();
    void setProtocol(ProtocolConfigInterface protocol);
    String getProtocolIds();
    void setProtocolIds(String protocolIds);
    String getAccesslog();
    void setAccesslog(Boolean accesslog);
    void setAccesslog(String accesslog);
    Integer getExecutes();
    void setExecutes(Integer executes);
    String getFilter();
    String getListener();
    void setListener(String listener);
    Boolean isRegister();
    void setRegister(Boolean register);
    Integer getWarmup();
    void setWarmup(Integer warmup);
    String getSerialization();
    void setSerialization(String serialization);
    Boolean getExportAsync();
    void setExportAsync(Boolean exportAsync);

}