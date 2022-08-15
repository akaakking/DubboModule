package org.apache.dubbo.Interface;


public interface DubboBootstrapStopedEventInterface extends org.springframework.context.ApplicationEvent{
    DubboBootstrapInterface getDubboBootstrap();
}