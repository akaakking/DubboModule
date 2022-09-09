package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;

public interface ScopeModelInitializerInterface {

    void initializeFrameworkModel(FrameworkModelInterface frameworkModel);

    void initializeApplicationModel(ApplicationModelInterface applicationModel);

    void initializeModuleModel(ModuleModelInterface moduleModel);
}
