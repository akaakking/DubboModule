package org.apache.dubbo.config.context;

import java.util.Map;
import java.util.Collection;
import java.util.Optional;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractConfigManager implements AbstractConfigManagerInterface {

    public void initialize() {
        instance.initialize();
    }

    public <T extends AbstractConfigInterface> T addConfig(AbstractConfigInterface config) {
        return instance.addConfig(config);
    }

    public <C extends AbstractConfigInterface> Map<String, C> getConfigsMap(Class<C> cls) {
        return instance.getConfigsMap(cls);
    }

    public <C extends AbstractConfigInterface> Collection<C> getConfigs(Class<C> configType) {
        return instance.getConfigs(configType);
    }

    public <T extends AbstractConfigInterface> Optional<T> getConfig(Class<T> cls, String idOrName) {
        return instance.getConfig(cls, idOrName);
    }

    public <C extends AbstractConfigInterface> List<C> getDefaultConfigs(Class<C> cls) {
        return instance.getDefaultConfigs(cls);
    }

    public void loadConfigs() {
        instance.loadConfigs();
    }

    public <T extends AbstractConfigInterface> List<T> loadConfigsOfTypeFromProps(Class<T> cls) {
        return instance.loadConfigsOfTypeFromProps(cls);
    }

    public void refreshAll() {
        instance.refreshAll();
    }

    public boolean removeConfig(AbstractConfigInterface config) {
        return instance.removeConfig(config);
    }

    public void destroy() {
        instance.destroy();
    }

    public void clear() {
        instance.clear();
    }

    public boolean isInitialized() {
        return instance.isInitialized();
    }

    protected AbstractConfigManagerInterface instance;
}
