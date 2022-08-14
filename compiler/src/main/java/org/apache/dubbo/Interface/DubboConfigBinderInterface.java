package org.apache.dubbo.Interface;

import java.lang;

public interface DubboConfigBinderInterface{
    void setIgnoreUnknownFields(boolean ignoreUnknownFields);
    void setIgnoreInvalidFields(boolean ignoreInvalidFields);
    void bind(String prefix, CInterface dubboConfig);

}