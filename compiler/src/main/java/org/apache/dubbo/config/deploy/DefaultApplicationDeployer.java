package org.apache.dubbo.config.deploy;

import java.util.concurrent.Future;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.common.deploy.AbstractDeployer;

public class DefaultApplicationDeployer extends AbstractDeployer<ApplicationModel> implements DefaultApplicationDeployerInterface {

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ReferenceCacheInterface getReferenceCache() {
        return instance.getReferenceCache();
    }

    public void initialize() {
        instance.initialize();
    }

    public FutureInterface start() {
        return instance.start();
    }

    public FutureInterface getStartFuture() {
        return instance.getStartFuture();
    }

    public void prepareApplicationInstance() {
        instance.prepareApplicationInstance();
    }

    public void prepareInternalModule() {
        instance.prepareInternalModule();
    }

    public boolean isBackground() {
        return instance.isBackground();
    }

    public void stop() {
        instance.stop();
    }

    public void preDestroy() {
        instance.preDestroy();
    }

    public void postDestroy() {
        instance.postDestroy();
    }

    public void notifyModuleChanged(ModuleModelInterface moduleModel, DeployStateInterface state) {
        instance.notifyModuleChanged(moduleModel, state);
    }

    public void checkState(ModuleModelInterface moduleModel, DeployStateInterface moduleState) {
        instance.checkState(moduleModel, moduleState);
    }

    public static ApplicationDeployerInterface get(ScopeModelInterface moduleOrApplicationModel) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(get, ScopeModelInterface.class);
        return method.invoke(moduleOrApplicationModel);
    }

    public DefaultApplicationDeployer(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (DefaultApplicationDeployerInterface) DubboClassLoader.getInstance(DefaultApplicationDeployer.class.getName(), params, args);
    }
}
