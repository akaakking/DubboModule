package org.apache.dubbo.config;

import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ApplicationConfig implements ApplicationConfigInterface {

    public String getName() {
        return instance.getName();
    }

    public void setName(String name) {
        instance.setName(name);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getOwner() {
        return instance.getOwner();
    }

    public void setOwner(String owner) {
        instance.setOwner(owner);
    }

    public String getOrganization() {
        return instance.getOrganization();
    }

    public void setOrganization(String organization) {
        instance.setOrganization(organization);
    }

    public String getArchitecture() {
        return instance.getArchitecture();
    }

    public void setArchitecture(String architecture) {
        instance.setArchitecture(architecture);
    }

    public String getEnvironment() {
        return instance.getEnvironment();
    }

    public void setEnvironment(String environment) {
        instance.setEnvironment(environment);
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterface registry) {
        instance.setRegistry(registry);
    }

    public List<RegistryConfig> getRegistries() {
        return instance.getRegistries();
    }

    public void setRegistries(List<? extends RegistryConfig> registries) {
        instance.setRegistries(registries);
    }

    public String getRegistryIds() {
        return instance.getRegistryIds();
    }

    public void setRegistryIds(String registryIds) {
        instance.setRegistryIds(registryIds);
    }

    public MonitorConfigInterface getMonitor() {
        return instance.getMonitor();
    }

    public void setMonitor(String monitor) {
        instance.setMonitor(monitor);
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor);
    }

    public String getCompiler() {
        return instance.getCompiler();
    }

    public void setCompiler(String compiler) {
        instance.setCompiler(compiler);
    }

    public String getLogger() {
        return instance.getLogger();
    }

    public void setLogger(String logger) {
        instance.setLogger(logger);
    }

    public String getDumpDirectory() {
        return instance.getDumpDirectory();
    }

    public void setDumpDirectory(String dumpDirectory) {
        instance.setDumpDirectory(dumpDirectory);
    }

    public Boolean getQosEnable() {
        return instance.getQosEnable();
    }

    public void setQosEnable(Boolean qosEnable) {
        instance.setQosEnable(qosEnable);
    }

    public String getQosHost() {
        return instance.getQosHost();
    }

    public void setQosHost(String qosHost) {
        instance.setQosHost(qosHost);
    }

    public Integer getQosPort() {
        return instance.getQosPort();
    }

    public void setQosPort(Integer qosPort) {
        instance.setQosPort(qosPort);
    }

    public Boolean getQosAcceptForeignIp() {
        return instance.getQosAcceptForeignIp();
    }

    public void setQosAcceptForeignIp(Boolean qosAcceptForeignIp) {
        instance.setQosAcceptForeignIp(qosAcceptForeignIp);
    }

    public Boolean getQosEnableCompatible() {
        return instance.getQosEnableCompatible();
    }

    public void setQosEnableCompatible(Boolean qosEnable) {
        instance.setQosEnableCompatible(qosEnable);
    }

    public String getQosHostCompatible() {
        return instance.getQosHostCompatible();
    }

    public void setQosHostCompatible(String qosHost) {
        instance.setQosHostCompatible(qosHost);
    }

    public Integer getQosPortCompatible() {
        return instance.getQosPortCompatible();
    }

    public void setQosPortCompatible(Integer qosPort) {
        instance.setQosPortCompatible(qosPort);
    }

    public Boolean getQosAcceptForeignIpCompatible() {
        return instance.getQosAcceptForeignIpCompatible();
    }

    public void setQosAcceptForeignIpCompatible(Boolean qosAcceptForeignIp) {
        instance.setQosAcceptForeignIpCompatible(qosAcceptForeignIp);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public String getShutwait() {
        return instance.getShutwait();
    }

    public void setShutwait(String shutwait) {
        instance.setShutwait(shutwait);
    }

    public String getHostname() {
        return instance.getHostname();
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public String getMetadataType() {
        return instance.getMetadataType();
    }

    public void setMetadataType(String metadataType) {
        instance.setMetadataType(metadataType);
    }

    public Boolean getRegisterConsumer() {
        return instance.getRegisterConsumer();
    }

    public void setRegisterConsumer(Boolean registerConsumer) {
        instance.setRegisterConsumer(registerConsumer);
    }

    public String getRepository() {
        return instance.getRepository();
    }

    public void setRepository(String repository) {
        instance.setRepository(repository);
    }

    public Boolean getEnableFileCache() {
        return instance.getEnableFileCache();
    }

    public void setEnableFileCache(Boolean enableFileCache) {
        instance.setEnableFileCache(enableFileCache);
    }

    public String getRegisterMode() {
        return instance.getRegisterMode();
    }

    public void setRegisterMode(String registerMode) {
        instance.setRegisterMode(registerMode);
    }

    public Boolean getEnableEmptyProtection() {
        return instance.getEnableEmptyProtection();
    }

    public void setEnableEmptyProtection(Boolean enableEmptyProtection) {
        instance.setEnableEmptyProtection(enableEmptyProtection);
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public Integer getMetadataServicePort() {
        return instance.getMetadataServicePort();
    }

    public void setMetadataServicePort(Integer metadataServicePort) {
        instance.setMetadataServicePort(metadataServicePort);
    }

    public String getMetadataServiceProtocol() {
        return instance.getMetadataServiceProtocol();
    }

    public void setMetadataServiceProtocol(String metadataServiceProtocol) {
        instance.setMetadataServiceProtocol(metadataServiceProtocol);
    }

    public String getLivenessProbe() {
        return instance.getLivenessProbe();
    }

    public void setLivenessProbe(String livenessProbe) {
        instance.setLivenessProbe(livenessProbe);
    }

    public String getReadinessProbe() {
        return instance.getReadinessProbe();
    }

    public void setReadinessProbe(String readinessProbe) {
        instance.setReadinessProbe(readinessProbe);
    }

    public String getStartupProbe() {
        return instance.getStartupProbe();
    }

    public void setStartupProbe(String startupProbe) {
        instance.setStartupProbe(startupProbe);
    }

    public void refresh() {
        instance.refresh();
    }

    protected ApplicationConfigInterface instance;

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
