package org.apache.dubbo.Interface;

import org.springframework.core.env.Environment;

public interface AbstractDubboConfigBinderInterface {
    boolean isIgnoreUnknownFields();
    void setIgnoreUnknownFields(boolean ignoreUnknownFields);
    boolean isIgnoreInvalidFields();
    void setIgnoreInvalidFields(boolean ignoreInvalidFields);
    void setEnvironment(Environment environment);
}