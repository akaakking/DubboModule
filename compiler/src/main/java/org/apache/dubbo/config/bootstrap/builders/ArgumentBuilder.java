package org.apache.dubbo.config.bootstrap.builders;

import java.lang.Integer;
import java.lang.String;
import java.lang.Boolean;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ArgumentBuilder implements ArgumentBuilderInterface {

    public ArgumentBuilderInterface index(Integer index) {
        return instance.index(index);
    }

    public ArgumentBuilderInterface type(String type) {
        return instance.type(type);
    }

    public ArgumentBuilderInterface callback(Boolean callback) {
        return instance.callback(callback);
    }

    public ArgumentConfigInterface build() {
        return instance.build();
    }

    protected ArgumentBuilderInterface instance;

    public ArgumentBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ArgumentBuilder() {
        instance = (ArgumentBuilderInterface) DubboClassLoader.getInstance(ArgumentBuilder.class.getName());
    }
}
