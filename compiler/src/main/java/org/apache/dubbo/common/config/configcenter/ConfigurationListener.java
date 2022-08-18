package org.apache.dubbo.common.config.configcenter;

import java.util.EventListener;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigurationListener implements ConfigurationListenerInterface {

    public void process(ConfigChangedEventInterface event) {
        instance.process(event);
    }
}
