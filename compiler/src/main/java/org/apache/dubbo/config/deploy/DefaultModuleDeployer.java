package org.apache.dubbo.config.deploy;

import java.util.concurrent.Future;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DefaultModuleDeployer implements DefaultModuleDeployerInterface {

    public void initialize() {
        instance.initialize();
    }

    public Future start() {
        return instance.start();
    }

    public Future getStartFuture() {
        return instance.getStartFuture();
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

    public boolean isBackground() {
        return instance.isBackground();
    }

    public ReferenceCacheInterface getReferenceCache() {
        return instance.getReferenceCache();
    }

    public void prepare() {
        instance.prepare();
    }

    protected DefaultModuleDeployerInterface instance;

    public DefaultModuleDeployer(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (DefaultModuleDeployerInterface) DubboClassLoader.getInstance(DefaultModuleDeployer.class.getName(), params, args);
    }
}
