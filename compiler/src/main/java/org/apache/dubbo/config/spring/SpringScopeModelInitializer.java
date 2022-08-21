package org.apache.dubbo.config.spring;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringScopeModelInitializer implements SpringScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel.getInternalInstance());
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel.getInternalInstance());
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel.getInternalInstance());
    }

    protected SpringScopeModelInitializerInterface instance;

    public SpringScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }

    protected SpringScopeModelInitializer() {
        instance = (SpringScopeModelInitializerInterface) DubboClassLoader.getInstance(SpringScopeModelInitializer.class.getName());
    }
}
