package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ModuleConfig extends AbstractConfig implements ModuleConfigInterface {

    public StringInterface getName() {
        return instance.getName();
    }

    public void setName(StringInterface name) {
        instance.setName(name);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public StringInterface getOwner() {
        return instance.getOwner();
    }

    public void setOwner(StringInterface owner) {
        instance.setOwner(owner);
    }

    public StringInterface getOrganization() {
        return instance.getOrganization();
    }

    public void setOrganization(StringInterface organization) {
        instance.setOrganization(organization);
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterface registry) {
        instance.setRegistry(registry);
    }

    public List<RegistryConfigInterface> getRegistries() {
        return instance.getRegistries();
    }

    public void setRegistries(List<? extends RegistryConfigInterface> registries) {
        instance.setRegistries(registries);
    }

    public MonitorConfigInterface getMonitor() {
        return instance.getMonitor();
    }

    public void setMonitor(MonitorConfigInterface monitor) {
        instance.setMonitor(monitor);
    }

    public void setMonitor(StringInterface monitor) {
        instance.setMonitor(monitor);
    }

    public BooleanInterface getBackground() {
        return instance.getBackground();
    }

    public void setBackground(BooleanInterface background) {
        instance.setBackground(background);
    }

    public IntegerInterface getReferThreadNum() {
        return instance.getReferThreadNum();
    }

    public void setReferThreadNum(IntegerInterface referThreadNum) {
        instance.setReferThreadNum(referThreadNum);
    }

    public IntegerInterface getExportThreadNum() {
        return instance.getExportThreadNum();
    }

    public void setExportThreadNum(IntegerInterface exportThreadNum) {
        instance.setExportThreadNum(exportThreadNum);
    }

    public BooleanInterface getReferAsync() {
        return instance.getReferAsync();
    }

    public void setReferAsync(BooleanInterface referAsync) {
        instance.setReferAsync(referAsync);
    }

    public BooleanInterface getExportAsync() {
        return instance.getExportAsync();
    }

    public void setExportAsync(BooleanInterface exportAsync) {
        instance.setExportAsync(exportAsync);
    }

    public ModuleConfig() {
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName());
    }

    public ModuleConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
    }

    public ModuleConfig(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
    }

    public ModuleConfig(ModuleModelInterface moduleModel, String name) {
        Class[] params = new Class[]{ModuleModelInterface.class, String.class};
        Object[] args = new Object[]{moduleModel, name};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
    }
}
