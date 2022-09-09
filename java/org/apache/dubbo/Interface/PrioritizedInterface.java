package org.apache.dubbo.Interface;

import org.apache.dubbo.common.lang.Prioritized;

public interface PrioritizedInterface extends Comparable<Prioritized> {

    int getPriority();

    int compareTo(Prioritized that);
}
