package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractMethodConfig;
import java.util.Map;

public class AbstractInterfaceConfig extends AbstractMethodConfig implements AbstractInterfaceConfigInterface {

    public List<URLInterface> getExportedUrls() {
        return instance.getExportedUrls();
    }

    public URLInterface toUrl() {
        return instance.toUrl();
    }

    public List<URLInterface> toUrls() {
        return instance.toUrls();
    }

    public String getLocal() {
        return instance.getLocal();
    }

    public void setLocal(Boolean local) {
        instance.setLocal(local);
    }

    public void setLocal(String local) {
        instance.setLocal(local);
    }

    public String getStub() {
        return instance.getStub();
    }

    public void setStub(Boolean stub) {
        instance.setStub(stub);
    }

    public void setStub(String stub) {
        instance.setStub(stub);
    }

    public String getCluster() {
        return instance.getCluster();
    }

    public void setCluster(String cluster) {
        instance.setCluster(cluster);
    }

    public String getProxy() {
        return instance.getProxy();
    }

    public void setProxy(String proxy) {
        instance.setProxy(proxy);
    }

    public Integer getConnections() {
        return instance.getConnections();
    }

    public void setConnections(Integer connections) {
        instance.setConnections(connections);
    }

    public String getFilter() {
        return instance.getFilter();
    }

    public void setFilter(String filter) {
        instance.setFilter(filter);
    }

    public String getListener() {
        return instance.getListener();
    }

    public void setListener(String listener) {
        instance.setListener(listener);
    }

    public String getLayer() {
        return instance.getLayer();
    }

    public void setLayer(String layer) {
        instance.setLayer(layer);
    }

    public ApplicationConfigInterface getApplication() {
        return instance.getApplication();
    }

    public void setApplication(ApplicationConfigInterfaceInterface application) {
        instance.setApplication(application.getInternalInstance());
    }

    public ModuleConfigInterface getModule() {
        return instance.getModule();
    }

    public void setModule(ModuleConfigInterface module) {
        instance.setModule(module.getInternalInstance());
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterfaceInterface registry) {
        instance.setRegistry(registry.getInternalInstance());
    }

    public List<RegistryConfigInterface> getRegistries() {
        return instance.getRegistries();
    }

    public void setRegistries(List<? extends RegistryConfigInterface> registries) {
        instance.setRegistries(registries);
    }

    public String getRegistryIds() {
        return instance.getRegistryIds();
    }

    public void setRegistryIds(String registryIds) {
        instance.setRegistryIds(registryIds);
    }

    public List<MethodConfigInterface> getMethods() {
        return instance.getMethods();
    }

    public void setMethods(List<? extends MethodConfigInterface> methods) {
        instance.setMethods(methods);
    }

    public void addMethod(MethodConfigInterface methodConfig) {
        instance.addMethod(methodConfig.getInternalInstance());
    }

    public MonitorConfigInterface getMonitor() {
        return instance.getMonitor();
    }

    public void setMonitor(String monitor) {
        instance.setMonitor(monitor);
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor.getInternalInstance());
    }

    public String getOwner() {
        return instance.getOwner();
    }

    public void setOwner(String owner) {
        instance.setOwner(owner);
    }

    public ConfigCenterConfigInterface getConfigCenter() {
        return instance.getConfigCenter();
    }

    public void setConfigCenter(ConfigCenterConfigInterface configCenter) {
        instance.setConfigCenter(configCenter.getInternalInstance());
    }

    public Integer getCallbacks() {
        return instance.getCallbacks();
    }

    public void setCallbacks(Integer callbacks) {
        instance.setCallbacks(callbacks);
    }

    public String getOnconnect() {
        return instance.getOnconnect();
    }

    public void setOnconnect(String onconnect) {
        instance.setOnconnect(onconnect);
    }

    public String getOndisconnect() {
        return instance.getOndisconnect();
    }

    public void setOndisconnect(String ondisconnect) {
        instance.setOndisconnect(ondisconnect);
    }

    public String getScope() {
        return instance.getScope();
    }

    public void setScope(String scope) {
        instance.setScope(scope);
    }

    public MetadataReportConfigInterface getMetadataReportConfig() {
        return instance.getMetadataReportConfig();
    }

    public void setMetadataReportConfig(MetadataReportConfigInterfaceInterface metadataReportConfig) {
        instance.setMetadataReportConfig(metadataReportConfig.getInternalInstance());
    }

    public String getTag() {
        return instance.getTag();
    }

    public void setTag(String tag) {
        instance.setTag(tag);
    }

    public Boolean getAuth() {
        return instance.getAuth();
    }

    public void setAuth(Boolean auth) {
        instance.setAuth(auth);
    }

    public SslConfigInterface getSslConfig() {
        return instance.getSslConfig();
    }

    public Boolean getSingleton() {
        return instance.getSingleton();
    }

    public void setSingleton(Boolean singleton) {
        instance.setSingleton(singleton);
    }

    public String getGroup(AbstractInterfaceConfigInterface interfaceConfig) {
        return instance.getGroup(interfaceConfig.getInternalInstance());
    }

    public String getVersion(AbstractInterfaceConfigInterface interfaceConfig) {
        return instance.getVersion(interfaceConfig.getInternalInstance());
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public String getInterface() {
        return instance.getInterface();
    }

    public void setInterface(String interfaceName) {
        instance.setInterface(interfaceName);
    }

    public ClassLoader getInterfaceClassLoader() {
        return instance.getInterfaceClassLoader();
    }

    public void setInterfaceClassLoader(ClassLoader interfaceClassLoader) {
        instance.setInterfaceClassLoader(interfaceClassLoader);
    }

    public static void appendRuntimeParameters(Map<String, String> map) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendRuntimeParameters, Map.class);
        method.invoke(map);
    }

    public AbstractInterfaceConfigInterface getInternalInstance() {
        return instance;
    }
}
