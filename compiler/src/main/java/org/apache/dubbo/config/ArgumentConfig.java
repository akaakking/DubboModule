package org.apache.dubbo.config;

import java.io.Serializable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ArgumentConfig implements ArgumentConfigInterface {

    public Integer getIndex() {
        return instance.getIndex();
    }

    public void setIndex(Integer index) {
        instance.setIndex(index);
    }

    public String getType() {
        return instance.getType();
    }

    public void setType(String type) {
        instance.setType(type);
    }

    public void setCallback(Boolean callback) {
        instance.setCallback(callback);
    }

    public Boolean isCallback() {
        return instance.isCallback();
    }

    public ArgumentConfig() {
        instance = (ArgumentConfigInterface) DubboClassLoader.getInstance(ArgumentConfig.class.getName());
    }

    public ArgumentConfig(Argument argument) {
        Class[] params = new Class[]{Argument.class};
        Object[] args = new Object[]{argument};
        instance = (ArgumentConfigInterface) DubboClassLoader.getInstance(ArgumentConfig.class.getName(), params, args);
    }
}
