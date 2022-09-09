package org.apache.dubbo.Interface;

import java.util.Set;

public interface MappingChangedEventInterface {

    String getServiceKey();

    Set<String> getApps();

    String toString();
}
