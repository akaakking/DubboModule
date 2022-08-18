package org.apache.dubbo.common.deploy;

import java.util.Map;
import java.util.concurrent.Future;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Deployer<E extends ScopeModelInterface> implements DeployerInterface<E> {

    public void initialize() {
        instance.initialize();
    }

    public Future start() {
        return instance.start();
    }

    public void stop() {
        instance.stop();
    }

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

    public DeployState getState() {
        return instance.getState();
    }

    public void addDeployListener(DeployListenerInterface<E> listener) {
        instance.addDeployListener(listener);
    }

    public void removeDeployListener(DeployListenerInterface<E> listener) {
        instance.removeDeployListener(listener);
    }

    public Throwable getError() {
        return instance.getError();
    }
}
