package org.apache.dubbo.Interface;


public interface DubboConfigBinderInterface extends org.springframework.context.EnvironmentAware{
    void setIgnoreUnknownFields(boolean ignoreUnknownFields);
    void setIgnoreInvalidFields(boolean ignoreInvalidFields);
    void bind(String prefix, C dubboConfig);
}