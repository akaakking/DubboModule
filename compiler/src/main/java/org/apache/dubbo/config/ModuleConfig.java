package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class ModuleConfig extends AbstractConfig implements ModuleConfigInterface {

    public String getName() {
        return instance.getName();
    }

    public void setName(String name) {
        instance.setName(name);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getOwner() {
        return instance.getOwner();
    }

    public void setOwner(String owner) {
        instance.setOwner(owner);
    }

    public String getOrganization() {
        return instance.getOrganization();
    }

    public void setOrganization(String organization) {
        instance.setOrganization(organization);
    }

    public RegistryConfigInterface getRegistry() {
        return instance.getRegistry();
    }

    public void setRegistry(RegistryConfigInterface registry) {
        instance.setRegistry(registry.getInternalInstance());
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
        instance.setMonitor(monitor.getInternalInstance());
    }

    public void setMonitor(String monitor) {
        instance.setMonitor(monitor);
    }

    public Boolean getBackground() {
        return instance.getBackground();
    }

    public void setBackground(Boolean background) {
        instance.setBackground(background);
    }

    public Integer getReferThreadNum() {
        return instance.getReferThreadNum();
    }

    public void setReferThreadNum(Integer referThreadNum) {
        instance.setReferThreadNum(referThreadNum);
    }

    public Integer getExportThreadNum() {
        return instance.getExportThreadNum();
    }

    public void setExportThreadNum(Integer exportThreadNum) {
        instance.setExportThreadNum(exportThreadNum);
    }

    public Boolean getReferAsync() {
        return instance.getReferAsync();
    }

    public void setReferAsync(Boolean referAsync) {
        instance.setReferAsync(referAsync);
    }

    public Boolean getExportAsync() {
        return instance.getExportAsync();
    }

    public void setExportAsync(Boolean exportAsync) {
        instance.setExportAsync(exportAsync);
    }

    public ModuleConfigInterface getInternalInstance() {
        return instance;
    }

    public protected ModuleConfig() {
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName());
        super.instance = instance;
    }

    public ModuleConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public ModuleConfig(String name) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{name};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
        super.instance = instance;
    }

    public ModuleConfig(ModuleModelInterface moduleModel, String name) {
        Class[] params = new Class[]{ModuleModelInterface.class, String.class};
        Object[] args = new Object[]{moduleModel, name};
        instance = (ModuleConfigInterface) DubboClassLoader.getInstance(ModuleConfig.class.getName(), params, args);
        super.instance = instance;
    }
}
