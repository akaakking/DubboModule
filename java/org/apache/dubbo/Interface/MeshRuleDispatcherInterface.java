package org.apache.dubbo.Interface;

import java.util.Map;
import java.util.List;
import org.apache.dubbo.rpc.cluster.router.mesh.util.MeshRuleListener;
import java.util.Set;

public interface MeshRuleDispatcherInterface {

    void post(Map<String, List<Map<String, Object>>> ruleMap);

    void register(MeshRuleListener listener);

    void unregister(MeshRuleListener listener);

    boolean isEmpty();

    Map<String, Set<MeshRuleListener>> getListenerMap();
}
