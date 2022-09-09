package org.apache.dubbo.Interface;

import java.util.EventListener;
import org.apache.dubbo.common.config.configcenter.ConfigChangedEvent;

public interface ConfigurationListenerInterface extends EventListener {

    void process(ConfigChangedEventInterface event);
}
