package org.apache.dubbo.Interface;

import java.util.List;
import org.apache.dubbo.common.URL;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.dubbo.rpc.model.ScopeModel;

public interface ConfigValidationUtilsInterface {
    List loadRegistries(AbstractInterfaceConfigInterface interfaceConfig, boolean provider);
    URL loadMonitor(AbstractInterfaceConfigInterface interfaceConfig, URL registryURL);
    void checkMock(Class interfaceClass, AbstractInterfaceConfigInterface config);
    void validateAbstractInterfaceConfig(AbstractInterfaceConfigInterface config);
    void validateServiceConfig(ServiceConfigInterface<T> config);
    void validateReferenceConfig(ReferenceConfigInterface<T> config);
    void validateConfigCenterConfig(ConfigCenterConfigInterface config);
    void validateApplicationConfig(ApplicationConfigInterface config);
    void validateModuleConfig(ModuleConfigInterface config);
    void validateMetadataConfig(MetadataReportConfigInterface metadataReportConfig);
    void validateMetricsConfig(MetricsConfigInterface metricsConfig);
    void validateSslConfig(SslConfigInterface sslConfig);
    void validateMonitorConfig(MonitorConfigInterface config);
    void validateProtocolConfig(ProtocolConfigInterface config);
    void validateProviderConfig(ProviderConfigInterface config);
    void validateConsumerConfig(ConsumerConfigInterface config);
    void validateRegistryConfig(RegistryConfigInterface config);
    void validateMethodConfig(MethodConfigInterface config);
    void checkExtension(ScopeModel scopeModel, Class type, String property, String value);
    void checkMultiExtension(ScopeModel scopeModel, Class type, String property, String value);
    void checkMultiExtension(ScopeModel scopeModel, List types, String property, String value);
    void checkLength(String property, String value);
    void checkPathLength(String property, String value);
    void checkName(String property, String value);
    void checkHost(String property, String value);
    void checkNameHasSymbol(String property, String value);
    void checkKey(String property, String value);
    void checkMultiName(String property, String value);
    void checkPathName(String property, String value);
    void checkMethodName(String property, String value);
    void checkParameterName(Map parameters);
    void checkProperty(String property, String value, int maxlength, Pattern pattern);
}