package org.apache.dubbo.Interface;

import org.apache.dubbo.common.deploy.Deployer;
import java.util.concurrent.Future;
import org.apache.dubbo.common.config.ReferenceCache;

public interface ModuleDeployerInterface extends Deployer<ModuleModelInterface> {

    void initialize();

    Future start();

    Future getStartFuture();

    void stop();

    void preDestroy();

    void postDestroy();

    boolean isInitialized();

    ReferenceCache getReferenceCache();

    void prepare();

    void setPending();

    boolean isBackground();
}
