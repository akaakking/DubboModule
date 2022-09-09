package org.apache.dubbo.Interface;

import org.apache.dubbo.common.Node;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.Invocation;

public interface InvokerInterface<T> extends Node {

    Class<T> getInterface();

    Result invoke(Invocation invocation);

    void destroyAll();
}
