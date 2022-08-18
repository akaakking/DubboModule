package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractServiceBuilder<T extends AbstractServiceConfigInterface, B extends AbstractServiceBuilderInterface<T,B>> implements AbstractServiceBuilderInterface<T, B> {

    public B version(String version) {
        return instance.version(version);
    }

    public B group(String group) {
        return instance.group(group);
    }

    public B deprecated(Boolean deprecated) {
        return instance.deprecated(deprecated);
    }

    public B delay(Integer delay) {
        return instance.delay(delay);
    }

    public B export(Boolean export) {
        return instance.export(export);
    }

    public B weight(Integer weight) {
        return instance.weight(weight);
    }

    public B document(String document) {
        return instance.document(document);
    }

    public B dynamic(Boolean dynamic) {
        return instance.dynamic(dynamic);
    }

    public B token(String token) {
        return instance.token(token);
    }

    public B token(Boolean token) {
        return instance.token(token);
    }

    public B accesslog(String accesslog) {
        return instance.accesslog(accesslog);
    }

    public B accesslog(Boolean accesslog) {
        return instance.accesslog(accesslog);
    }

    public B addProtocols(List<ProtocolConfig> protocols) {
        return instance.addProtocols(protocols);
    }

    public B addProtocol(ProtocolConfigInterface protocol) {
        return instance.addProtocol(protocol);
    }

    public B protocolIds(String protocolIds) {
        return instance.protocolIds(protocolIds);
    }

    public B executes(Integer executes) {
        return instance.executes(executes);
    }

    public B register(Boolean register) {
        return instance.register(register);
    }

    public B warmup(Integer warmup) {
        return instance.warmup(warmup);
    }

    public B serialization(String serialization) {
        return instance.serialization(serialization);
    }

    public void build(T instance) {
        instance.build(instance);
    }

    protected AbstractServiceBuilderInterface instance;
}
