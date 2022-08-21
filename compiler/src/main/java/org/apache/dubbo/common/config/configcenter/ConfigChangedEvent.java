package org.apache.dubbo.common.config.configcenter;

import java.util.EventObject;
import org.apache.dubbo.common.config.configcenter.ConfigChangeType;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigChangedEvent extends EventObject implements ConfigChangedEventInterface {

    public String getKey() {
        return instance.getKey();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public String getContent() {
        return instance.getContent();
    }

    public ConfigChangeTypeInterface getChangeType() {
        return instance.getChangeType();
    }

    public String toString() {
        return instance.toString();
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    protected ConfigChangedEventInterface instance;

    public ConfigChangedEventInterface getInternalInstance() {
        return instance;
    }

    public ConfigChangedEvent(String key, String group, String content) {
        Class[] params = new Class[]{String.class, String.class, String.class};
        Object[] args = new Object[]{key, group, content};
        instance = (ConfigChangedEventInterface) DubboClassLoader.getInstance(ConfigChangedEvent.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ConfigChangedEvent(String key, String group, String content, ConfigChangeTypeInterface changeType) {
        Class[] params = new Class[]{String.class, String.class, String.class, ConfigChangeTypeInterface.class};
        Object[] args = new Object[]{key, group, content, changeType};
        instance = (ConfigChangedEventInterface) DubboClassLoader.getInstance(ConfigChangedEvent.class.getName(), params, args);
        super.instance = this.instance;
    }

    protected ConfigChangedEvent() {
        instance = (ConfigChangedEventInterface) DubboClassLoader.getInstance(ConfigChangedEvent.class.getName());
        super.instance = this.instance;
    }
}
