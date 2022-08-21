package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractInterfaceConfig;

public class AbstractReferenceConfig extends AbstractInterfaceConfig implements AbstractReferenceConfigInterface {

    public Boolean isCheck() {
        return instance.isCheck();
    }

    public void setCheck(Boolean check) {
        instance.setCheck(check);
    }

    public Boolean isInit() {
        return instance.isInit();
    }

    public void setInit(Boolean init) {
        instance.setInit(init);
    }

    public Boolean isGeneric() {
        return instance.isGeneric();
    }

    public void setGeneric(Boolean generic) {
        instance.setGeneric(generic);
    }

    public String getGeneric() {
        return instance.getGeneric();
    }

    public void setGeneric(String generic) {
        instance.setGeneric(generic);
    }

    public Boolean isInjvm() {
        return instance.isInjvm();
    }

    public void setInjvm(Boolean injvm) {
        instance.setInjvm(injvm);
    }

    public String getFilter() {
        return instance.getFilter();
    }

    public String getListener() {
        return instance.getListener();
    }

    public void setListener(String listener) {
        instance.setListener(listener);
    }

    public Boolean getLazy() {
        return instance.getLazy();
    }

    public void setLazy(Boolean lazy) {
        instance.setLazy(lazy);
    }

    public void setOnconnect(String onconnect) {
        instance.setOnconnect(onconnect);
    }

    public void setOndisconnect(String ondisconnect) {
        instance.setOndisconnect(ondisconnect);
    }

    public Boolean getStubevent() {
        return instance.getStubevent();
    }

    public String getReconnect() {
        return instance.getReconnect();
    }

    public void setReconnect(String reconnect) {
        instance.setReconnect(reconnect);
    }

    public Boolean getSticky() {
        return instance.getSticky();
    }

    public void setSticky(Boolean sticky) {
        instance.setSticky(sticky);
    }

    public String getProvidedBy() {
        return instance.getProvidedBy();
    }

    public void setProvidedBy(String providedBy) {
        instance.setProvidedBy(providedBy);
    }

    public String getRouter() {
        return instance.getRouter();
    }

    public void setRouter(String router) {
        instance.setRouter(router);
    }

    public Boolean getReferAsync() {
        return instance.getReferAsync();
    }

    public void setReferAsync(Boolean referAsync) {
        instance.setReferAsync(referAsync);
    }

    public AbstractReferenceConfigInterface getInternalInstance() {
        return instance;
    }

    protected AbstractReferenceConfig() {
    }
}
