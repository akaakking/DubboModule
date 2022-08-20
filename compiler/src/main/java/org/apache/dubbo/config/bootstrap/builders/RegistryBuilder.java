package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class RegistryBuilder extends AbstractBuilder<RegistryConfig, RegistryBuilder> implements RegistryBuilderInterface {

    public RegistryBuilderInterface id(StringInterface id) {
        return instance.id(id);
    }

    public RegistryBuilderInterface address(StringInterface address) {
        return instance.address(address);
    }

    public RegistryBuilderInterface username(StringInterface username) {
        return instance.username(username);
    }

    public RegistryBuilderInterface password(StringInterface password) {
        return instance.password(password);
    }

    public RegistryBuilderInterface port(IntegerInterface port) {
        return instance.port(port);
    }

    public RegistryBuilderInterface protocol(StringInterface protocol) {
        return instance.protocol(protocol);
    }

    public RegistryBuilderInterface transporter(StringInterface transporter) {
        return instance.transporter(transporter);
    }

    public RegistryBuilderInterface transport(StringInterface transport) {
        return instance.transport(transport);
    }

    public RegistryBuilderInterface server(StringInterface server) {
        return instance.server(server);
    }

    public RegistryBuilderInterface client(StringInterface client) {
        return instance.client(client);
    }

    public RegistryBuilderInterface cluster(StringInterface cluster) {
        return instance.cluster(cluster);
    }

    public RegistryBuilderInterface group(StringInterface group) {
        return instance.group(group);
    }

    public RegistryBuilderInterface version(StringInterface version) {
        return instance.version(version);
    }

    public RegistryBuilderInterface timeout(IntegerInterface timeout) {
        return instance.timeout(timeout);
    }

    public RegistryBuilderInterface session(IntegerInterface session) {
        return instance.session(session);
    }

    public RegistryBuilderInterface file(StringInterface file) {
        return instance.file(file);
    }

    public RegistryBuilderInterface wait(IntegerInterface wait) {
        return instance.wait(wait);
    }

    public RegistryBuilderInterface isCheck(BooleanInterface check) {
        return instance.isCheck(check);
    }

    public RegistryBuilderInterface isDynamic(BooleanInterface dynamic) {
        return instance.isDynamic(dynamic);
    }

    public RegistryBuilderInterface register(BooleanInterface register) {
        return instance.register(register);
    }

    public RegistryBuilderInterface subscribe(BooleanInterface subscribe) {
        return instance.subscribe(subscribe);
    }

    public RegistryBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public RegistryBuilderInterface parameter(StringInterface name, StringInterface value) {
        return instance.parameter(name, value);
    }

    public RegistryBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public RegistryBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public RegistryBuilderInterface simplified(BooleanInterface simplified) {
        return instance.simplified(simplified);
    }

    public RegistryBuilderInterface extraKeys(StringInterface extraKeys) {
        return instance.extraKeys(extraKeys);
    }

    public RegistryBuilderInterface useAsConfigCenter(BooleanInterface useAsConfigCenter) {
        return instance.useAsConfigCenter(useAsConfigCenter);
    }

    public RegistryBuilderInterface useAsMetadataCenter(BooleanInterface useAsMetadataCenter) {
        return instance.useAsMetadataCenter(useAsMetadataCenter);
    }

    public RegistryBuilderInterface preferred(BooleanInterface preferred) {
        return instance.preferred(preferred);
    }

    public RegistryBuilderInterface accepts(StringInterface accepts) {
        return instance.accepts(accepts);
    }

    public RegistryBuilderInterface weight(IntegerInterface weight) {
        return instance.weight(weight);
    }

    public RegistryConfigInterface build() {
        return instance.build();
    }

    public static RegistryBuilderInterface newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }
}
