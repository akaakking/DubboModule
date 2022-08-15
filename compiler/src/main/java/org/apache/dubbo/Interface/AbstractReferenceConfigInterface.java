package org.apache.dubbo.Interface;


public interface AbstractReferenceConfigInterface {
    Boolean isCheck();
    void setCheck(Boolean check);
    Boolean isInit();
    void setInit(Boolean init);
    Boolean isGeneric();
    void setGeneric(Boolean generic);
    String getGeneric();
    void setGeneric(String generic);
    Boolean isInjvm();
    void setInjvm(Boolean injvm);
    String getFilter();
    String getListener();
    void setListener(String listener);
    Boolean getLazy();
    void setLazy(Boolean lazy);
    void setOnconnect(String onconnect);
    void setOndisconnect(String ondisconnect);
    Boolean getStubevent();
    String getReconnect();
    void setReconnect(String reconnect);
    Boolean getSticky();
    void setSticky(Boolean sticky);
    String getProvidedBy();
    void setProvidedBy(String providedBy);
    String getRouter();
    void setRouter(String router);
    Boolean getReferAsync();
    void setReferAsync(Boolean referAsync);
}