package org.apache.dubbo.common.resource;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Disposable implements DisposableInterface {

    public void destroy() {
        instance.destroy();
    }
}
