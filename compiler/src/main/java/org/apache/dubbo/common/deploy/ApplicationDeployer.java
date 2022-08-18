package org.apache.dubbo.common.deploy;

import java.util.concurrent.Future;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ApplicationDeployer implements ApplicationDeployerInterface {

    public void initialize() {
        instance.initialize();
    }

    public Future start() {
        return instance.start();
    }

    public void stop() {
        instance.stop();
    }

    public Future getStartFuture() {
        return instance.getStartFuture();
    }

    public void prepareApplicationInstance() {
        instance.prepareApplicationInstance();
    }

    public void prepareInternalModule() {
        instance.prepareInternalModule();
    }

    public void preDestroy() {
        instance.preDestroy();
    }

    public void postDestroy() {
        instance.postDestroy();
    }

    public boolean isInitialized() {
        return instance.isInitialized();
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ReferenceCacheInterface getReferenceCache() {
        return instance.getReferenceCache();
    }

    public boolean isBackground() {
        return instance.isBackground();
    }

    public void checkState(ModuleModelInterface moduleModel, DeployStateInterface moduleState) {
        instance.checkState(moduleModel, moduleState);
    }

    public void notifyModuleChanged(ModuleModelInterface moduleModel, DeployStateInterface state) {
        instance.notifyModuleChanged(moduleModel, state);
    }
}
