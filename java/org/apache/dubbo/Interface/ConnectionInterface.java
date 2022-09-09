package org.apache.dubbo.Interface;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.concurrent.Promise;
import io.netty.channel.ChannelFuture;
import io.netty.channel.Channel;
import java.lang.Object;
import java.net.InetSocketAddress;
import io.netty.util.ReferenceCounted;
import org.apache.dubbo.Interface.URLInterface;

public interface ConnectionInterface extends AbstractReferenceCounted {

    Promise<Void> getClosePromise();

    ChannelFuture connect();

    Channel getChannel();

    String toString();

    void onGoaway(Channel channel);

    void onConnected(Channel channel);

    boolean isAvailable();

    boolean isClosed();

    ChannelFuture write(Object request);

    InetSocketAddress getRemote();

    void close();

    ReferenceCounted touch(Object hint);

    URLInterface getUrl();
}
