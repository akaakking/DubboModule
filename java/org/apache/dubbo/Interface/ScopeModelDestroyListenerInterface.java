package org.apache.dubbo.Interface;

import T;

public interface ScopeModelDestroyListenerInterface<T extends ScopeModelInterface> {

    void onDestroy(T scopeModel);

    boolean isProtocol();
}
