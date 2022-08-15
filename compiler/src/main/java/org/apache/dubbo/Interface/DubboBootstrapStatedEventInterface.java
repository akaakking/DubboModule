package org.apache.dubbo.Interface;


public interface DubboBootstrapStatedEventInterface extends org.springframework.context.ApplicationEvent{
    DubboBootstrapInterface getDubboBootstrap();
}