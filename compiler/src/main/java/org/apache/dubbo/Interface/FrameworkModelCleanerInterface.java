package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.FrameworkModel;

public interface FrameworkModelCleanerInterface extends Object, ScopeModelDestroyListener{
    boolean isProtocol();
    void onDestroy(FrameworkModel frameworkModel);
}