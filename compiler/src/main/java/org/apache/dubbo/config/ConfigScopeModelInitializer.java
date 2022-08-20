package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigScopeModelInitializer implements ConfigScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel.getInternalInstance(), frameworkModel);
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel.getInternalInstance(), applicationModel);
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel.getInternalInstance(), moduleModel);
    }

    protected ConfigScopeModelInitializerInterface instance;

    public ConfigScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }

    public ConfigScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }
}
