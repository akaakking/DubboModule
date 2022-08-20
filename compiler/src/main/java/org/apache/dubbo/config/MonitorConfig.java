package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class MonitorConfig extends AbstractConfig implements MonitorConfigInterface {

    public StringInterface getAddress() {
        return instance.getAddress();
    }

    public void setAddress(StringInterface address) {
        instance.setAddress(address);
    }

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(StringInterface protocol) {
        instance.setProtocol(protocol);
    }

    public StringInterface getUsername() {
        return instance.getUsername();
    }

    public void setUsername(StringInterface username) {
        instance.setUsername(username);
    }

    public StringInterface getPassword() {
        return instance.getPassword();
    }

    public void setPassword(StringInterface password) {
        instance.setPassword(password);
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public void setGroup(StringInterface group) {
        instance.setGroup(group);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public void setVersion(StringInterface version) {
        instance.setVersion(version);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public StringInterface getInterval() {
        return instance.getInterval();
    }

    public void setInterval(StringInterface interval) {
        instance.setInterval(interval);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public MonitorConfig() {
        instance = (MonitorConfigInterface) DubboClassLoader.getInstance(MonitorConfig.class.getName());
    }

    public MonitorConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (MonitorConfigInterface) DubboClassLoader.getInstance(MonitorConfig.class.getName(), params, args);
    }

    public MonitorConfig(String address) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{address};
        instance = (MonitorConfigInterface) DubboClassLoader.getInstance(MonitorConfig.class.getName(), params, args);
    }

    public MonitorConfig(ApplicationModelInterface applicationModel, String address) {
        Class[] params = new Class[]{ApplicationModelInterface.class, String.class};
        Object[] args = new Object[]{applicationModel, address};
        instance = (MonitorConfigInterface) DubboClassLoader.getInstance(MonitorConfig.class.getName(), params, args);
    }
}
