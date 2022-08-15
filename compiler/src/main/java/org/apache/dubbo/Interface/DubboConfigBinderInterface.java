package org.apache.dubbo.Interface;


public interface DubboConfigBinderInterface {
    void setIgnoreUnknownFields(boolean ignoreUnknownFields);
    void setIgnoreInvalidFields(boolean ignoreInvalidFields);
    void bind(String prefix, C dubboConfig);
}