package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model;

public interface FrameworkModelCleanerInterface{
    boolean isProtocol();
    void onDestroy(FrameworkModel frameworkModel);

}