package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.model.ScopeModelAware;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.Interface.FrameworkModelInterface;
import org.apache.dubbo.rpc.ProxyFactory;
import java.util.Map;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.registry.NotifyListener;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.common.URL;
import java.lang.Class;
import org.apache.dubbo.rpc.cluster.ClusterInvoker;
import org.apache.dubbo.rpc.cluster.Cluster;
import org.apache.dubbo.registry.Registry;
import java.lang.String;
import java.util.List;
import org.apache.dubbo.rpc.ProtocolServer;

public interface RegistryProtocolInterface extends Protocol, ScopeModelAware {

    void setFrameworkModel(FrameworkModelInterface frameworkModel);

    void setProtocol(Protocol protocol);

    void setProxyFactory(ProxyFactory proxyFactory);

    int getDefaultPort();

    Map<URLInterface, NotifyListener> getOverrideListeners();

    <T> Exporter<T> export(Invoker<T> originInvoker);

    <T> void reExport(Exporter<T> exporter, URLInterface newInvokerUrl);

    <T> void reExport(Invoker<T> originInvoker, URLInterface newInvokerUrl);

    <T> Invoker<T> refer(Class<T> type, URLInterface url);

    <T> ClusterInvoker<T> getServiceDiscoveryInvoker(Cluster cluster, Registry registry, Class<T> type, URLInterface url);

    <T> ClusterInvoker<T> getInvoker(Cluster cluster, Registry registry, Class<T> type, URLInterface url);

    <T> void reRefer(ClusterInvoker<?> invoker, URLInterface newSubscribeUrl);

    String[] getParamsToRegistry(String[] defaultKeys, String[] additionalParameterKeys);

    void destroy();

    List<ProtocolServer> getServers();
}
