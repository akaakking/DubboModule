package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.AbstractServerInterface;
import java.util.List;
import org.apache.dubbo.remoting.api.WireProtocol;

public interface AbstractPortUnificationServerInterface extends AbstractServerInterface {

    List<WireProtocol> getProtocols();
}
