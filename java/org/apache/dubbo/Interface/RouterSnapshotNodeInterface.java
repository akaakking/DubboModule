package org.apache.dubbo.Interface;

import java.lang.String;
import java.util.List;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.Interface.RouterSnapshotNodeInterface;
import org.apache.dubbo.rpc.cluster.router.RouterSnapshotNode;

public interface RouterSnapshotNodeInterface<T> {

    String getName();

    int getBeforeSize();

    int getNodeOutputSize();

    String getRouterMessage();

    void setRouterMessage(String routerMessage);

    List<Invoker<T>> getNodeOutputInvokers();

    void setNodeOutputInvokers(List<Invoker<T>> outputInvokers);

    void setChainOutputInvokers(List<Invoker<T>> outputInvokers);

    int getChainOutputSize();

    List<Invoker<T>> getChainOutputInvokers();

    List<RouterSnapshotNodeInterface<T>> getNextNode();

    RouterSnapshotNodeInterface<T> getParentNode();

    void appendNode(RouterSnapshotNodeInterface<T> nextNode);

    String toString();

    String toString(int level);
}
