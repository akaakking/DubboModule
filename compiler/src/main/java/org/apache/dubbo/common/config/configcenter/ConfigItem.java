package org.apache.dubbo.common.config.configcenter;

import java.lang.String;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigItem implements ConfigItemInterface {

    public String getContent() {
        return instance.getContent();
    }

    public void setContent(String content) {
        instance.setContent(content);
    }

    public Object getTicket() {
        return instance.getTicket();
    }

    public void setTicket(Object ticket) {
        instance.setTicket(ticket);
    }

    protected ConfigItemInterface instance;

    public ConfigItemInterface getInternalInstance() {
        return instance;
    }

    public ConfigItem(String content, Object ticket) {
        Class[] params = new Class[]{String.class, Object.class};
        Object[] args = new Object[]{content, ticket};
        instance = (ConfigItemInterface) DubboClassLoader.getInstance(ConfigItem.class.getName(), params, args);
    }

    public ConfigItem() {
        instance = (ConfigItemInterface) DubboClassLoader.getInstance(ConfigItem.class.getName());
    }
}
