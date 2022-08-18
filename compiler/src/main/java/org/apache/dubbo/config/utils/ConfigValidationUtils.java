package org.apache.dubbo.config.utils;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigValidationUtils implements ConfigValidationUtilsInterface {

    public static List<URL> loadRegistries(AbstractInterfaceConfigInterface interfaceConfig, boolean provider) {
        Method method = instance.getClass().getMethod(AbstractInterfaceConfigInterface.class, boolean.class);
        return method.invoke(interfaceConfig, provider);
    }

    public static URLInterface loadMonitor(AbstractInterfaceConfigInterface interfaceConfig, URLInterface registryURL) {
        Method method = instance.getClass().getMethod(AbstractInterfaceConfigInterface.class, URLInterface.class);
        return method.invoke(interfaceConfig, registryURL);
    }

    public static void checkMock(Class<?> interfaceClass, AbstractInterfaceConfigInterface config) {
        Method method = instance.getClass().getMethod(Class.class, AbstractInterfaceConfigInterface.class);
        method.invoke(interfaceClass, config);
    }

    public static void validateAbstractInterfaceConfig(AbstractInterfaceConfigInterface config) {
        Method method = instance.getClass().getMethod(AbstractInterfaceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateServiceConfig(ServiceConfigInterface config) {
        Method method = instance.getClass().getMethod(ServiceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateReferenceConfig(ReferenceConfigInterface config) {
        Method method = instance.getClass().getMethod(ReferenceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateConfigCenterConfig(ConfigCenterConfigInterface config) {
        Method method = instance.getClass().getMethod(ConfigCenterConfigInterface.class);
        method.invoke(config);
    }

    public static void validateApplicationConfig(ApplicationConfigInterface config) {
        Method method = instance.getClass().getMethod(ApplicationConfigInterface.class);
        method.invoke(config);
    }

    public static void validateModuleConfig(ModuleConfigInterface config) {
        Method method = instance.getClass().getMethod(ModuleConfigInterface.class);
        method.invoke(config);
    }

    public static void validateMetadataConfig(MetadataReportConfigInterface metadataReportConfig) {
        Method method = instance.getClass().getMethod(MetadataReportConfigInterface.class);
        method.invoke(metadataReportConfig);
    }

    public static void validateMetricsConfig(MetricsConfigInterface metricsConfig) {
        Method method = instance.getClass().getMethod(MetricsConfigInterface.class);
        method.invoke(metricsConfig);
    }

    public static void validateSslConfig(SslConfigInterface sslConfig) {
        Method method = instance.getClass().getMethod(SslConfigInterface.class);
        method.invoke(sslConfig);
    }

    public static void validateMonitorConfig(MonitorConfigInterface config) {
        Method method = instance.getClass().getMethod(MonitorConfigInterface.class);
        method.invoke(config);
    }

    public static void validateProtocolConfig(ProtocolConfigInterface config) {
        Method method = instance.getClass().getMethod(ProtocolConfigInterface.class);
        method.invoke(config);
    }

    public static void validateProviderConfig(ProviderConfigInterface config) {
        Method method = instance.getClass().getMethod(ProviderConfigInterface.class);
        method.invoke(config);
    }

    public static void validateConsumerConfig(ConsumerConfigInterface config) {
        Method method = instance.getClass().getMethod(ConsumerConfigInterface.class);
        method.invoke(config);
    }

    public static void validateRegistryConfig(RegistryConfigInterface config) {
        Method method = instance.getClass().getMethod(RegistryConfigInterface.class);
        method.invoke(config);
    }

    public static void validateMethodConfig(MethodConfigInterface config) {
        Method method = instance.getClass().getMethod(MethodConfigInterface.class);
        method.invoke(config);
    }

    public static void checkExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        Method method = instance.getClass().getMethod(ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        Method method = instance.getClass().getMethod(ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, List<Class<?>> types, String property, String value) {
        Method method = instance.getClass().getMethod(ScopeModelInterface.class, List.class, String.class, String.class);
        method.invoke(scopeModel, types, property, value);
    }

    public static void checkLength(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkPathLength(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkName(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkHost(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkNameHasSymbol(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkKey(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkMultiName(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkPathName(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkMethodName(String property, String value) {
        Method method = instance.getClass().getMethod(String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkParameterName(Map<String, String> parameters) {
        Method method = instance.getClass().getMethod(Map.class);
        method.invoke(parameters);
    }

    public static void checkProperty(String property, String value, int maxlength, Pattern pattern) {
        Method method = instance.getClass().getMethod(String.class, String.class, int.class, Pattern.class);
        method.invoke(property, value, maxlength, pattern);
    }
}
