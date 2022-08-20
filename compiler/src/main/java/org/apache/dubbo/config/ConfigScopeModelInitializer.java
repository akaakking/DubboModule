package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigScopeModelInitializer implements ConfigScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel.getInternalInstance());
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel.getInternalInstance());
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel.getInternalInstance());
    }

    protected ConfigScopeModelInitializerInterface instance;

    public ConfigScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }
}
