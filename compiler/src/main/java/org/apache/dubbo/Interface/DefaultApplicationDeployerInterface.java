package org.apache.dubbo.Interface;

import java.util.concurrent;
import org.apache.dubbo.rpc.model;
import org.apache.dubbo.common.config;
import org.apache.dubbo.common.deploy;

public interface DefaultApplicationDeployerInterface{
    ApplicationDeployer get(ScopeModel moduleOrApplicationModel);
    ApplicationModel getApplicationModel();
    ReferenceCache getReferenceCache();
    void initialize();
    Future start();
    Future getStartFuture();
    void prepareApplicationInstance();
    void prepareInternalModule();
    boolean isBackground();
    void stop();
    void preDestroy();
    void postDestroy();
    void notifyModuleChanged(ModuleModel moduleModel, DeployState state);
    void checkState(ModuleModel moduleModel, DeployState moduleState);

}