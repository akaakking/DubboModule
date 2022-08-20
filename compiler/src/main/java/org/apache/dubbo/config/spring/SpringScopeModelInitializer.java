package org.apache.dubbo.config.spring;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringScopeModelInitializer implements SpringScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel);
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel);
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel);
    }

    protected SpringScopeModelInitializerInterface instance;
}
