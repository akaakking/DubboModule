package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ApplicationBuilder extends AbstractBuilder<ApplicationConfig, ApplicationBuilder> implements ApplicationBuilderInterface {

    public ApplicationBuilderInterface name(String name) {
        return instance.name(name);
    }

    public ApplicationBuilderInterface metadata(String metadata) {
        return instance.metadata(metadata);
    }

    public ApplicationBuilderInterface version(String version) {
        return instance.version(version);
    }

    public ApplicationBuilderInterface owner(String owner) {
        return instance.owner(owner);
    }

    public ApplicationBuilderInterface organization(String organization) {
        return instance.organization(organization);
    }

    public ApplicationBuilderInterface architecture(String architecture) {
        return instance.architecture(architecture);
    }

    public ApplicationBuilderInterface environment(String environment) {
        return instance.environment(environment);
    }

    public ApplicationBuilderInterface compiler(String compiler) {
        return instance.compiler(compiler);
    }

    public ApplicationBuilderInterface logger(String logger) {
        return instance.logger(logger);
    }

    public ApplicationBuilderInterface addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(registry.getInternalInstance(), registry);
    }

    public ApplicationBuilderInterface addRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public ApplicationBuilderInterface registryIds(String registryIds) {
        return instance.registryIds(registryIds);
    }

    public ApplicationBuilderInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor.getInternalInstance(), monitor);
    }

    public ApplicationBuilderInterface monitor(String monitor) {
        return instance.monitor(monitor);
    }

    public ApplicationBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public ApplicationBuilderInterface dumpDirectory(String dumpDirectory) {
        return instance.dumpDirectory(dumpDirectory);
    }

    public ApplicationBuilderInterface qosEnable(Boolean qosEnable) {
        return instance.qosEnable(qosEnable);
    }

    public ApplicationBuilderInterface qosPort(Integer qosPort) {
        return instance.qosPort(qosPort);
    }

    public ApplicationBuilderInterface qosAcceptForeignIp(Boolean qosAcceptForeignIp) {
        return instance.qosAcceptForeignIp(qosAcceptForeignIp);
    }

    public ApplicationBuilderInterface shutwait(String shutwait) {
        return instance.shutwait(shutwait);
    }

    public ApplicationBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public ApplicationBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ApplicationBuilderInterface metadataServicePort(Integer metadataServicePort) {
        return instance.metadataServicePort(metadataServicePort);
    }

    public ApplicationBuilderInterface livenessProbe(String livenessProbe) {
        return instance.livenessProbe(livenessProbe);
    }

    public ApplicationBuilderInterface readinessProbe(String readinessProbe) {
        return instance.readinessProbe(readinessProbe);
    }

    public ApplicationBuilderInterface startupProbe(String startupProbe) {
        return instance.startupProbe(startupProbe);
    }

    public ApplicationConfigInterface build() {
        return instance.build();
    }

    public static ApplicationBuilderInterface newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }

    public ApplicationBuilderInterface getInternalInstance() {
        return instance;
    }

    public ApplicationBuilderInterface getInternalInstance() {
        return instance;
    }
}
