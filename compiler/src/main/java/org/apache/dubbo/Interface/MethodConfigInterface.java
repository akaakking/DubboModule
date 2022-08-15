package org.apache.dubbo.Interface;

import java.util.List;
import org.apache.dubbo.rpc.model.AsyncMethodInfo;

public interface MethodConfigInterface extends AbstractMethodConfig{
    List constructMethodConfig(MethodInterface methods);
    List getPrefixes();
    AsyncMethodInfo convertMethodConfig2AsyncInfo();
    String getName();
    void setName(String name);
    Integer getStat();
    void setStat(Integer stat);
    Boolean isRetry();
    void setRetry(Boolean retry);
    Boolean isReliable();
    void setReliable(Boolean reliable);
    Integer getExecutes();
    void setExecutes(Integer executes);
    Boolean getDeprecated();
    void setDeprecated(Boolean deprecated);
    List getArguments();
    void setArguments(List arguments);
    Boolean getSticky();
    void setSticky(Boolean sticky);
    Object getOnreturn();
    void setOnreturn(Object onreturn);
    String getOnreturnMethod();
    void setOnreturnMethod(String onreturnMethod);
    Object getOnthrow();
    void setOnthrow(Object onthrow);
    String getOnthrowMethod();
    void setOnthrowMethod(String onthrowMethod);
    Object getOninvoke();
    void setOninvoke(Object oninvoke);
    String getOninvokeMethod();
    void setOninvokeMethod(String oninvokeMethod);
    Boolean isReturn();
    void setReturn(Boolean isReturn);
    String getService();
    void setService(String service);
    String getServiceId();
    void setServiceId(String serviceId);
    void setParentPrefix(String parentPrefix);
    String getParentPrefix();
    void addArgument(ArgumentConfigInterface argumentConfig);
}