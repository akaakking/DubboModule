package org.apache.dubbo.config;

import java.io.Serializable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.annotation.Argument;

public class ArgumentConfig implements ArgumentConfigInterface {

    public IntegerInterface getIndex() {
        return instance.getIndex();
    }

    public void setIndex(IntegerInterface index) {
        instance.setIndex(index);
    }

    public StringInterface getType() {
        return instance.getType();
    }

    public void setType(StringInterface type) {
        instance.setType(type);
    }

    public void setCallback(BooleanInterface callback) {
        instance.setCallback(callback);
    }

    public BooleanInterface isCallback() {
        return instance.isCallback();
    }

    protected ArgumentConfigInterface instance;

    public ArgumentConfig() {
        instance = (ArgumentConfigInterface) DubboClassLoader.getInstance(ArgumentConfig.class.getName());
    }

    public ArgumentConfig(Argument argument) {
        Class[] params = new Class[]{Argument.class};
        Object[] args = new Object[]{argument};
        instance = (ArgumentConfigInterface) DubboClassLoader.getInstance(ArgumentConfig.class.getName(), params, args);
    }
}
