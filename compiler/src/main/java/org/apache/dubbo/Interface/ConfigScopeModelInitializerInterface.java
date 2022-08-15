package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;

public interface ConfigScopeModelInitializerInterface {
    void initializeFrameworkModel(FrameworkModel frameworkModel);
    void initializeApplicationModel(ApplicationModel applicationModel);
    void initializeModuleModel(ModuleModel moduleModel);
}