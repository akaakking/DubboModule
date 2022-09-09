package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.configcenter.ConfigurationListener;
import java.lang.String;
import org.apache.dubbo.rpc.cluster.router.mesh.util.MeshRuleListener;
import org.apache.dubbo.common.config.configcenter.ConfigChangedEvent;
import org.apache.dubbo.Interface.ConfigChangedEventInterface;
import org.apache.dubbo.Interface.MeshRuleDispatcherInterface;

public interface MeshAppRuleListenerInterface extends ConfigurationListener {

    void receiveConfigInfo(String configInfo);

    <T> void register(MeshRuleListener subscriber);

    <T> void unregister(MeshRuleListener subscriber);

    void process(ConfigChangedEventInterface event);

    boolean isEmpty();

    MeshRuleDispatcherInterface getMeshRuleDispatcher();
}
