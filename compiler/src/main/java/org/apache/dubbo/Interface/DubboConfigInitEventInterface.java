package org.apache.dubbo.Interface;

import org.springframework.context.ApplicationContext;

public interface DubboConfigInitEventInterface extends org.springframework.context.ApplicationEvent{
    ApplicationContext getApplicationContext();
}