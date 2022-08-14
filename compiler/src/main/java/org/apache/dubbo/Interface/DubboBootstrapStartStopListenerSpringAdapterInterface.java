package org.apache.dubbo.Interface;


public interface DubboBootstrapStartStopListenerSpringAdapterInterface{
    void onStart(DubboBootstrapInterface bootstrap);
    void onStop(DubboBootstrapInterface bootstrap);

}