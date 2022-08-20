package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractInterfaceBuilder;

public class AbstractServiceBuilder<T extends AbstractServiceConfigInterface, B extends AbstractServiceBuilderInterface<T,B>> extends AbstractInterfaceBuilder<T, B> implements AbstractServiceBuilderInterface<T, B> {

    public B version(StringInterface version) {
        return instance.version(version);
    }

    public B group(StringInterface group) {
        return instance.group(group);
    }

    public B deprecated(BooleanInterface deprecated) {
        return instance.deprecated(deprecated);
    }

    public B delay(IntegerInterface delay) {
        return instance.delay(delay);
    }

    public B export(BooleanInterface export) {
        return instance.export(export);
    }

    public B weight(IntegerInterface weight) {
        return instance.weight(weight);
    }

    public B document(StringInterface document) {
        return instance.document(document);
    }

    public B dynamic(BooleanInterface dynamic) {
        return instance.dynamic(dynamic);
    }

    public B token(StringInterface token) {
        return instance.token(token);
    }

    public B token(BooleanInterface token) {
        return instance.token(token);
    }

    public B accesslog(StringInterface accesslog) {
        return instance.accesslog(accesslog);
    }

    public B accesslog(BooleanInterface accesslog) {
        return instance.accesslog(accesslog);
    }

    public B addProtocols(List<ProtocolConfigInterface> protocols) {
        return instance.addProtocols(protocols);
    }

    public B addProtocol(ProtocolConfigInterface protocol) {
        return instance.addProtocol(protocol);
    }

    public B protocolIds(StringInterface protocolIds) {
        return instance.protocolIds(protocolIds);
    }

    public B executes(IntegerInterface executes) {
        return instance.executes(executes);
    }

    public B register(BooleanInterface register) {
        return instance.register(register);
    }

    public B warmup(IntegerInterface warmup) {
        return instance.warmup(warmup);
    }

    public B serialization(StringInterface serialization) {
        return instance.serialization(serialization);
    }

    public void build(T instance) {
        instance.build(instance);
    }
}
