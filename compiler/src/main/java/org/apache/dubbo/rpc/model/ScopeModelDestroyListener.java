package org.apache.dubbo.rpc.model;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ScopeModelDestroyListener<T extends ScopeModelInterface> implements ScopeModelDestroyListenerInterface<T> {

    public void onDestroy(T scopeModel) {
        instance.onDestroy(scopeModel);
    }

    public boolean isProtocol() {
        return instance.isProtocol();
    }
}
