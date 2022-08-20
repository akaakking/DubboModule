package org.apache.dubbo.config;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ApplicationConfig extends AbstractConfig implements ApplicationConfigInterface {

    public StringInterface getName() {
        return instance.getName();
    }

    public void setName(StringInterface name) {
        instance.setName(name);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public StringInterface getOwner() {
        return instance.getOwner();
    }

    public void setOwner(StringInterface owner) {
        instance.setOwner(owner);
    }

    public StringInterface getOrganization() {
        return instance.getOrganization();
    }

    public void setOrganization(StringInterface organization) {
        instance.setOrganization(organization);
    }

    public StringInterface getArchitecture() {
        return instance.getArchitecture();
    }

    public void setArchitecture(StringInterface architecture) {
        instance.setArchitecture(architecture);
    }

    public StringInterface getEnvironment() {
        return instance.getEnvironment();
    }

    public void setEnvironment(StringInterface environment) {
        instance.setEnvironment(environment);
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterface registry) {
        instance.setRegistry(registry);
    }

    public List<RegistryConfigInterface> getRegistries() {
        return instance.getRegistries();
    }

    public void setRegistries(List<? extends RegistryConfigInterface> registries) {
        instance.setRegistries(registries);
    }

    public StringInterface getRegistryIds() {
        return instance.getRegistryIds();
    }

    public void setRegistryIds(StringInterface registryIds) {
        instance.setRegistryIds(registryIds);
    }

    public MonitorConfigInterface getMonitor() {
        return instance.getMonitor();
    }

    public void setMonitor(StringInterface monitor) {
        instance.setMonitor(monitor);
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor);
    }

    public StringInterface getCompiler() {
        return instance.getCompiler();
    }

    public void setCompiler(StringInterface compiler) {
        instance.setCompiler(compiler);
    }

    public StringInterface getLogger() {
        return instance.getLogger();
    }

    public void setLogger(StringInterface logger) {
        instance.setLogger(logger);
    }

    public StringInterface getDumpDirectory() {
        return instance.getDumpDirectory();
    }

    public void setDumpDirectory(StringInterface dumpDirectory) {
        instance.setDumpDirectory(dumpDirectory);
    }

    public BooleanInterface getQosEnable() {
        return instance.getQosEnable();
    }

    public void setQosEnable(BooleanInterface qosEnable) {
        instance.setQosEnable(qosEnable);
    }

    public StringInterface getQosHost() {
        return instance.getQosHost();
    }

    public void setQosHost(StringInterface qosHost) {
        instance.setQosHost(qosHost);
    }

    public IntegerInterface getQosPort() {
        return instance.getQosPort();
    }

    public void setQosPort(IntegerInterface qosPort) {
        instance.setQosPort(qosPort);
    }

    public BooleanInterface getQosAcceptForeignIp() {
        return instance.getQosAcceptForeignIp();
    }

    public void setQosAcceptForeignIp(BooleanInterface qosAcceptForeignIp) {
        instance.setQosAcceptForeignIp(qosAcceptForeignIp);
    }

    public BooleanInterface getQosEnableCompatible() {
        return instance.getQosEnableCompatible();
    }

    public void setQosEnableCompatible(BooleanInterface qosEnable) {
        instance.setQosEnableCompatible(qosEnable);
    }

    public StringInterface getQosHostCompatible() {
        return instance.getQosHostCompatible();
    }

    public void setQosHostCompatible(StringInterface qosHost) {
        instance.setQosHostCompatible(qosHost);
    }

    public IntegerInterface getQosPortCompatible() {
        return instance.getQosPortCompatible();
    }

    public void setQosPortCompatible(IntegerInterface qosPort) {
        instance.setQosPortCompatible(qosPort);
    }

    public BooleanInterface getQosAcceptForeignIpCompatible() {
        return instance.getQosAcceptForeignIpCompatible();
    }

    public void setQosAcceptForeignIpCompatible(BooleanInterface qosAcceptForeignIp) {
        instance.setQosAcceptForeignIpCompatible(qosAcceptForeignIp);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public StringInterface getShutwait() {
        return instance.getShutwait();
    }

    public void setShutwait(StringInterface shutwait) {
        instance.setShutwait(shutwait);
    }

    public StringInterface getHostname() {
        return instance.getHostname();
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public StringInterface getMetadataType() {
        return instance.getMetadataType();
    }

    public void setMetadataType(StringInterface metadataType) {
        instance.setMetadataType(metadataType);
    }

    public BooleanInterface getRegisterConsumer() {
        return instance.getRegisterConsumer();
    }

    public void setRegisterConsumer(BooleanInterface registerConsumer) {
        instance.setRegisterConsumer(registerConsumer);
    }

    public StringInterface getRepository() {
        return instance.getRepository();
    }

    public void setRepository(StringInterface repository) {
        instance.setRepository(repository);
    }

    public BooleanInterface getEnableFileCache() {
        return instance.getEnableFileCache();
    }

    public void setEnableFileCache(BooleanInterface enableFileCache) {
        instance.setEnableFileCache(enableFileCache);
    }

    public StringInterface getRegisterMode() {
        return instance.getRegisterMode();
    }

    public void setRegisterMode(StringInterface registerMode) {
        instance.setRegisterMode(registerMode);
    }

    public BooleanInterface getEnableEmptyProtection() {
        return instance.getEnableEmptyProtection();
    }

    public void setEnableEmptyProtection(BooleanInterface enableEmptyProtection) {
        instance.setEnableEmptyProtection(enableEmptyProtection);
    }

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
    }

    public IntegerInterface getMetadataServicePort() {
        return instance.getMetadataServicePort();
    }

    public void setMetadataServicePort(IntegerInterface metadataServicePort) {
        instance.setMetadataServicePort(metadataServicePort);
    }

    public StringInterface getMetadataServiceProtocol() {
        return instance.getMetadataServiceProtocol();
    }

    public void setMetadataServiceProtocol(StringInterface metadataServiceProtocol) {
        instance.setMetadataServiceProtocol(metadataServiceProtocol);
    }

    public StringInterface getLivenessProbe() {
        return instance.getLivenessProbe();
    }

    public void setLivenessProbe(StringInterface livenessProbe) {
        instance.setLivenessProbe(livenessProbe);
    }

    public StringInterface getReadinessProbe() {
        return instance.getReadinessProbe();
    }

    public void setReadinessProbe(StringInterface readinessProbe) {
        instance.setReadinessProbe(readinessProbe);
    }

    public StringInterface getStartupProbe() {
        return instance.getStartupProbe();
    }

    public void setStartupProbe(StringInterface startupProbe) {
        instance.setStartupProbe(startupProbe);
    }

    public void refresh() {
        instance.refresh();
    }

    public ApplicationConfig() {
        instance = (ApplicationConfigInterface) DubboClassLoader.getInstance(ApplicationConfig.class.getName());
    }

    public ApplicationConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ApplicationConfigInterface) DubboClassLoader.getInstance(ApplicationConfig.class.getName(), params, args);
    }

    public ApplicationConfig(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (ApplicationConfigInterface) DubboClassLoader.getInstance(ApplicationConfig.class.getName(), params, args);
    }

    public ApplicationConfig(ApplicationModelInterface applicationModel, String name) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, name};
        instance = (ApplicationConfigInterface) DubboClassLoader.getInstance(ApplicationConfig.class.getName(), params, args);
    }
}
