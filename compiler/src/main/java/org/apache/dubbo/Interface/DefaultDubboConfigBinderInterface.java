package org.apache.dubbo.Interface;


public interface DefaultDubboConfigBinderInterface extends AbstractDubboConfigBinder{
    void bind(String prefix, C dubboConfig);
}