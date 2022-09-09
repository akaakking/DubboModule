package org.apache.dubbo.Interface;

import org.apache.dubbo.common.deploy.Deployer;
import java.util.concurrent.Future;
import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.common.deploy.DeployState;

public interface ApplicationDeployerInterface extends Deployer<ApplicationModelInterface> {

    void initialize();

    Future start();

    void stop();

    Future getStartFuture();

    void prepareApplicationInstance();

    void prepareInternalModule();

    void preDestroy();

    void postDestroy();

    boolean isInitialized();

    ApplicationModelInterface getApplicationModel();

    ReferenceCache getReferenceCache();

    boolean isBackground();

    void checkState(ModuleModelInterface moduleModel, DeployState moduleState);

    void notifyModuleChanged(ModuleModelInterface moduleModel, DeployState state);
}
