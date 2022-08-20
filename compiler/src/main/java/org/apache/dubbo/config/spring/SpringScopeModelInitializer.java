package org.apache.dubbo.config.spring;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringScopeModelInitializer implements SpringScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel.getInternalInstance(), frameworkModel);
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel.getInternalInstance(), applicationModel);
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel.getInternalInstance(), moduleModel);
    }

    protected SpringScopeModelInitializerInterface instance;

    public SpringScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }

    public SpringScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }
}
