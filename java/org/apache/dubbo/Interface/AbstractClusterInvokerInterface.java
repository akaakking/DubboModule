package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.cluster.ClusterInvoker;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.rpc.cluster.Directory;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.Invocation;

public interface AbstractClusterInvokerInterface<T> extends ClusterInvoker<T> {

    Class<T> getInterface();

    URLInterface getUrl();

    URLInterface getRegistryUrl();

    boolean isAvailable();

    Directory<T> getDirectory();

    void destroy();

    boolean isDestroyed();

    Result invoke(Invocation invocation);

    String toString();
}
