package org.apache.dubbo.config;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class AbstractMethodConfig extends AbstractConfig implements AbstractMethodConfigInterface {

    public ModuleModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public IntegerInterface getForks() {
        return instance.getForks();
    }

    public void setForks(IntegerInterface forks) {
        instance.setForks(forks);
    }

    public IntegerInterface getTimeout() {
        return instance.getTimeout();
    }

    public void setTimeout(IntegerInterface timeout) {
        instance.setTimeout(timeout);
    }

    public IntegerInterface getRetries() {
        return instance.getRetries();
    }

    public void setRetries(IntegerInterface retries) {
        instance.setRetries(retries);
    }

    public StringInterface getLoadbalance() {
        return instance.getLoadbalance();
    }

    public void setLoadbalance(StringInterface loadbalance) {
        instance.setLoadbalance(loadbalance);
    }

    public BooleanInterface isAsync() {
        return instance.isAsync();
    }

    public void setAsync(BooleanInterface async) {
        instance.setAsync(async);
    }

    public IntegerInterface getActives() {
        return instance.getActives();
    }

    public void setActives(IntegerInterface actives) {
        instance.setActives(actives);
    }

    public BooleanInterface getSent() {
        return instance.getSent();
    }

    public void setSent(BooleanInterface sent) {
        instance.setSent(sent);
    }

    public StringInterface getMock() {
        return instance.getMock();
    }

    public void setMock(StringInterface mock) {
        instance.setMock(mock);
    }

    public void setMock(ObjectInterface mock) {
        instance.setMock(mock);
    }

    public StringInterface getMerger() {
        return instance.getMerger();
    }

    public void setMerger(StringInterface merger) {
        instance.setMerger(merger);
    }

    public StringInterface getCache() {
        return instance.getCache();
    }

    public void setCache(StringInterface cache) {
        instance.setCache(cache);
    }

    public StringInterface getValidation() {
        return instance.getValidation();
    }

    public void setValidation(StringInterface validation) {
        instance.setValidation(validation);
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }
}
