package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.rpc.model;

public interface AbstractMethodConfigInterface{
    ModuleModel getScopeModel();
    Integer getForks();
    void setForks(Integer forks);
    Integer getTimeout();
    void setTimeout(Integer timeout);
    Integer getRetries();
    void setRetries(Integer retries);
    String getLoadbalance();
    void setLoadbalance(String loadbalance);
    Boolean isAsync();
    void setAsync(Boolean async);
    Integer getActives();
    void setActives(Integer actives);
    Boolean getSent();
    void setSent(Boolean sent);
    String getMock();
    void setMock(String mock);
    void setMock(Object mock);
    String getMerger();
    void setMerger(String merger);
    String getCache();
    void setCache(String cache);
    String getValidation();
    void setValidation(String validation);
    Map getParameters();
    void setParameters(Map parameters);

}