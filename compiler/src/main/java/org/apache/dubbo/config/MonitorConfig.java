package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class MonitorConfig extends AbstractConfig implements MonitorConfigInterface {

    public String getAddress() {
        return instance.getAddress();
    }

    public void setAddress(String address) {
        instance.setAddress(address);
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public String getUsername() {
        return instance.getUsername();
    }

    public void setUsername(String username) {
        instance.setUsername(username);
    }

    public String getPassword() {
        return instance.getPassword();
    }

    public void setPassword(String password) {
        instance.setPassword(password);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public String getInterval() {
        return instance.getInterval();
    }

    public void setInterval(String interval) {
        instance.setInterval(interval);
    }

    public boolean isValid() {
        return instance.isValid();
    }

    public MonitorConfigInterface getInternalInstance() {
        return instance;
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
