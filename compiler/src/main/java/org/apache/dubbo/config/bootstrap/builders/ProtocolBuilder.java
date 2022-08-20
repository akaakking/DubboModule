package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ProtocolBuilder extends AbstractBuilder<ProtocolConfig, ProtocolBuilder> implements ProtocolBuilderInterface {

    public ProtocolBuilderInterface id(StringInterface id) {
        return instance.id(id);
    }

    public ProtocolBuilderInterface name(StringInterface name) {
        return instance.name(name);
    }

    public ProtocolBuilderInterface host(StringInterface host) {
        return instance.host(host);
    }

    public ProtocolBuilderInterface port(IntegerInterface port) {
        return instance.port(port);
    }

    public ProtocolBuilderInterface contextpath(StringInterface contextpath) {
        return instance.contextpath(contextpath);
    }

    public ProtocolBuilderInterface path(StringInterface path) {
        return instance.path(path);
    }

    public ProtocolBuilderInterface threadpool(StringInterface threadpool) {
        return instance.threadpool(threadpool);
    }

    public ProtocolBuilderInterface corethreads(IntegerInterface corethreads) {
        return instance.corethreads(corethreads);
    }

    public ProtocolBuilderInterface threads(IntegerInterface threads) {
        return instance.threads(threads);
    }

    public ProtocolBuilderInterface iothreads(IntegerInterface iothreads) {
        return instance.iothreads(iothreads);
    }

    public ProtocolBuilderInterface queues(IntegerInterface queues) {
        return instance.queues(queues);
    }

    public ProtocolBuilderInterface accepts(IntegerInterface accepts) {
        return instance.accepts(accepts);
    }

    public ProtocolBuilderInterface codec(StringInterface codec) {
        return instance.codec(codec);
    }

    public ProtocolBuilderInterface serialization(StringInterface serialization) {
        return instance.serialization(serialization);
    }

    public ProtocolBuilderInterface charset(StringInterface charset) {
        return instance.charset(charset);
    }

    public ProtocolBuilderInterface payload(IntegerInterface payload) {
        return instance.payload(payload);
    }

    public ProtocolBuilderInterface buffer(IntegerInterface buffer) {
        return instance.buffer(buffer);
    }

    public ProtocolBuilderInterface heartbeat(IntegerInterface heartbeat) {
        return instance.heartbeat(heartbeat);
    }

    public ProtocolBuilderInterface accesslog(StringInterface accesslog) {
        return instance.accesslog(accesslog);
    }

    public ProtocolBuilderInterface transporter(StringInterface transporter) {
        return instance.transporter(transporter);
    }

    public ProtocolBuilderInterface exchanger(StringInterface exchanger) {
        return instance.exchanger(exchanger);
    }

    public ProtocolBuilderInterface dispatcher(StringInterface dispatcher) {
        return instance.dispatcher(dispatcher);
    }

    public ProtocolBuilderInterface dispather(StringInterface dispather) {
        return instance.dispather(dispather);
    }

    public ProtocolBuilderInterface networker(StringInterface networker) {
        return instance.networker(networker);
    }

    public ProtocolBuilderInterface server(StringInterface server) {
        return instance.server(server);
    }

    public ProtocolBuilderInterface client(StringInterface client) {
        return instance.client(client);
    }

    public ProtocolBuilderInterface telnet(StringInterface telnet) {
        return instance.telnet(telnet);
    }

    public ProtocolBuilderInterface prompt(StringInterface prompt) {
        return instance.prompt(prompt);
    }

    public ProtocolBuilderInterface status(StringInterface status) {
        return instance.status(status);
    }

    public ProtocolBuilderInterface register(BooleanInterface register) {
        return instance.register(register);
    }

    public ProtocolBuilderInterface keepAlive(BooleanInterface keepAlive) {
        return instance.keepAlive(keepAlive);
    }

    public ProtocolBuilderInterface optimizer(StringInterface optimizer) {
        return instance.optimizer(optimizer);
    }

    public ProtocolBuilderInterface extension(StringInterface extension) {
        return instance.extension(extension);
    }

    public ProtocolBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public ProtocolBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ProtocolBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public ProtocolConfigInterface build() {
        return instance.build();
    }

    public static ProtocolBuilderInterface newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }
}
