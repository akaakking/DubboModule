package org.apache.dubbo.common.status;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class StatusChecker implements StatusCheckerInterface {

    public StatusInterface check() {
        return instance.check();
    }
}
