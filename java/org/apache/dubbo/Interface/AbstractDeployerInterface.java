package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.common.deploy.Deployer;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.common.deploy.DeployListener;

public interface AbstractDeployerInterface<E extends ScopeModelInterface> extends Deployer<E> {

    boolean isPending();

    boolean isRunning();

    boolean isStarted();

    boolean isStarting();

    boolean isStopping();

    boolean isStopped();

    boolean isFailed();

    DeployState getState();

    void addDeployListener(DeployListener<E> listener);

    void removeDeployListener(DeployListener<E> listener);

    void setPending();

    Throwable getError();

    boolean isInitialized();
}
