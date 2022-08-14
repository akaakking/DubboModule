package org.apache.dubbo.Interface;


public interface DubboShutdownHookInterface{
    void run();
    void register();
    void unregister();
    boolean getRegistered();

}