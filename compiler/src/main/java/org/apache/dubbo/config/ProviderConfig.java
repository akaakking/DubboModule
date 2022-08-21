package org.apache.dubbo.config;

import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractServiceConfig;

public class ProviderConfig extends AbstractServiceConfig implements ProviderConfigInterface {

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
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

    public Integer getWait() {
        return instance.getWait();
    }

    public void setWait(Integer wait) {
        instance.setWait(wait);
    }

    public Integer getExportThreadNum() {
        return instance.getExportThreadNum();
    }

    public void setExportThreadNum(Integer exportThreadNum) {
        instance.setExportThreadNum(exportThreadNum);
    }

    public Boolean getExportBackground() {
        return instance.getExportBackground();
    }

    public void setExportBackground(Boolean exportBackground) {
        instance.setExportBackground(exportBackground);
    }

    protected ProviderConfigInterface instance;

    public ProviderConfigInterface getInternalInstance() {
        return instance;
    }

    public ProviderConfig() {
        instance = (ProviderConfigInterface) DubboClassLoader.getInstance(ProviderConfig.class.getName());
        super.instance = this.instance;
    }

    public ProviderConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ProviderConfigInterface) DubboClassLoader.getInstance(ProviderConfig.class.getName(), params, args);
        super.instance = this.instance;
    }
}
