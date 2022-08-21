package org.apache.dubbo.config;

import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ProtocolConfig extends AbstractConfig implements ProtocolConfigInterface {

    public String getName() {
        return instance.getName();
    }

    public void setName(String name) {
        instance.setName(name);
    }

    public String getHost() {
        return instance.getHost();
    }

    public void setHost(String host) {
        instance.setHost(host);
    }

    public Integer getPort() {
        return instance.getPort();
    }

    public void setPort(Integer port) {
        instance.setPort(port);
    }

    public String getPath() {
        return instance.getPath();
    }

    public void setPath(String path) {
        instance.setPath(path);
    }

    public String getContextpath() {
        return instance.getContextpath();
    }

    public void setContextpath(String contextpath) {
        instance.setContextpath(contextpath);
    }

    public String getThreadpool() {
        return instance.getThreadpool();
    }

    public void setThreadpool(String threadpool) {
        instance.setThreadpool(threadpool);
    }

    public String getThreadname() {
        return instance.getThreadname();
    }

    public void setThreadname(String threadname) {
        instance.setThreadname(threadname);
    }

    public Integer getCorethreads() {
        return instance.getCorethreads();
    }

    public void setCorethreads(Integer corethreads) {
        instance.setCorethreads(corethreads);
    }

    public Integer getThreads() {
        return instance.getThreads();
    }

    public void setThreads(Integer threads) {
        instance.setThreads(threads);
    }

    public Integer getIothreads() {
        return instance.getIothreads();
    }

    public void setIothreads(Integer iothreads) {
        instance.setIothreads(iothreads);
    }

    public Integer getAlive() {
        return instance.getAlive();
    }

    public void setAlive(Integer alive) {
        instance.setAlive(alive);
    }

    public Integer getQueues() {
        return instance.getQueues();
    }

    public void setQueues(Integer queues) {
        instance.setQueues(queues);
    }

    public Integer getAccepts() {
        return instance.getAccepts();
    }

    public void setAccepts(Integer accepts) {
        instance.setAccepts(accepts);
    }

    public String getCodec() {
        return instance.getCodec();
    }

    public void setCodec(String codec) {
        instance.setCodec(codec);
    }

    public String getSerialization() {
        return instance.getSerialization();
    }

    public void setSerialization(String serialization) {
        instance.setSerialization(serialization);
    }

    public String getCharset() {
        return instance.getCharset();
    }

    public void setCharset(String charset) {
        instance.setCharset(charset);
    }

    public Integer getPayload() {
        return instance.getPayload();
    }

    public void setPayload(Integer payload) {
        instance.setPayload(payload);
    }

    public Integer getBuffer() {
        return instance.getBuffer();
    }

    public void setBuffer(Integer buffer) {
        instance.setBuffer(buffer);
    }

    public Integer getHeartbeat() {
        return instance.getHeartbeat();
    }

    public void setHeartbeat(Integer heartbeat) {
        instance.setHeartbeat(heartbeat);
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

    public String getAccesslog() {
        return instance.getAccesslog();
    }

    public void setAccesslog(String accesslog) {
        instance.setAccesslog(accesslog);
    }

    public String getTelnet() {
        return instance.getTelnet();
    }

    public void setTelnet(String telnet) {
        instance.setTelnet(telnet);
    }

    public String getPrompt() {
        return instance.getPrompt();
    }

    public void setPrompt(String prompt) {
        instance.setPrompt(prompt);
    }

    public String getStatus() {
        return instance.getStatus();
    }

    public void setStatus(String status) {
        instance.setStatus(status);
    }

    public Boolean isRegister() {
        return instance.isRegister();
    }

    public void setRegister(Boolean register) {
        instance.setRegister(register);
    }

    public String getTransporter() {
        return instance.getTransporter();
    }

    public void setTransporter(String transporter) {
        instance.setTransporter(transporter);
    }

    public String getExchanger() {
        return instance.getExchanger();
    }

    public void setExchanger(String exchanger) {
        instance.setExchanger(exchanger);
    }

    public String getDispather() {
        return instance.getDispather();
    }

    public void setDispather(String dispather) {
        instance.setDispather(dispather);
    }

    public String getDispatcher() {
        return instance.getDispatcher();
    }

    public void setDispatcher(String dispatcher) {
        instance.setDispatcher(dispatcher);
    }

    public String getNetworker() {
        return instance.getNetworker();
    }

    public void setNetworker(String networker) {
        instance.setNetworker(networker);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public Boolean getSslEnabled() {
        return instance.getSslEnabled();
    }

    public void setSslEnabled(Boolean sslEnabled) {
        instance.setSslEnabled(sslEnabled);
    }

    public Boolean getKeepAlive() {
        return instance.getKeepAlive();
    }

    public void setKeepAlive(Boolean keepAlive) {
        instance.setKeepAlive(keepAlive);
    }

    public String getOptimizer() {
        return instance.getOptimizer();
    }

    public void setOptimizer(String optimizer) {
        instance.setOptimizer(optimizer);
    }

    public String getExtension() {
        return instance.getExtension();
    }

    public void setExtension(String extension) {
        instance.setExtension(extension);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    protected ProtocolConfigInterface instance;

    public ProtocolConfigInterface getInternalInstance() {
        return instance;
    }

    public ProtocolConfig() {
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName());
        super.instance = this.instance;
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ProtocolConfig(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel, String name) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, name};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ProtocolConfig(String name, int port) {
        Class[] params = new Class[]{String.class, int.class};
        Object[] args = new Object[]{name, port};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel, String name, int port) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class, int.class};
        Object[] args = new Object[]{applicationModel, name, port};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
        super.instance = this.instance;
    }
}
