package org.apache.dubbo.Interface;

import ;

public interface AbstractDubboConfigBinderInterface{
    boolean isIgnoreUnknownFields();
    void setIgnoreUnknownFields(boolean ignoreUnknownFields);
    boolean isIgnoreInvalidFields();
    void setIgnoreInvalidFields(boolean ignoreInvalidFields);
    void setEnvironment(org.springframework.core.env.Environment environment);

}