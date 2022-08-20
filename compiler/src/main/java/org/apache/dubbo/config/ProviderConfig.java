package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractServiceConfig;

public class ProviderConfig extends AbstractServiceConfig implements ProviderConfigInterface {

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
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

    public IntegerInterface getWait() {
        return instance.getWait();
    }

    public void setWait(IntegerInterface wait) {
        instance.setWait(wait);
    }

    public IntegerInterface getExportThreadNum() {
        return instance.getExportThreadNum();
    }

    public void setExportThreadNum(IntegerInterface exportThreadNum) {
        instance.setExportThreadNum(exportThreadNum);
    }

    public BooleanInterface getExportBackground() {
        return instance.getExportBackground();
    }

    public void setExportBackground(BooleanInterface exportBackground) {
        instance.setExportBackground(exportBackground);
    }

    public ProviderConfig() {
        instance = (ProviderConfigInterface) DubboClassLoader.getInstance(ProviderConfig.class.getName());
    }

    public ProviderConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ProviderConfigInterface) DubboClassLoader.getInstance(ProviderConfig.class.getName(), params, args);
    }
}
