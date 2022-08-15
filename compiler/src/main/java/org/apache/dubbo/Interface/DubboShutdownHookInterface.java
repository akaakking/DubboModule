package org.apache.dubbo.Interface;


public interface DubboShutdownHookInterface extends Thread{
    void run();
    void register();
    void unregister();
    boolean getRegistered();
}