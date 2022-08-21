package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class RegistryBuilder extends AbstractBuilder<RegistryConfig, RegistryBuilder> implements RegistryBuilderInterface {

    public RegistryBuilderInterface id(String id) {
        return instance.id(id);
    }

    public RegistryBuilderInterface address(String address) {
        return instance.address(address);
    }

    public RegistryBuilderInterface username(String username) {
        return instance.username(username);
    }

    public RegistryBuilderInterface password(String password) {
        return instance.password(password);
    }

    public RegistryBuilderInterface port(Integer port) {
        return instance.port(port);
    }

    public RegistryBuilderInterface protocol(String protocol) {
        return instance.protocol(protocol);
    }

    public RegistryBuilderInterface transporter(String transporter) {
        return instance.transporter(transporter);
    }

    public RegistryBuilderInterface transport(String transport) {
        return instance.transport(transport);
    }

    public RegistryBuilderInterface server(String server) {
        return instance.server(server);
    }

    public RegistryBuilderInterface client(String client) {
        return instance.client(client);
    }

    public RegistryBuilderInterface cluster(String cluster) {
        return instance.cluster(cluster);
    }

    public RegistryBuilderInterface group(String group) {
        return instance.group(group);
    }

    public RegistryBuilderInterface version(String version) {
        return instance.version(version);
    }

    public RegistryBuilderInterface timeout(Integer timeout) {
        return instance.timeout(timeout);
    }

    public RegistryBuilderInterface session(Integer session) {
        return instance.session(session);
    }

    public RegistryBuilderInterface file(String file) {
        return instance.file(file);
    }

    public RegistryBuilderInterface wait(Integer wait) {
        return instance.wait(wait);
    }

    public RegistryBuilderInterface isCheck(Boolean check) {
        return instance.isCheck(check);
    }

    public RegistryBuilderInterface isDynamic(Boolean dynamic) {
        return instance.isDynamic(dynamic);
    }

    public RegistryBuilderInterface register(Boolean register) {
        return instance.register(register);
    }

    public RegistryBuilderInterface subscribe(Boolean subscribe) {
        return instance.subscribe(subscribe);
    }

    public RegistryBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public RegistryBuilderInterface parameter(String name, String value) {
        return instance.parameter(name, value);
    }

    public RegistryBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public RegistryBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public RegistryBuilderInterface simplified(Boolean simplified) {
        return instance.simplified(simplified);
    }

    public RegistryBuilderInterface extraKeys(String extraKeys) {
        return instance.extraKeys(extraKeys);
    }

    public RegistryBuilderInterface useAsConfigCenter(Boolean useAsConfigCenter) {
        return instance.useAsConfigCenter(useAsConfigCenter);
    }

    public RegistryBuilderInterface useAsMetadataCenter(Boolean useAsMetadataCenter) {
        return instance.useAsMetadataCenter(useAsMetadataCenter);
    }

    public RegistryBuilderInterface preferred(Boolean preferred) {
        return instance.preferred(preferred);
    }

    public RegistryBuilderInterface accepts(String accepts) {
        return instance.accepts(accepts);
    }

    public RegistryBuilderInterface weight(Integer weight) {
        return instance.weight(weight);
    }

    public RegistryConfigInterface build() {
        return instance.build();
    }

    protected RegistryBuilderInterface instance;

    public static RegistryBuilderInterface newBuilder() {
        Class klass = DubboClassLoader.getKlass(RegistryBuilder.class.getName());
        Method method = klass.getMethod("newBuilder");
        return method.invoke();
    }

    public RegistryBuilderInterface getInternalInstance() {
        return instance;
    }

    protected RegistryBuilder() {
        instance = (RegistryBuilderInterface) DubboClassLoader.getInstance(RegistryBuilder.class.getName());
        super.instance = instance;
    }
}
