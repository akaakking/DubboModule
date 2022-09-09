package org.apache.dubbo.Interface;

import java.lang.Object;

public interface ServiceKeyInterface {

    String getInterfaceName();

    String getGroup();

    String getVersion();

    boolean equals(Object o);

    int hashCode();

    String toString();
}
