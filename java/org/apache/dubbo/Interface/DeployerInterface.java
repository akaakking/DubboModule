package org.apache.dubbo.Interface;

import java.util.concurrent.Future;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.common.deploy.DeployListener;

public interface DeployerInterface<E extends ScopeModelInterface> {

    void initialize();

    Future start();

    void stop();

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

    Throwable getError();
}
