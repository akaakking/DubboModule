/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.remoting.transport.netty4;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.config.ConfigurationUtils;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.NetUtils;
import org.apache.dubbo.remoting.Channel;
import org.apache.dubbo.remoting.ChannelHandler;
import org.apache.dubbo.remoting.Constants;
import org.apache.dubbo.remoting.RemotingException;
import org.apache.dubbo.remoting.api.NettyEventLoopFactory;
import org.apache.dubbo.remoting.api.SslContexts;
import org.apache.dubbo.remoting.api.WireProtocol;
import org.apache.dubbo.remoting.api.pu.AbstractPortUnificationServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetSocketAddress;
import java.util.Collection;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.dubbo.common.constants.CommonConstants.ANYHOST_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.ANYHOST_VALUE;
import static org.apache.dubbo.common.constants.CommonConstants.IO_THREADS_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SSL_ENABLED_KEY;
import static org.apache.dubbo.remoting.Constants.EVENT_LOOP_BOSS_POOL_NAME;
import static org.apache.dubbo.remoting.Constants.EVENT_LOOP_WORKER_POOL_NAME;

/**
 * PortUnificationServer.
 */
public class NettyPortUnificationServer extends AbstractPortUnificationServer {

    private static final Logger logger = LoggerFactory.getLogger(NettyPortUnificationServer.class);

    private final DefaultChannelGroup channels = new DefaultChannelGroup(
        GlobalEventExecutor.INSTANCE);

    private final int serverShutdownTimeoutMills;
    /**
     * netty server bootstrap.
     */
    private ServerBootstrap bootstrap;
    /**
     * the boss channel that receive connections and dispatch these to worker channel.
     */
    private io.netty.channel.Channel channel;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public NettyPortUnificationServer(URL url, ChannelHandler handler) throws RemotingException {
        super(url, handler);

        // you can customize name and type of client thread pool by THREAD_NAME_KEY and THREADPOOL_KEY in CommonConstants.
        // the handler will be wrapped: MultiMessageHandler->HeartbeatHandler->handler
        // read config before destroy
        serverShutdownTimeoutMills = ConfigurationUtils.getServerShutdownTimeout(
            getUrl().getOrDefaultModuleModel());
    }

    @Override
    public void close() {
        if (channel != null) {
            doClose();
        }
    }

    public void bind(){
        if(channel == null) {
            doOpen();
        }
    }

    @Override
    public void doOpen() {
        bootstrap = new ServerBootstrap();

        bossGroup = NettyEventLoopFactory.eventLoopGroup(1, EVENT_LOOP_BOSS_POOL_NAME);
        workerGroup = NettyEventLoopFactory.eventLoopGroup(
            getUrl().getPositiveParameter(IO_THREADS_KEY, Constants.DEFAULT_IO_THREADS),
            EVENT_LOOP_WORKER_POOL_NAME);

        final boolean enableSsl = getUrl().getParameter(SSL_ENABLED_KEY, false);
        final SslContext sslContext;
        if (enableSsl) {
            sslContext = SslContexts.buildServerSslContext(getUrl());
        } else {
            sslContext = null;
        }
        bootstrap.group(bossGroup, workerGroup)
            .channel(NettyEventLoopFactory.serverSocketChannelClass())
            .option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
            .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
            .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    // Do not add idle state handler here, because it should be added in the protocol handler.
                    final ChannelPipeline p = ch.pipeline();
                    final NettyPortUnificationServerHandler puHandler;
                    puHandler = new NettyPortUnificationServerHandler(getUrl(), sslContext, true, getProtocols(),
                        channels, NettyPortUnificationServer.this);
                    p.addLast("negotiation-protocol", puHandler);
                }
            });
        // bind

        String bindIp = getUrl().getParameter(Constants.BIND_IP_KEY, getUrl().getHost());
        int bindPort = getUrl().getParameter(Constants.BIND_PORT_KEY, getUrl().getPort());
        if (getUrl().getParameter(ANYHOST_KEY, false) || NetUtils.isInvalidLocalHost(bindIp)) {
            bindIp = ANYHOST_VALUE;
        }
        InetSocketAddress bindAddress = new InetSocketAddress(bindIp, bindPort);
        ChannelFuture channelFuture = bootstrap.bind(bindAddress);
        channelFuture.syncUninterruptibly();
        channel = channelFuture.channel();
    }

    @Override
    public void doClose(){
        final long st = System.currentTimeMillis();

        try {
            if (channel != null) {
                // unbind.
                channel.close();
                channel = null;
            }

            channels.close().await(serverShutdownTimeoutMills);
            final long cost = System.currentTimeMillis() - st;
            logger.info("Port unification server closed. cost:" + cost);
        } catch (InterruptedException e) {
            logger.warn("Interrupted while shutting down", e);
        }

        for (WireProtocol protocol : getProtocols()) {
            protocol.close();
        }

        try {
            if (bootstrap != null) {
                long timeout = serverShutdownTimeoutMills;
                long quietPeriod = Math.min(2000L, timeout);
                Future<?> bossGroupShutdownFuture = bossGroup.shutdownGracefully(quietPeriod,
                    timeout, MILLISECONDS);
                Future<?> workerGroupShutdownFuture = workerGroup.shutdownGracefully(quietPeriod,
                    timeout, MILLISECONDS);
                bossGroupShutdownFuture.awaitUninterruptibly(timeout, MILLISECONDS);
                workerGroupShutdownFuture.awaitUninterruptibly(timeout, MILLISECONDS);
            }
        } catch (Throwable e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public boolean isBound() {
        return channel.isActive();
    }

    @Override
    public Collection<Channel> getChannels() {
        return null;
    }

    @Override
    public Channel getChannel(InetSocketAddress remoteAddress) {
        return null;
    }

    public InetSocketAddress getLocalAddress() {
        return (InetSocketAddress) channel.localAddress();
    }

}
