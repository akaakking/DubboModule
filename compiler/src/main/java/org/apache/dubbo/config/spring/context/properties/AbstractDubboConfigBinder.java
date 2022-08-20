package org.apache.dubbo.config.spring.context.properties;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AbstractDubboConfigBinder implements AbstractDubboConfigBinderInterface {

    public boolean isIgnoreUnknownFields() {
        return instance.isIgnoreUnknownFields();
    }

    public void setIgnoreUnknownFields(boolean ignoreUnknownFields) {
        instance.setIgnoreUnknownFields(ignoreUnknownFields);
    }

    public boolean isIgnoreInvalidFields() {
        return instance.isIgnoreInvalidFields();
    }

    public void setIgnoreInvalidFields(boolean ignoreInvalidFields) {
        instance.setIgnoreInvalidFields(ignoreInvalidFields);
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment);
    }

    protected AbstractDubboConfigBinderInterface instance;
}
