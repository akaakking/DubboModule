package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.AbstractPeerInterface;
import org.apache.dubbo.common.Resetable;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.common.Parameters;
import org.apache.dubbo.Interface.ParametersInterface;

public interface AbstractEndpointInterface extends AbstractPeerInterface, Resetable {

    void reset(URLInterface url);

    void reset(ParametersInterface parameters);
}
