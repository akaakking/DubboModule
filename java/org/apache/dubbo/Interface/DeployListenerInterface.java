package org.apache.dubbo.Interface;

import E;
import java.lang.Throwable;

public interface DeployListenerInterface<E extends ScopeModelInterface> {

    void onStarting(E scopeModel);

    void onStarted(E scopeModel);

    void onStopping(E scopeModel);

    void onStopped(E scopeModel);

    void onFailure(E scopeModel, Throwable cause);
}
