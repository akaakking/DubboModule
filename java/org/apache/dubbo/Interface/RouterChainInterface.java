package org.apache.dubbo.Interface;

import java.util.List;
import org.apache.dubbo.rpc.cluster.Router;
import org.apache.dubbo.rpc.cluster.router.state.StateRouter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.rpc.cluster.router.state.BitList;
import org.apache.dubbo.Interface.BitListInterface;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.Interface.RouterSnapshotNodeInterface;

public interface RouterChainInterface<T> {

    void initWithRouters(List<Router> builtinRouters);

    void addRouters(List<Router> routers);

    List<Router> getRouters();

    StateRouter<T> getHeadStateRouter();

    List<Invoker<T>> route(URLInterface url, BitListInterface<Invoker<T>> availableInvokers, Invocation invocation);

    List<Invoker<T>> routeAndPrint(URLInterface url, BitListInterface<Invoker<T>> availableInvokers, Invocation invocation);

    List<Invoker<T>> simpleRoute(URLInterface url, BitListInterface<Invoker<T>> availableInvokers, Invocation invocation);

    RouterSnapshotNodeInterface<T> buildRouterSnapshot(URLInterface url, BitListInterface<Invoker<T>> availableInvokers, Invocation invocation);

    void setInvokers(BitListInterface<Invoker<T>> invokers);

    void setHeadStateRouter(StateRouter<T> headStateRouter);

    List<StateRouter<T>> getStateRouters();

    void destroy();
}
