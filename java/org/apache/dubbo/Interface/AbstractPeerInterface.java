package org.apache.dubbo.Interface;

import org.apache.dubbo.remoting.Endpoint;
import org.apache.dubbo.remoting.ChannelHandler;
import java.lang.Object;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.remoting.Channel;
import java.lang.Throwable;

public interface AbstractPeerInterface extends Endpoint, ChannelHandler {

    void send(Object message);

    void close();

    void close(int timeout);

    void startClose();

    URLInterface getUrl();

    ChannelHandler getChannelHandler();

    ChannelHandler getHandler();

    ChannelHandler getDelegateHandler();

    boolean isClosed();

    boolean isClosing();

    void connected(Channel ch);

    void disconnected(Channel ch);

    void sent(Channel ch, Object msg);

    void received(Channel ch, Object msg);

    void caught(Channel ch, Throwable ex);
}
