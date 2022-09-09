package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.LifecycleAdapterInterface;
import org.apache.dubbo.common.context.ApplicationExt;
import java.lang.String;
import java.util.Map;
import org.apache.dubbo.common.config.Configuration;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.Interface.AbstractConfigInterface;
import org.apache.dubbo.Interface.CompositeConfigurationInterface;
import java.util.List;
import org.apache.dubbo.Interface.PropertiesConfigurationInterface;
import org.apache.dubbo.Interface.SystemConfigurationInterface;
import org.apache.dubbo.Interface.EnvironmentConfigurationInterface;
import org.apache.dubbo.Interface.InmemoryConfigurationInterface;
import java.util.Optional;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;

public interface EnvironmentInterface extends LifecycleAdapterInterface, ApplicationExt {

    void initialize();

    void setLocalMigrationRule(String localMigrationRule);

    void setExternalConfigMap(Map<String, String> externalConfiguration);

    void setAppExternalConfigMap(Map<String, String> appExternalConfiguration);

    void setAppConfigMap(Map<String, String> appConfiguration);

    Map<String, String> getExternalConfigMap();

    Map<String, String> getAppExternalConfigMap();

    Map<String, String> getAppConfigMap();

    void updateExternalConfigMap(Map<String, String> externalMap);

    void updateAppExternalConfigMap(Map<String, String> externalMap);

    void updateAppConfigMap(Map<String, String> map);

    Configuration getPrefixedConfiguration(AbstractConfigInterface config, String prefix);

    CompositeConfigurationInterface getConfiguration();

    List<Map<String, String>> getConfigurationMaps(AbstractConfigInterface config, String prefix);

    List<Map<String, String>> getConfigurationMaps();

    void destroy();

    void reset();

    String resolvePlaceholders(String str);

    PropertiesConfigurationInterface getPropertiesConfiguration();

    SystemConfigurationInterface getSystemConfiguration();

    EnvironmentConfigurationInterface getEnvironmentConfiguration();

    InmemoryConfigurationInterface getExternalConfiguration();

    InmemoryConfigurationInterface getAppExternalConfiguration();

    InmemoryConfigurationInterface getAppConfiguration();

    String getLocalMigrationRule();

    void refreshClassLoaders();

    Configuration getDynamicGlobalConfiguration();

    Optional<DynamicConfiguration> getDynamicConfiguration();

    void setDynamicConfiguration(DynamicConfiguration defaultDynamicConfiguration);
}
