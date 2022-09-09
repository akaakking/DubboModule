package org.apache.dubbo.Interface;

import org.apache.dubbo.common.context.Lifecycle;

public interface LifecycleAdapterInterface extends Lifecycle {

    void initialize();

    void start();

    void destroy();
}
