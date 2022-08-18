package org.apache.dubbo.common;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Node implements NodeInterface {

    public URLInterface getUrl() {
        return instance.getUrl();
    }

    public boolean isAvailable() {
        return instance.isAvailable();
    }

    public void destroy() {
        instance.destroy();
    }
}
