package org.apache.dubbo.common.config;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.context.LifecycleAdapter;

public class Environment extends LifecycleAdapter implements EnvironmentInterface {

    public void initialize() {
        instance.initialize();
    }

    public void setLocalMigrationRule(String localMigrationRule) {
        instance.setLocalMigrationRule(localMigrationRule);
    }

    public void setExternalConfigMap(Map<String, String> externalConfiguration) {
        instance.setExternalConfigMap(externalConfiguration);
    }

    public void setAppExternalConfigMap(Map<String, String> appExternalConfiguration) {
        instance.setAppExternalConfigMap(appExternalConfiguration);
    }

    public void setAppConfigMap(Map<String, String> appConfiguration) {
        instance.setAppConfigMap(appConfiguration);
    }

    public Map<String, String> getExternalConfigMap() {
        return instance.getExternalConfigMap();
    }

    public Map<String, String> getAppExternalConfigMap() {
        return instance.getAppExternalConfigMap();
    }

    public Map<String, String> getAppConfigMap() {
        return instance.getAppConfigMap();
    }

    public void updateExternalConfigMap(Map<String, String> externalMap) {
        instance.updateExternalConfigMap(externalMap);
    }

    public void updateAppExternalConfigMap(Map<String, String> externalMap) {
        instance.updateAppExternalConfigMap(externalMap);
    }

    public void updateAppConfigMap(Map<String, String> map) {
        instance.updateAppConfigMap(map);
    }

    public ConfigurationInterface getPrefixedConfiguration(AbstractConfigInterface config, String prefix) {
        return instance.getPrefixedConfiguration(config.getInternalInstance(), config, prefix);
    }

    public CompositeConfigurationInterface getConfiguration() {
        return instance.getConfiguration();
    }

    public List<Map<String, String>> getConfigurationMaps(AbstractConfigInterface config, String prefix) {
        return instance.getConfigurationMaps(config.getInternalInstance(), config, prefix);
    }

    public List<Map<String, String>> getConfigurationMaps() {
        return instance.getConfigurationMaps();
    }

    public void destroy() {
        instance.destroy();
    }

    public void reset() {
        instance.reset();
    }

    public String resolvePlaceholders(String str) {
        return instance.resolvePlaceholders(str);
    }

    public PropertiesConfigurationInterface getPropertiesConfiguration() {
        return instance.getPropertiesConfiguration();
    }

    public SystemConfigurationInterface getSystemConfiguration() {
        return instance.getSystemConfiguration();
    }

    public EnvironmentConfigurationInterface getEnvironmentConfiguration() {
        return instance.getEnvironmentConfiguration();
    }

    public InmemoryConfigurationInterface getExternalConfiguration() {
        return instance.getExternalConfiguration();
    }

    public InmemoryConfigurationInterface getAppExternalConfiguration() {
        return instance.getAppExternalConfiguration();
    }

    public InmemoryConfigurationInterface getAppConfiguration() {
        return instance.getAppConfiguration();
    }

    public String getLocalMigrationRule() {
        return instance.getLocalMigrationRule();
    }

    public void refreshClassLoaders() {
        instance.refreshClassLoaders();
    }

    public ConfigurationInterface getDynamicGlobalConfiguration() {
        return instance.getDynamicGlobalConfiguration();
    }

    public Optional<DynamicConfigurationInterface> getDynamicConfiguration() {
        return instance.getDynamicConfiguration();
    }

    public void setDynamicConfiguration(DynamicConfigurationInterface defaultDynamicConfiguration) {
        instance.setDynamicConfiguration(defaultDynamicConfiguration.getInternalInstance(), defaultDynamicConfiguration);
    }

    public EnvironmentInterface getInternalInstance() {
        return instance;
    }

    public EnvironmentInterface getInternalInstance() {
        return instance;
    }

    public Environment(ScopeModelInterface scopeModel) {
        Class[] params = new Class[]{ScopeModelInterface.class};
        Object[] args = new Object[]{scopeModel};
        instance = (EnvironmentInterface) DubboClassLoader.getInstance(Environment.class.getName(), params, args);
    }
}
