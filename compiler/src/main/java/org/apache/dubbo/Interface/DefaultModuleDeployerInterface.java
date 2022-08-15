package org.apache.dubbo.Interface;

import java.util.concurrent.Future;
import org.apache.dubbo.common.config.ReferenceCache;

public interface DefaultModuleDeployerInterface extends AbstractDeployer, ModuleDeployer{
    void initialize();
    Future start();
    Future getStartFuture();
    void stop();
    void preDestroy();
    void postDestroy();
    boolean isBackground();
    ReferenceCache getReferenceCache();
    void prepare();
}