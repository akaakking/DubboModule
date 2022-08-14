package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ProtocolConfigInterface{
    String getName();
    void setName(String name);
    String getHost();
    void setHost(String host);
    Integer getPort();
    void setPort(Integer port);
    String getPath();
    void setPath(String path);
    String getContextpath();
    void setContextpath(String contextpath);
    String getThreadpool();
    void setThreadpool(String threadpool);
    String getThreadname();
    void setThreadname(String threadname);
    Integer getCorethreads();
    void setCorethreads(Integer corethreads);
    Integer getThreads();
    void setThreads(Integer threads);
    Integer getIothreads();
    void setIothreads(Integer iothreads);
    Integer getAlive();
    void setAlive(Integer alive);
    Integer getQueues();
    void setQueues(Integer queues);
    Integer getAccepts();
    void setAccepts(Integer accepts);
    String getCodec();
    void setCodec(String codec);
    String getSerialization();
    void setSerialization(String serialization);
    String getCharset();
    void setCharset(String charset);
    Integer getPayload();
    void setPayload(Integer payload);
    Integer getBuffer();
    void setBuffer(Integer buffer);
    Integer getHeartbeat();
    void setHeartbeat(Integer heartbeat);
    String getServer();
    void setServer(String server);
    String getClient();
    void setClient(String client);
    String getAccesslog();
    void setAccesslog(String accesslog);
    String getTelnet();
    void setTelnet(String telnet);
    String getPrompt();
    void setPrompt(String prompt);
    String getStatus();
    void setStatus(String status);
    Boolean isRegister();
    void setRegister(Boolean register);
    String getTransporter();
    void setTransporter(String transporter);
    String getExchanger();
    void setExchanger(String exchanger);
    String getDispather();
    void setDispather(String dispather);
    String getDispatcher();
    void setDispatcher(String dispatcher);
    String getNetworker();
    void setNetworker(String networker);
    Map getParameters();
    void setParameters(Map parameters);
    Boolean getSslEnabled();
    void setSslEnabled(Boolean sslEnabled);
    Boolean getKeepAlive();
    void setKeepAlive(Boolean keepAlive);
    String getOptimizer();
    void setOptimizer(String optimizer);
    String getExtension();
    void setExtension(String extension);
    boolean isValid();

}