package org.apache.dubbo.Interface;


public interface DubboBootstrapStartStopListenerInterface{
    void onStart(DubboBootstrapInterface bootstrap);
    void onStop(DubboBootstrapInterface bootstrap);

}