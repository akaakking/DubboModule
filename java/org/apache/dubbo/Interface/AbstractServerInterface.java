package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.AbstractEndpointInterface;
import org.apache.dubbo.remoting.RemotingServer;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.Object;
import java.net.InetSocketAddress;
import org.apache.dubbo.remoting.Channel;

public interface AbstractServerInterface extends AbstractEndpointInterface, RemotingServer {

    void reset(URLInterface url);

    void send(Object message, boolean sent);

    void close();

    void close(int timeout);

    InetSocketAddress getLocalAddress();

    InetSocketAddress getBindAddress();

    int getAccepts();

    void connected(Channel ch);

    void disconnected(Channel ch);
}
