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

    public Future start() {
        return instance.start();
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
        instance.notifyModuleChanged(moduleModel.getInternalInstance(), state.getInternalInstance());
    }

    public void checkState(ModuleModelInterface moduleModel, DeployStateInterface moduleState) {
        instance.checkState(moduleModel.getInternalInstance(), moduleState.getInternalInstance());
    }

    public static ApplicationDeployerInterface get(ScopeModelInterface moduleOrApplicationModel) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(get, ScopeModelInterface.class);
        return method.invoke(moduleOrApplicationModel);
    }

    public DefaultApplicationDeployerInterface getInternalInstance() {
        return instance;
    }

    public DefaultApplicationDeployer(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (DefaultApplicationDeployerInterface) DubboClassLoader.getInstance(DefaultApplicationDeployer.class.getName(), params, args);
    }
}
