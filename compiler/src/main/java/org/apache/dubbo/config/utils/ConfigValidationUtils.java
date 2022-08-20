package org.apache.dubbo.config.utils;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ConfigValidationUtils implements ConfigValidationUtilsInterface {

    protected ConfigValidationUtilsInterface instance;

    public static List<URLInterface> loadRegistries(AbstractInterfaceConfigInterface interfaceConfig, boolean provider) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(loadRegistries, AbstractInterfaceConfigInterface.class, boolean.class);
        return method.invoke(interfaceConfig, provider);
    }

    public static URLInterface loadMonitor(AbstractInterfaceConfigInterface interfaceConfig, URLInterface registryURL) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(loadMonitor, AbstractInterfaceConfigInterface.class, URLInterface.class);
        return method.invoke(interfaceConfig, registryURL);
    }

    public static void checkMock(Class<?> interfaceClass, AbstractInterfaceConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkMock, Class.class, AbstractInterfaceConfigInterface.class);
        method.invoke(interfaceClass, config);
    }

    public static void validateAbstractInterfaceConfig(AbstractInterfaceConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateAbstractInterfaceConfig, AbstractInterfaceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateServiceConfig(ServiceConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateServiceConfig, ServiceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateReferenceConfig(ReferenceConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateReferenceConfig, ReferenceConfigInterface.class);
        method.invoke(config);
    }

    public static void validateConfigCenterConfig(ConfigCenterConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateConfigCenterConfig, ConfigCenterConfigInterface.class);
        method.invoke(config);
    }

    public static void validateApplicationConfig(ApplicationConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateApplicationConfig, ApplicationConfigInterface.class);
        method.invoke(config);
    }

    public static void validateModuleConfig(ModuleConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateModuleConfig, ModuleConfigInterface.class);
        method.invoke(config);
    }

    public static void validateMetadataConfig(MetadataReportConfigInterface metadataReportConfig) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateMetadataConfig, MetadataReportConfigInterface.class);
        method.invoke(metadataReportConfig);
    }

    public static void validateMetricsConfig(MetricsConfigInterface metricsConfig) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateMetricsConfig, MetricsConfigInterface.class);
        method.invoke(metricsConfig);
    }

    public static void validateSslConfig(SslConfigInterface sslConfig) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateSslConfig, SslConfigInterface.class);
        method.invoke(sslConfig);
    }

    public static void validateMonitorConfig(MonitorConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateMonitorConfig, MonitorConfigInterface.class);
        method.invoke(config);
    }

    public static void validateProtocolConfig(ProtocolConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateProtocolConfig, ProtocolConfigInterface.class);
        method.invoke(config);
    }

    public static void validateProviderConfig(ProviderConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateProviderConfig, ProviderConfigInterface.class);
        method.invoke(config);
    }

    public static void validateConsumerConfig(ConsumerConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateConsumerConfig, ConsumerConfigInterface.class);
        method.invoke(config);
    }

    public static void validateRegistryConfig(RegistryConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateRegistryConfig, RegistryConfigInterface.class);
        method.invoke(config);
    }

    public static void validateMethodConfig(MethodConfigInterface config) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(validateMethodConfig, MethodConfigInterface.class);
        method.invoke(config);
    }

    public static void checkExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkExtension, ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkMultiExtension, ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, List<Class<?>> types, String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkMultiExtension, ScopeModelInterface.class, List.class, String.class, String.class);
        method.invoke(scopeModel, types, property, value);
    }

    public static void checkLength(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkLength, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkPathLength(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkPathLength, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkName(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkName, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkHost(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkHost, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkNameHasSymbol(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkNameHasSymbol, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkKey(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkKey, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkMultiName(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkMultiName, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkPathName(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkPathName, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkMethodName(String property, String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkMethodName, String.class, String.class);
        method.invoke(property, value);
    }

    public static void checkParameterName(Map<String, String> parameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkParameterName, Map.class);
        method.invoke(parameters);
    }

    public static void checkProperty(String property, String value, int maxlength, Pattern pattern) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(checkProperty, String.class, String.class, int.class, Pattern.class);
        method.invoke(property, value, maxlength, pattern);
    }

    public ConfigValidationUtilsInterface getInternalInstance() {
        return instance;
    }

    public ConfigValidationUtilsInterface getInternalInstance() {
        return instance;
    }
}
