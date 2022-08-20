package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ModuleBuilder extends AbstractBuilder<ModuleConfig, ModuleBuilder> implements ModuleBuilderInterface {

    public ModuleBuilderInterface name(StringInterface name) {
        return instance.name(name);
    }

    public ModuleBuilderInterface version(StringInterface version) {
        return instance.version(version);
    }

    public ModuleBuilderInterface owner(StringInterface owner) {
        return instance.owner(owner);
    }

    public ModuleBuilderInterface organization(StringInterface organization) {
        return instance.organization(organization);
    }

    public ModuleBuilderInterface addRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public ModuleBuilderInterface addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(registry);
    }

    public ModuleBuilderInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor);
    }

    public ModuleBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public ModuleConfigInterface build() {
        return instance.build();
    }
}
