package org.apache.dubbo.common.deploy;

import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractDeployer<E extends ScopeModelInterface> implements AbstractDeployerInterface<E> {

    public boolean isPending() {
        return instance.isPending();
    }

    public boolean isRunning() {
        return instance.isRunning();
    }

    public boolean isStarted() {
        return instance.isStarted();
    }

    public boolean isStarting() {
        return instance.isStarting();
    }

    public boolean isStopping() {
        return instance.isStopping();
    }

    public boolean isStopped() {
        return instance.isStopped();
    }

    public boolean isFailed() {
        return instance.isFailed();
    }

    public DeployStateInterface getState() {
        return instance.getState();
    }

    public void addDeployListener(DeployListenerInterface<E> listener) {
        instance.addDeployListener(listener);
    }

    public void removeDeployListener(DeployListenerInterface<E> listener) {
        instance.removeDeployListener(listener);
    }

    public void setPending() {
        instance.setPending();
    }

    public Throwable getError() {
        return instance.getError();
    }

    public boolean isInitialized() {
        return instance.isInitialized();
    }

    protected AbstractDeployerInterface instance;

    public AbstractDeployerInterface getInternalInstance() {
        return instance;
    }
}
