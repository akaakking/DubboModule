package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;
import org.apache.dubbo.Interface.RestMethodMetadataInterface;
import java.lang.Object;

public interface ServiceRestMetadataInterface extends Serializable {

    String getServiceInterface();

    void setServiceInterface(String serviceInterface);

    String getVersion();

    void setVersion(String version);

    String getGroup();

    void setGroup(String group);

    Set<RestMethodMetadataInterface> getMeta();

    void setMeta(Set<RestMethodMetadataInterface> meta);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
