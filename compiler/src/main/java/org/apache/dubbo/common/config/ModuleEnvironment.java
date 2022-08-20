package org.apache.dubbo.common.config;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.config.Environment;

public class ModuleEnvironment extends Environment implements ModuleEnvironmentInterface {

    public void initialize() {
        instance.initialize();
    }

    public ConfigurationInterface getPrefixedConfiguration(AbstractConfigInterface config, StringInterface prefix) {
        return instance.getPrefixedConfiguration(config, prefix);
    }

    public CompositeConfigurationInterface getConfiguration() {
        return instance.getConfiguration();
    }

    public List<Map<String, String>> getConfigurationMaps(AbstractConfigInterface config, StringInterface prefix) {
        return instance.getConfigurationMaps(config, prefix);
    }

    public ConfigurationInterface getDynamicGlobalConfiguration() {
        return instance.getDynamicGlobalConfiguration();
    }

    public Optional<DynamicConfigurationInterface> getDynamicConfiguration() {
        return instance.getDynamicConfiguration();
    }

    public void setDynamicConfiguration(DynamicConfigurationInterface dynamicConfiguration) {
        instance.setDynamicConfiguration(dynamicConfiguration);
    }

    public void destroy() {
        instance.destroy();
    }

    public void setLocalMigrationRule(StringInterface localMigrationRule) {
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

    public StringInterface getLocalMigrationRule() {
        return instance.getLocalMigrationRule();
    }

    public void refreshClassLoaders() {
        instance.refreshClassLoaders();
    }

    public ModuleEnvironment(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleEnvironmentInterface) DubboClassLoader.getInstance(ModuleEnvironment.class.getName(), params, args);
    }
}
