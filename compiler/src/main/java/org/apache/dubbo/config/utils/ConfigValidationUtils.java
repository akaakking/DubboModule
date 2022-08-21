package org.apache.dubbo.config.utils;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.dubbo.config.AbstractInterfaceConfig;
import org.apache.dubbo.common.URL;
import java.lang.Class;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.lang.String;
import java.util.Map;
import java.util.regex.Pattern;

public class ConfigValidationUtils implements ConfigValidationUtilsInterface {

    protected ConfigValidationUtilsInterface instance;

    public static List<URLInterface> loadRegistries(AbstractInterfaceConfigInterface interfaceConfig, boolean provider) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("loadRegistries", AbstractInterfaceConfigInterface.class, boolean.class);
        return (List<URLInterface>)method.invoke(interfaceConfig, provider);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static URLInterface loadMonitor(AbstractInterfaceConfigInterface interfaceConfig, URLInterface registryURL) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("loadMonitor", AbstractInterfaceConfigInterface.class, URLInterface.class);
        return (URLInterface)method.invoke(interfaceConfig, registryURL);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static void checkMock(Class<?> interfaceClass, AbstractInterfaceConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkMock", Class.class, AbstractInterfaceConfigInterface.class);
        method.invoke(interfaceClass, config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateAbstractInterfaceConfig(AbstractInterfaceConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateAbstractInterfaceConfig", AbstractInterfaceConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateServiceConfig(ServiceConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateServiceConfig", ServiceConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateReferenceConfig(ReferenceConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateReferenceConfig", ReferenceConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateConfigCenterConfig(ConfigCenterConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateConfigCenterConfig", ConfigCenterConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateApplicationConfig(ApplicationConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateApplicationConfig", ApplicationConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateModuleConfig(ModuleConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateModuleConfig", ModuleConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateMetadataConfig(MetadataReportConfigInterface metadataReportConfig) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateMetadataConfig", MetadataReportConfigInterface.class);
        method.invoke(metadataReportConfig);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateMetricsConfig(MetricsConfigInterface metricsConfig) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateMetricsConfig", MetricsConfigInterface.class);
        method.invoke(metricsConfig);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateSslConfig(SslConfigInterface sslConfig) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateSslConfig", SslConfigInterface.class);
        method.invoke(sslConfig);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateMonitorConfig(MonitorConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateMonitorConfig", MonitorConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateProtocolConfig(ProtocolConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateProtocolConfig", ProtocolConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateProviderConfig(ProviderConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateProviderConfig", ProviderConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateConsumerConfig(ConsumerConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateConsumerConfig", ConsumerConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateRegistryConfig(RegistryConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateRegistryConfig", RegistryConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void validateMethodConfig(MethodConfigInterface config) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("validateMethodConfig", MethodConfigInterface.class);
        method.invoke(config);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkExtension", ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, Class<?> type, String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkMultiExtension", ScopeModelInterface.class, Class.class, String.class, String.class);
        method.invoke(scopeModel, type, property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkMultiExtension(ScopeModelInterface scopeModel, List<Class<?>> types, String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkMultiExtension", ScopeModelInterface.class, List.class, String.class, String.class);
        method.invoke(scopeModel, types, property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkLength(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkLength", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkPathLength(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkPathLength", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkName(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkName", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkHost(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkHost", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkNameHasSymbol(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkNameHasSymbol", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkKey(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkKey", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkMultiName(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkMultiName", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkPathName(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkPathName", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkMethodName(String property, String value) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkMethodName", String.class, String.class);
        method.invoke(property, value);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkParameterName(Map<String, String> parameters) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkParameterName", Map.class);
        method.invoke(parameters);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void checkProperty(String property, String value, int maxlength, Pattern pattern) {
        try { 
          Class klass = DubboClassLoader.getKlass(ConfigValidationUtils.class.getName());
        Method method = klass.getMethod("checkProperty", String.class, String.class, int.class, Pattern.class);
        method.invoke(property, value, maxlength, pattern);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public ConfigValidationUtilsInterface getInternalInstance() {
        return instance;
    }

    protected ConfigValidationUtils() {
        instance = (ConfigValidationUtilsInterface) DubboClassLoader.getInstance(ConfigValidationUtils.class.getName());
    }
}
