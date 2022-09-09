package org.apache.dubbo.Interface;

import org.apache.dubbo.registry.client.event.ServiceInstancesChangedEvent;
import org.apache.dubbo.Interface.ServiceInstancesChangedEventInterface;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.registry.NotifyListener;
import java.lang.String;
import java.util.Set;
import java.util.Map;
import java.util.List;
import org.apache.dubbo.registry.client.ServiceInstance;
import java.lang.Object;

public interface ServiceInstancesChangedListenerInterface {

    void onEvent(ServiceInstancesChangedEventInterface event);

    void addListenerAndNotify(URLInterface url, NotifyListener listener);

    void removeListener(String serviceKey, NotifyListener notifyListener);

    boolean hasListeners();

    Set<String> getServiceNames();

    void setUrl(URLInterface url);

    URLInterface getUrl();

    Map<String, List<ServiceInstance>> getAllInstances();

    void destroy();

    boolean isDestroyed();

    boolean equals(Object o);

    int hashCode();
}
