package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface ModuleBuilderInterface{
    ModuleBuilderInterface name(String name);
    ModuleBuilderInterface version(String version);
    ModuleBuilderInterface owner(String owner);
    ModuleBuilderInterface organization(String organization);
    ModuleBuilderInterface addRegistries(List registries);
    ModuleBuilderInterface addRegistry(RegistryConfigInterface registry);
    ModuleBuilderInterface monitor(MonitorConfigInterface monitor);
    ModuleBuilderInterface isDefault(Boolean isDefault);
    ModuleConfigInterface build();

}