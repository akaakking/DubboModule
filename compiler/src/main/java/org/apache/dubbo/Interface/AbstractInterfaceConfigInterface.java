package org.apache.dubbo.Interface;

import java.util.List;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.MetadataReportConfigInterface;
import java.util.Map;
import org.apache.dubbo.Interface.ApplicationConfigInterface;
import org.apache.dubbo.Interface.RegistryConfigInterface;

public interface AbstractInterfaceConfigInterface {
    List getExportedUrls();
    URL toUrl();
    List toUrls();
    void appendRuntimeParameters(Map map);
    String getLocal();
    void setLocal(Boolean local);
    void setLocal(String local);
    String getStub();
    void setStub(Boolean stub);
    void setStub(String stub);
    String getCluster();
    void setCluster(String cluster);
    String getProxy();
    void setProxy(String proxy);
    Integer getConnections();
    void setConnections(Integer connections);
    String getFilter();
    void setFilter(String filter);
    String getListener();
    void setListener(String listener);
    String getLayer();
    void setLayer(String layer);
    ApplicationConfigInterface getApplication();
    void setApplication(ApplicationConfigInterface application);
    ModuleConfigInterface getModule();
    void setModule(ModuleConfigInterface module);
    RegistryConfigInterface getRegistry();
    void setRegistry(RegistryConfigInterface registry);
    List getRegistries();
    void setRegistries(List registries);
    String getRegistryIds();
    void setRegistryIds(String registryIds);
    List getMethods();
    void setMethods(List methods);
    void addMethod(MethodConfigInterface methodConfig);
    MonitorConfigInterface getMonitor();
    void setMonitor(String monitor);
    void setMonitor(MonitorConfigInterface monitor);
    String getOwner();
    void setOwner(String owner);
    ConfigCenterConfigInterface getConfigCenter();
    void setConfigCenter(ConfigCenterConfigInterface configCenter);
    Integer getCallbacks();
    void setCallbacks(Integer callbacks);
    String getOnconnect();
    void setOnconnect(String onconnect);
    String getOndisconnect();
    void setOndisconnect(String ondisconnect);
    String getScope();
    void setScope(String scope);
    MetadataReportConfigInterface getMetadataReportConfig();
    void setMetadataReportConfig(MetadataReportConfigInterface metadataReportConfig);
    String getTag();
    void setTag(String tag);
    Boolean getAuth();
    void setAuth(Boolean auth);
    SslConfigInterface getSslConfig();
    Boolean getSingleton();
    void setSingleton(Boolean singleton);
    String getGroup(AbstractInterfaceConfigInterface interfaceConfig);
    String getVersion(AbstractInterfaceConfigInterface interfaceConfig);
    String getVersion();
    void setVersion(String version);
    String getGroup();
    void setGroup(String group);
    String getInterface();
    void setInterface(String interfaceName);
    ClassLoader getInterfaceClassLoader();
    void setInterfaceClassLoader(ClassLoader interfaceClassLoader);
}