package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ApplicationBuilder extends AbstractBuilder<ApplicationConfig, ApplicationBuilder> implements ApplicationBuilderInterface {

    public ApplicationBuilderInterface name(StringInterface name) {
        return instance.name(name);
    }

    public ApplicationBuilderInterface metadata(StringInterface metadata) {
        return instance.metadata(metadata);
    }

    public ApplicationBuilderInterface version(StringInterface version) {
        return instance.version(version);
    }

    public ApplicationBuilderInterface owner(StringInterface owner) {
        return instance.owner(owner);
    }

    public ApplicationBuilderInterface organization(StringInterface organization) {
        return instance.organization(organization);
    }

    public ApplicationBuilderInterface architecture(StringInterface architecture) {
        return instance.architecture(architecture);
    }

    public ApplicationBuilderInterface environment(StringInterface environment) {
        return instance.environment(environment);
    }

    public ApplicationBuilderInterface compiler(StringInterface compiler) {
        return instance.compiler(compiler);
    }

    public ApplicationBuilderInterface logger(StringInterface logger) {
        return instance.logger(logger);
    }

    public ApplicationBuilderInterface addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(registry);
    }

    public ApplicationBuilderInterface addRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public ApplicationBuilderInterface registryIds(StringInterface registryIds) {
        return instance.registryIds(registryIds);
    }

    public ApplicationBuilderInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor);
    }

    public ApplicationBuilderInterface monitor(StringInterface monitor) {
        return instance.monitor(monitor);
    }

    public ApplicationBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public ApplicationBuilderInterface dumpDirectory(StringInterface dumpDirectory) {
        return instance.dumpDirectory(dumpDirectory);
    }

    public ApplicationBuilderInterface qosEnable(BooleanInterface qosEnable) {
        return instance.qosEnable(qosEnable);
    }

    public ApplicationBuilderInterface qosPort(IntegerInterface qosPort) {
        return instance.qosPort(qosPort);
    }

    public ApplicationBuilderInterface qosAcceptForeignIp(BooleanInterface qosAcceptForeignIp) {
        return instance.qosAcceptForeignIp(qosAcceptForeignIp);
    }

    public ApplicationBuilderInterface shutwait(StringInterface shutwait) {
        return instance.shutwait(shutwait);
    }

    public ApplicationBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public ApplicationBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public ApplicationBuilderInterface metadataServicePort(IntegerInterface metadataServicePort) {
        return instance.metadataServicePort(metadataServicePort);
    }

    public ApplicationBuilderInterface livenessProbe(StringInterface livenessProbe) {
        return instance.livenessProbe(livenessProbe);
    }

    public ApplicationBuilderInterface readinessProbe(StringInterface readinessProbe) {
        return instance.readinessProbe(readinessProbe);
    }

    public ApplicationBuilderInterface startupProbe(StringInterface startupProbe) {
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
}
