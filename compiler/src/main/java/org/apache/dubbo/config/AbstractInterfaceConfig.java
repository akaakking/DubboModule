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

    public StringInterface getLocal() {
        return instance.getLocal();
    }

    public void setLocal(BooleanInterface local) {
        instance.setLocal(local);
    }

    public void setLocal(StringInterface local) {
        instance.setLocal(local);
    }

    public StringInterface getStub() {
        return instance.getStub();
    }

    public void setStub(BooleanInterface stub) {
        instance.setStub(stub);
    }

    public void setStub(StringInterface stub) {
        instance.setStub(stub);
    }

    public StringInterface getCluster() {
        return instance.getCluster();
    }

    public void setCluster(StringInterface cluster) {
        instance.setCluster(cluster);
    }

    public StringInterface getProxy() {
        return instance.getProxy();
    }

    public void setProxy(StringInterface proxy) {
        instance.setProxy(proxy);
    }

    public IntegerInterface getConnections() {
        return instance.getConnections();
    }

    public void setConnections(IntegerInterface connections) {
        instance.setConnections(connections);
    }

    public StringInterface getFilter() {
        return instance.getFilter();
    }

    public void setFilter(StringInterface filter) {
        instance.setFilter(filter);
    }

    public StringInterface getListener() {
        return instance.getListener();
    }

    public void setListener(StringInterface listener) {
        instance.setListener(listener);
    }

    public StringInterface getLayer() {
        return instance.getLayer();
    }

    public void setLayer(StringInterface layer) {
        instance.setLayer(layer);
    }

    public ApplicationConfigInterface getApplication() {
        return instance.getApplication();
    }

    public void setApplication(ApplicationConfigInterfaceInterface application) {
        instance.setApplication(application);
    }

    public ModuleConfigInterface getModule() {
        return instance.getModule();
    }

    public void setModule(ModuleConfigInterface module) {
        instance.setModule(module);
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterfaceInterface registry) {
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

    public List<MethodConfigInterface> getMethods() {
        return instance.getMethods();
    }

    public void setMethods(List<? extends MethodConfigInterface> methods) {
        instance.setMethods(methods);
    }

    public void addMethod(MethodConfigInterface methodConfig) {
        instance.addMethod(methodConfig);
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

    public StringInterface getOwner() {
        return instance.getOwner();
    }

    public void setOwner(StringInterface owner) {
        instance.setOwner(owner);
    }

    public ConfigCenterConfigInterface getConfigCenter() {
        return instance.getConfigCenter();
    }

    public void setConfigCenter(ConfigCenterConfigInterface configCenter) {
        instance.setConfigCenter(configCenter);
    }

    public IntegerInterface getCallbacks() {
        return instance.getCallbacks();
    }

    public void setCallbacks(IntegerInterface callbacks) {
        instance.setCallbacks(callbacks);
    }

    public StringInterface getOnconnect() {
        return instance.getOnconnect();
    }

    public void setOnconnect(StringInterface onconnect) {
        instance.setOnconnect(onconnect);
    }

    public StringInterface getOndisconnect() {
        return instance.getOndisconnect();
    }

    public void setOndisconnect(StringInterface ondisconnect) {
        instance.setOndisconnect(ondisconnect);
    }

    public StringInterface getScope() {
        return instance.getScope();
    }

    public void setScope(StringInterface scope) {
        instance.setScope(scope);
    }

    public MetadataReportConfigInterface getMetadataReportConfig() {
        return instance.getMetadataReportConfig();
    }

    public void setMetadataReportConfig(MetadataReportConfigInterfaceInterface metadataReportConfig) {
        instance.setMetadataReportConfig(metadataReportConfig);
    }

    public StringInterface getTag() {
        return instance.getTag();
    }

    public void setTag(StringInterface tag) {
        instance.setTag(tag);
    }

    public BooleanInterface getAuth() {
        return instance.getAuth();
    }

    public void setAuth(BooleanInterface auth) {
        instance.setAuth(auth);
    }

    public SslConfigInterface getSslConfig() {
        return instance.getSslConfig();
    }

    public BooleanInterface getSingleton() {
        return instance.getSingleton();
    }

    public void setSingleton(BooleanInterface singleton) {
        instance.setSingleton(singleton);
    }

    public StringInterface getGroup(AbstractInterfaceConfigInterface interfaceConfig) {
        return instance.getGroup(interfaceConfig);
    }

    public StringInterface getVersion(AbstractInterfaceConfigInterface interfaceConfig) {
        return instance.getVersion(interfaceConfig);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public StringInterface getInterface() {
        return instance.getInterface();
    }

    public void setInterface(StringInterface interfaceName) {
        instance.setInterface(interfaceName);
    }

    public ClassLoaderInterface getInterfaceClassLoader() {
        return instance.getInterfaceClassLoader();
    }

    public void setInterfaceClassLoader(ClassLoaderInterface interfaceClassLoader) {
        instance.setInterfaceClassLoader(interfaceClassLoader);
    }

    public static void appendRuntimeParameters(Map<String, String> map) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(appendRuntimeParameters, Map.class);
        method.invoke(map);
    }
}
