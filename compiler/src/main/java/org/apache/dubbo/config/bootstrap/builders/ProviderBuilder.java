package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractServiceBuilder;

public class ProviderBuilder extends AbstractServiceBuilder<ProviderConfig, ProviderBuilder> implements ProviderBuilderInterface {

    public ProviderBuilderInterface host(StringInterface host) {
        return instance.host(host);
    }

    public ProviderBuilderInterface port(IntegerInterface port) {
        return instance.port(port);
    }

    public ProviderBuilderInterface contextPath(StringInterface contextPath) {
        return instance.contextPath(contextPath);
    }

    public ProviderBuilderInterface threadPool(StringInterface threadPool) {
        return instance.threadPool(threadPool);
    }

    public ProviderBuilderInterface threads(IntegerInterface threads) {
        return instance.threads(threads);
    }

    public ProviderBuilderInterface ioThreads(IntegerInterface ioThreads) {
        return instance.ioThreads(ioThreads);
    }

    public ProviderBuilderInterface queues(IntegerInterface queues) {
        return instance.queues(queues);
    }

    public ProviderBuilderInterface accepts(IntegerInterface accepts) {
        return instance.accepts(accepts);
    }

    public ProviderBuilderInterface codec(StringInterface codec) {
        return instance.codec(codec);
    }

    public ProviderBuilderInterface charset(StringInterface charset) {
        return instance.charset(charset);
    }

    public ProviderBuilderInterface payload(IntegerInterface payload) {
        return instance.payload(payload);
    }

    public ProviderBuilderInterface buffer(IntegerInterface buffer) {
        return instance.buffer(buffer);
    }

    public ProviderBuilderInterface transporter(StringInterface transporter) {
        return instance.transporter(transporter);
    }

    public ProviderBuilderInterface exchanger(StringInterface exchanger) {
        return instance.exchanger(exchanger);
    }

    public ProviderBuilderInterface dispatcher(StringInterface dispatcher) {
        return instance.dispatcher(dispatcher);
    }

    public ProviderBuilderInterface networker(StringInterface networker) {
        return instance.networker(networker);
    }

    public ProviderBuilderInterface server(StringInterface server) {
        return instance.server(server);
    }

    public ProviderBuilderInterface client(StringInterface client) {
        return instance.client(client);
    }

    public ProviderBuilderInterface telnet(StringInterface telnet) {
        return instance.telnet(telnet);
    }

    public ProviderBuilderInterface prompt(StringInterface prompt) {
        return instance.prompt(prompt);
    }

    public ProviderBuilderInterface status(StringInterface status) {
        return instance.status(status);
    }

    public ProviderBuilderInterface wait(IntegerInterface wait) {
        return instance.wait(wait);
    }

    public ProviderBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public ProviderConfigInterface build() {
        return instance.build();
    }
}
