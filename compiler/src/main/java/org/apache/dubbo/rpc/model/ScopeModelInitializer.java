package org.apache.dubbo.rpc.model;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ScopeModelInitializer implements ScopeModelInitializerInterface {

    public void initializeFrameworkModel(FrameworkModelInterface frameworkModel) {
        instance.initializeFrameworkModel(frameworkModel);
    }

    public void initializeApplicationModel(ApplicationModelInterface applicationModel) {
        instance.initializeApplicationModel(applicationModel);
    }

    public void initializeModuleModel(ModuleModelInterface moduleModel) {
        instance.initializeModuleModel(moduleModel);
    }
}
