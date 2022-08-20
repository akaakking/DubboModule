package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ProtocolBuilder extends AbstractBuilder<ProtocolConfig, ProtocolBuilder> implements ProtocolBuilderInterface {

    public ProtocolBuilderInterface id(String id) {
        return instance.id(id);
    }

    public ProtocolBuilderInterface name(String name) {
        return instance.name(name);
    }

    public ProtocolBuilderInterface host(String host) {
        return instance.host(host);
    }

    public ProtocolBuilderInterface port(Integer port) {
        return instance.port(port);
    }

    public ProtocolBuilderInterface contextpath(String contextpath) {
        return instance.contextpath(contextpath);
    }

    public ProtocolBuilderInterface path(String path) {
        return instance.path(path);
    }

    public ProtocolBuilderInterface threadpool(String threadpool) {
        return instance.threadpool(threadpool);
    }

    public ProtocolBuilderInterface corethreads(Integer corethreads) {
        return instance.corethreads(corethreads);
    }

    public ProtocolBuilderInterface threads(Integer threads) {
        return instance.threads(threads);
    }

    public ProtocolBuilderInterface iothreads(Integer iothreads) {
        return instance.iothreads(iothreads);
    }

    public ProtocolBuilderInterface queues(Integer queues) {
        return instance.queues(queues);
    }

    public ProtocolBuilderInterface accepts(Integer accepts) {
        return instance.accepts(accepts);
    }

    public ProtocolBuilderInterface codec(String codec) {
        return instance.codec(codec);
    }

    public ProtocolBuilderInterface serialization(String serialization) {
        return instance.serialization(serialization);
    }

    public ProtocolBuilderInterface charset(String charset) {
        return instance.charset(charset);
    }

    public ProtocolBuilderInterface payload(Integer payload) {
        return instance.payload(payload);
    }

    public ProtocolBuilderInterface buffer(Integer buffer) {
        return instance.buffer(buffer);
    }

    public ProtocolBuilderInterface heartbeat(Integer heartbeat) {
        return instance.heartbeat(heartbeat);
    }

    public ProtocolBuilderInterface accesslog(String accesslog) {
        return instance.accesslog(accesslog);
    }

    public ProtocolBuilderInterface transporter(String transporter) {
        return instance.transporter(transporter);
    }

    public ProtocolBuilderInterface exchanger(String exchanger) {
        return instance.exchanger(exchanger);
    }

    public ProtocolBuilderInterface dispatcher(String dispatcher) {
        return instance.dispatcher(dispatcher);
    }

    public ProtocolBuilderInterface dispather(String dispather) {
        return instance.dispather(dispather);
    }

    public ProtocolBuilderInterface networker(String networker) {
        return instance.networker(networker);
    }

    public ProtocolBuilderInterface server(String server) {
        return instance.server(server);
    }

    public ProtocolBuilderInterface client(String client) {
        return instance.client(client);
    }

    public ProtocolBuilderInterface telnet(String telnet) {
        return instance.telnet(telnet);
    }

    public ProtocolBuilderInterface prompt(String prompt) {
        return instance.prompt(prompt);
    }

    public ProtocolBuilderInterface status(String status) {
        return instance.status(status);
    }

    public ProtocolBuilderInterface register(Boolean register) {
        return instance.register(register);
    }

    public ProtocolBuilderInterface keepAlive(Boolean keepAlive) {
        return instance.keepAlive(keepAlive);
    }

    public ProtocolBuilderInterface optimizer(String optimizer) {
        return instance.optimizer(optimizer);
    }

    public ProtocolBuilderInterface extension(String extension) {
        return instance.extension(extension);
    }

    public ProtocolBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public ProtocolBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ProtocolBuilderInterface isDefault(Boolean isDefault) {
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

    public ProtocolBuilderInterface getInternalInstance() {
        return instance;
    }

    public ProtocolBuilderInterface getInternalInstance() {
        return instance;
    }
}
