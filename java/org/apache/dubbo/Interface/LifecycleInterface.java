package org.apache.dubbo.Interface;

import org.apache.dubbo.common.resource.Disposable;

public interface LifecycleInterface extends Disposable {

    void initialize();

    void start();

    void destroy();
}
