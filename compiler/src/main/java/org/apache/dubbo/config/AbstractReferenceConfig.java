package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractInterfaceConfig;

public class AbstractReferenceConfig extends AbstractInterfaceConfig implements AbstractReferenceConfigInterface {

    public BooleanInterface isCheck() {
        return instance.isCheck();
    }

    public void setCheck(BooleanInterface check) {
        instance.setCheck(check);
    }

    public BooleanInterface isInit() {
        return instance.isInit();
    }

    public void setInit(BooleanInterface init) {
        instance.setInit(init);
    }

    public BooleanInterface isGeneric() {
        return instance.isGeneric();
    }

    public void setGeneric(BooleanInterface generic) {
        instance.setGeneric(generic);
    }

    public StringInterface getGeneric() {
        return instance.getGeneric();
    }

    public void setGeneric(StringInterface generic) {
        instance.setGeneric(generic);
    }

    public BooleanInterface isInjvm() {
        return instance.isInjvm();
    }

    public void setInjvm(BooleanInterface injvm) {
        instance.setInjvm(injvm);
    }

    public StringInterface getFilter() {
        return instance.getFilter();
    }

    public StringInterface getListener() {
        return instance.getListener();
    }

    public void setListener(StringInterface listener) {
        instance.setListener(listener);
    }

    public BooleanInterface getLazy() {
        return instance.getLazy();
    }

    public void setLazy(BooleanInterface lazy) {
        instance.setLazy(lazy);
    }

    public void setOnconnect(StringInterface onconnect) {
        instance.setOnconnect(onconnect);
    }

    public void setOndisconnect(StringInterface ondisconnect) {
        instance.setOndisconnect(ondisconnect);
    }

    public BooleanInterface getStubevent() {
        return instance.getStubevent();
    }

    public StringInterface getReconnect() {
        return instance.getReconnect();
    }

    public void setReconnect(StringInterface reconnect) {
        instance.setReconnect(reconnect);
    }

    public BooleanInterface getSticky() {
        return instance.getSticky();
    }

    public void setSticky(BooleanInterface sticky) {
        instance.setSticky(sticky);
    }

    public StringInterface getProvidedBy() {
        return instance.getProvidedBy();
    }

    public void setProvidedBy(StringInterface providedBy) {
        instance.setProvidedBy(providedBy);
    }

    public StringInterface getRouter() {
        return instance.getRouter();
    }

    public void setRouter(StringInterface router) {
        instance.setRouter(router);
    }

    public BooleanInterface getReferAsync() {
        return instance.getReferAsync();
    }

    public void setReferAsync(BooleanInterface referAsync) {
        instance.setReferAsync(referAsync);
    }
}
