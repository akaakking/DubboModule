package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigScopeModelInitializer implements ConfigScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(((FrameworkModel) frameworkModel).getInternalInstance());
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(((ApplicationModel) applicationModel).getInternalInstance());
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(((ModuleModel) moduleModel).getInternalInstance());
    }

    protected ConfigScopeModelInitializerInterface instance;

    public ConfigScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }

    protected ConfigScopeModelInitializer() {
        instance = (ConfigScopeModelInitializerInterface) DubboClassLoader.getInstance(ConfigScopeModelInitializer.class.getName());
    }
}
