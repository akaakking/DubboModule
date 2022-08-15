package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Map;

public interface ApplicationBuilderInterface extends AbstractBuilder{
    ApplicationBuilderInterface newBuilder();
    ApplicationBuilderInterface name(String name);
    ApplicationBuilderInterface metadata(String metadata);
    ApplicationBuilderInterface version(String version);
    ApplicationBuilderInterface owner(String owner);
    ApplicationBuilderInterface organization(String organization);
    ApplicationBuilderInterface architecture(String architecture);
    ApplicationBuilderInterface environment(String environment);
    ApplicationBuilderInterface compiler(String compiler);
    ApplicationBuilderInterface logger(String logger);
    ApplicationBuilderInterface addRegistry(RegistryConfigInterface registry);
    ApplicationBuilderInterface addRegistries(List registries);
    ApplicationBuilderInterface registryIds(String registryIds);
    ApplicationBuilderInterface monitor(MonitorConfigInterface monitor);
    ApplicationBuilderInterface monitor(String monitor);
    ApplicationBuilderInterface isDefault(Boolean isDefault);
    ApplicationBuilderInterface dumpDirectory(String dumpDirectory);
    ApplicationBuilderInterface qosEnable(Boolean qosEnable);
    ApplicationBuilderInterface qosPort(Integer qosPort);
    ApplicationBuilderInterface qosAcceptForeignIp(Boolean qosAcceptForeignIp);
    ApplicationBuilderInterface shutwait(String shutwait);
    ApplicationBuilderInterface appendParameter(String key, String value);
    ApplicationBuilderInterface appendParameters(Map appendParameters);
    ApplicationBuilderInterface metadataServicePort(Integer metadataServicePort);
    ApplicationBuilderInterface livenessProbe(String livenessProbe);
    ApplicationBuilderInterface readinessProbe(String readinessProbe);
    ApplicationBuilderInterface startupProbe(String startupProbe);
    ApplicationConfigInterface build();
}