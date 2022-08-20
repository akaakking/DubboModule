package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class AbstractMethodConfig extends AbstractConfig implements AbstractMethodConfigInterface {

    public ModuleModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public Integer getForks() {
        return instance.getForks();
    }

    public void setForks(Integer forks) {
        instance.setForks(forks);
    }

    public Integer getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(Integer timeout) {
        instance.setTimeout(timeout);
    }

    public Integer getRetries() {
        return instance.getRetries();
    }

    public void setRetries(Integer retries) {
        instance.setRetries(retries);
    }

    public String getLoadbalance() {
        return instance.getLoadbalance();
    }

    public void setLoadbalance(String loadbalance) {
        instance.setLoadbalance(loadbalance);
    }

    public Boolean isAsync() {
        return instance.isAsync();
    }

    public void setAsync(Boolean async) {
        instance.setAsync(async);
    }

    public Integer getActives() {
        return instance.getActives();
    }

    public void setActives(Integer actives) {
        instance.setActives(actives);
    }

    public Boolean getSent() {
        return instance.getSent();
    }

    public void setSent(Boolean sent) {
        instance.setSent(sent);
    }

    public String getMock() {
        return instance.getMock();
    }

    public void setMock(String mock) {
        instance.setMock(mock);
    }

    public void setMock(Object mock) {
        instance.setMock(mock);
    }

    public String getMerger() {
        return instance.getMerger();
    }

    public void setMerger(String merger) {
        instance.setMerger(merger);
    }

    public String getCache() {
        return instance.getCache();
    }

    public void setCache(String cache) {
        instance.setCache(cache);
    }

    public String getValidation() {
        return instance.getValidation();
    }

    public void setValidation(String validation) {
        instance.setValidation(validation);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public AbstractMethodConfigInterface getInternalInstance() {
        return instance;
    }

    public AbstractMethodConfigInterface getInternalInstance() {
        return instance;
    }
}
