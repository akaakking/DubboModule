package org.apache.dubbo.common.lang;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Prioritized implements PrioritizedInterface {

    public int getPriority() {
        return instance.getPriority();
    }

    public int compareTo(PrioritizedInterface that) {
        return instance.compareTo(that);
    }
}
