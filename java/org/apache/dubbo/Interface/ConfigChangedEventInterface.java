package org.apache.dubbo.Interface;

import java.util.EventObject;
import org.apache.dubbo.common.config.configcenter.ConfigChangeType;
import java.lang.Object;

public interface ConfigChangedEventInterface extends EventObject {

    String getKey();

    String getGroup();

    String getContent();

    ConfigChangeType getChangeType();

    String toString();

    boolean equals(Object o);

    int hashCode();
}
