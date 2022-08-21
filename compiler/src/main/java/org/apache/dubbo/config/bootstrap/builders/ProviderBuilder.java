package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractServiceBuilder;

public class ProviderBuilder extends AbstractServiceBuilder<ProviderConfig, ProviderBuilder> implements ProviderBuilderInterface {

    public ProviderBuilderInterface host(String host) {
        return instance.host(host);
    }

    public ProviderBuilderInterface port(Integer port) {
        return instance.port(port);
    }

    public ProviderBuilderInterface contextPath(String contextPath) {
        return instance.contextPath(contextPath);
    }

    public ProviderBuilderInterface threadPool(String threadPool) {
        return instance.threadPool(threadPool);
    }

    public ProviderBuilderInterface threads(Integer threads) {
        return instance.threads(threads);
    }

    public ProviderBuilderInterface ioThreads(Integer ioThreads) {
        return instance.ioThreads(ioThreads);
    }

    public ProviderBuilderInterface queues(Integer queues) {
        return instance.queues(queues);
    }

    public ProviderBuilderInterface accepts(Integer accepts) {
        return instance.accepts(accepts);
    }

    public ProviderBuilderInterface codec(String codec) {
        return instance.codec(codec);
    }

    public ProviderBuilderInterface charset(String charset) {
        return instance.charset(charset);
    }

    public ProviderBuilderInterface payload(Integer payload) {
        return instance.payload(payload);
    }

    public ProviderBuilderInterface buffer(Integer buffer) {
        return instance.buffer(buffer);
    }

    public ProviderBuilderInterface transporter(String transporter) {
        return instance.transporter(transporter);
    }

    public ProviderBuilderInterface exchanger(String exchanger) {
        return instance.exchanger(exchanger);
    }

    public ProviderBuilderInterface dispatcher(String dispatcher) {
        return instance.dispatcher(dispatcher);
    }

    public ProviderBuilderInterface networker(String networker) {
        return instance.networker(networker);
    }

    public ProviderBuilderInterface server(String server) {
        return instance.server(server);
    }

    public ProviderBuilderInterface client(String client) {
        return instance.client(client);
    }

    public ProviderBuilderInterface telnet(String telnet) {
        return instance.telnet(telnet);
    }

    public ProviderBuilderInterface prompt(String prompt) {
        return instance.prompt(prompt);
    }

    public ProviderBuilderInterface status(String status) {
        return instance.status(status);
    }

    public ProviderBuilderInterface wait(Integer wait) {
        return instance.wait(wait);
    }

    public ProviderBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public ProviderConfigInterface build() {
        return instance.build();
    }

    public ProviderBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ProviderBuilder() {
        instance = (ProviderBuilderInterface) DubboClassLoader.getInstance(ProviderBuilder.class.getName());
        super.instance = instance;
    }
}
