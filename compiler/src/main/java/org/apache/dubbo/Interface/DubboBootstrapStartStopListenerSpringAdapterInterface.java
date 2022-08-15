package org.apache.dubbo.Interface;


public interface DubboBootstrapStartStopListenerSpringAdapterInterface extends Object, DubboBootstrapStartStopListener{
    void onStart(DubboBootstrapInterface bootstrap);
    void onStop(DubboBootstrapInterface bootstrap);
}