package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ProtocolConfig extends AbstractConfig implements ProtocolConfigInterface {

    public StringInterface getName() {
        return instance.getName();
    }

    public void setName(StringInterface name) {
        instance.setName(name);
    }

    public StringInterface getHost() {
        return instance.getHost();
    }

    public void setHost(StringInterface host) {
        instance.setHost(host);
    }

    public IntegerInterface getPort() {
        return instance.getPort();
    }

    public void setPort(IntegerInterface port) {
        instance.setPort(port);
    }

    public StringInterface getPath() {
        return instance.getPath();
    }

    public void setPath(StringInterface path) {
        instance.setPath(path);
    }

    public StringInterface getContextpath() {
        return instance.getContextpath();
    }

    public void setContextpath(StringInterface contextpath) {
        instance.setContextpath(contextpath);
    }

    public StringInterface getThreadpool() {
        return instance.getThreadpool();
    }

    public void setThreadpool(StringInterface threadpool) {
        instance.setThreadpool(threadpool);
    }

    public StringInterface getThreadname() {
        return instance.getThreadname();
    }

    public void setThreadname(StringInterface threadname) {
        instance.setThreadname(threadname);
    }

    public IntegerInterface getCorethreads() {
        return instance.getCorethreads();
    }

    public void setCorethreads(IntegerInterface corethreads) {
        instance.setCorethreads(corethreads);
    }

    public IntegerInterface getThreads() {
        return instance.getThreads();
    }

    public void setThreads(IntegerInterface threads) {
        instance.setThreads(threads);
    }

    public IntegerInterface getIothreads() {
        return instance.getIothreads();
    }

    public void setIothreads(IntegerInterface iothreads) {
        instance.setIothreads(iothreads);
    }

    public IntegerInterface getAlive() {
        return instance.getAlive();
    }

    public void setAlive(IntegerInterface alive) {
        instance.setAlive(alive);
    }

    public IntegerInterface getQueues() {
        return instance.getQueues();
    }

    public void setQueues(IntegerInterface queues) {
        instance.setQueues(queues);
    }

    public IntegerInterface getAccepts() {
        return instance.getAccepts();
    }

    public void setAccepts(IntegerInterface accepts) {
        instance.setAccepts(accepts);
    }

    public StringInterface getCodec() {
        return instance.getCodec();
    }

    public void setCodec(StringInterface codec) {
        instance.setCodec(codec);
    }

    public StringInterface getSerialization() {
        return instance.getSerialization();
    }

    public void setSerialization(StringInterface serialization) {
        instance.setSerialization(serialization);
    }

    public StringInterface getCharset() {
        return instance.getCharset();
    }

    public void setCharset(StringInterface charset) {
        instance.setCharset(charset);
    }

    public IntegerInterface getPayload() {
        return instance.getPayload();
    }

    public void setPayload(IntegerInterface payload) {
        instance.setPayload(payload);
    }

    public IntegerInterface getBuffer() {
        return instance.getBuffer();
    }

    public void setBuffer(IntegerInterface buffer) {
        instance.setBuffer(buffer);
    }

    public IntegerInterface getHeartbeat() {
        return instance.getHeartbeat();
    }

    public void setHeartbeat(IntegerInterface heartbeat) {
        instance.setHeartbeat(heartbeat);
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

    public StringInterface getAccesslog() {
        return instance.getAccesslog();
    }

    public void setAccesslog(StringInterface accesslog) {
        instance.setAccesslog(accesslog);
    }

    public StringInterface getTelnet() {
        return instance.getTelnet();
    }

    public void setTelnet(StringInterface telnet) {
        instance.setTelnet(telnet);
    }

    public StringInterface getPrompt() {
        return instance.getPrompt();
    }

    public void setPrompt(StringInterface prompt) {
        instance.setPrompt(prompt);
    }

    public StringInterface getStatus() {
        return instance.getStatus();
    }

    public void setStatus(StringInterface status) {
        instance.setStatus(status);
    }

    public BooleanInterface isRegister() {
        return instance.isRegister();
    }

    public void setRegister(BooleanInterface register) {
        instance.setRegister(register);
    }

    public StringInterface getTransporter() {
        return instance.getTransporter();
    }

    public void setTransporter(StringInterface transporter) {
        instance.setTransporter(transporter);
    }

    public StringInterface getExchanger() {
        return instance.getExchanger();
    }

    public void setExchanger(StringInterface exchanger) {
        instance.setExchanger(exchanger);
    }

    public StringInterface getDispather() {
        return instance.getDispather();
    }

    public void setDispather(StringInterface dispather) {
        instance.setDispather(dispather);
    }

    public StringInterface getDispatcher() {
        return instance.getDispatcher();
    }

    public void setDispatcher(StringInterface dispatcher) {
        instance.setDispatcher(dispatcher);
    }

    public StringInterface getNetworker() {
        return instance.getNetworker();
    }

    public void setNetworker(StringInterface networker) {
        instance.setNetworker(networker);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public BooleanInterface getSslEnabled() {
        return instance.getSslEnabled();
    }

    public void setSslEnabled(BooleanInterface sslEnabled) {
        instance.setSslEnabled(sslEnabled);
    }

    public BooleanInterface getKeepAlive() {
        return instance.getKeepAlive();
    }

    public void setKeepAlive(BooleanInterface keepAlive) {
        instance.setKeepAlive(keepAlive);
    }

    public StringInterface getOptimizer() {
        return instance.getOptimizer();
    }

    public void setOptimizer(StringInterface optimizer) {
        instance.setOptimizer(optimizer);
    }

    public StringInterface getExtension() {
        return instance.getExtension();
    }

    public void setExtension(StringInterface extension) {
        instance.setExtension(extension);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public ProtocolConfig() {
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName());
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
    }

    public ProtocolConfig(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel, String name) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, name};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
    }

    public ProtocolConfig(String name, int port) {
        Class[] params = new Class[]{String.class, int.class};
        Object[] args = new Object[]{name, port};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
    }

    public ProtocolConfig(ApplicationModelInterface applicationModel, String name, int port) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class, int.class};
        Object[] args = new Object[]{applicationModel, name, port};
        instance = (ProtocolConfigInterface) DubboClassLoader.getInstance(ProtocolConfig.class.getName(), params, args);
    }
}
