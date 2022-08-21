package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class ModuleBuilder extends AbstractBuilder<ModuleConfig, ModuleBuilder> implements ModuleBuilderInterface {

    public ModuleBuilderInterface name(String name) {
        return instance.name(name);
    }

    public ModuleBuilderInterface version(String version) {
        return instance.version(version);
    }

    public ModuleBuilderInterface owner(String owner) {
        return instance.owner(owner);
    }

    public ModuleBuilderInterface organization(String organization) {
        return instance.organization(organization);
    }

    public ModuleBuilderInterface addRegistries(List<? extends RegistryConfigInterface> registries) {
        return instance.addRegistries(registries);
    }

    public ModuleBuilderInterface addRegistry(RegistryConfigInterface registry) {
        return instance.addRegistry(((RegistryConfig) registry).getInternalInstance());
    }

    public ModuleBuilderInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(((MonitorConfig) monitor).getInternalInstance());
    }

    public ModuleBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public ModuleConfigInterface build() {
        return instance.build();
    }

    protected ModuleBuilderInterface instance;

    public ModuleBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ModuleBuilder() {
        instance = (ModuleBuilderInterface) DubboClassLoader.getInstance(ModuleBuilder.class.getName());
        super.instance = instance;
    }
}
