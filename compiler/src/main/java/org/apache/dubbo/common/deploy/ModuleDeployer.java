package org.apache.dubbo.common.deploy;

import java.util.concurrent.Future;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ModuleDeployer implements ModuleDeployerInterface {

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

    public boolean isInitialized() {
        return instance.isInitialized();
    }

    public ReferenceCacheInterface getReferenceCache() {
        return instance.getReferenceCache();
    }

    public void prepare() {
        instance.prepare();
    }

    public void setPending() {
        instance.setPending();
    }

    public boolean isBackground() {
        return instance.isBackground();
    }
}
