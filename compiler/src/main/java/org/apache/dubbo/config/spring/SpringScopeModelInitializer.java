package org.apache.dubbo.config.spring;

import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringScopeModelInitializer implements SpringScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(((FrameworkModel) frameworkModel).getInternalInstance());
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(((ApplicationModel) applicationModel).getInternalInstance());
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(((ModuleModel) moduleModel).getInternalInstance());
    }

    protected SpringScopeModelInitializerInterface instance;

    public SpringScopeModelInitializerInterface getInternalInstance() {
        return instance;
    }

    protected SpringScopeModelInitializer() {
        instance = (SpringScopeModelInitializerInterface) DubboClassLoader.getInstance(SpringScopeModelInitializer.class.getName());
    }
}
