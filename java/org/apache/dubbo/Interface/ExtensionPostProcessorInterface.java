package org.apache.dubbo.Interface;

import java.lang.Object;
import java.lang.String;

public interface ExtensionPostProcessorInterface {

    Object postProcessBeforeInitialization(Object instance, String name);

    Object postProcessAfterInitialization(Object instance, String name);
}
