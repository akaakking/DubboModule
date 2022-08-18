package org.apache.dubbo.common.extension;

import java.lang.reflect.Method;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExtensionPostProcessor implements ExtensionPostProcessorInterface {

    public Object postProcessBeforeInitialization(Object instance, String name) {
        return instance.postProcessBeforeInitialization(instance, name);
    }

    public Object postProcessAfterInitialization(Object instance, String name) {
        return instance.postProcessAfterInitialization(instance, name);
    }
}
