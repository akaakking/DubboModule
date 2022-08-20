package org.apache.dubbo.common.config.configcenter;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigItem implements ConfigItemInterface {

    public StringInterface getContent() {
        return instance.getContent();
    }

    public void setContent(StringInterface content) {
        instance.setContent(content);
    }

    public ObjectInterface getTicket() {
        return instance.getTicket();
    }

    public void setTicket(ObjectInterface ticket) {
        instance.setTicket(ticket);
    }

    protected ConfigItemInterface instance;

    public ConfigItem(String content, Object ticket) {
        Class[] params = new Class[]{String.class, Object.class};
        Object[] args = new Object[]{content, ticket};
        instance = (ConfigItemInterface) DubboClassLoader.getInstance(ConfigItem.class.getName(), params, args);
    }

    public ConfigItem() {
        instance = (ConfigItemInterface) DubboClassLoader.getInstance(ConfigItem.class.getName());
    }
}
