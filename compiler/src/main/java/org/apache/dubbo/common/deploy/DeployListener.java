package org.apache.dubbo.common.deploy;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DeployListener<E extends ScopeModelInterface> implements DeployListenerInterface<E> {

    public void onStarting(E scopeModel) {
        instance.onStarting(scopeModel);
    }

    public void onStarted(E scopeModel) {
        instance.onStarted(scopeModel);
    }

    public void onStopping(E scopeModel) {
        instance.onStopping(scopeModel);
    }

    public void onStopped(E scopeModel) {
        instance.onStopped(scopeModel);
    }

    public void onFailure(E scopeModel, Throwable cause) {
        instance.onFailure(scopeModel, cause);
    }
}
