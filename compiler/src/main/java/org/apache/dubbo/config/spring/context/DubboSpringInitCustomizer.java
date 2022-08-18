package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboSpringInitCustomizer implements DubboSpringInitCustomizerInterface {

    public void customize(DubboSpringInitContextInterface context) {
        instance.customize(context);
    }
}
