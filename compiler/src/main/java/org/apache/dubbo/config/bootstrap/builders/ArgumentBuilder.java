package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ArgumentBuilder implements ArgumentBuilderInterface {

    public ArgumentBuilderInterface index(IntegerInterface index) {
        return instance.index(index);
    }

    public ArgumentBuilderInterface type(StringInterface type) {
        return instance.type(type);
    }

    public ArgumentBuilderInterface callback(BooleanInterface callback) {
        return instance.callback(callback);
    }

    public ArgumentConfigInterface build() {
        return instance.build();
    }

    protected ArgumentBuilderInterface instance;
}
