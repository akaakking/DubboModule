package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model;

public interface SpringScopeModelInitializerInterface{
    void initializeFrameworkModel(FrameworkModel frameworkModel);
    void initializeApplicationModel(ApplicationModel applicationModel);
    void initializeModuleModel(ModuleModel moduleModel);

}