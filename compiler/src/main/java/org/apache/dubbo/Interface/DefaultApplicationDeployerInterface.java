package org.apache.dubbo.Interface;

import java.util.concurrent.Future;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.common.deploy.ApplicationDeployer;

public interface DefaultApplicationDeployerInterface {
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