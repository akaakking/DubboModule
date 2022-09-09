package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ServiceKeyInterface;
import org.apache.dubbo.common.ProtocolServiceKey;
import org.apache.dubbo.Interface.ProtocolServiceKeyInterface;
import java.lang.Object;

public interface ProtocolServiceKeyInterface extends ServiceKeyInterface {

    String getProtocol();

    String getServiceKeyString();

    boolean isSameWith(ProtocolServiceKeyInterface protocolServiceKey);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
