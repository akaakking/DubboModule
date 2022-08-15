package org.apache.dubbo.Interface;


public interface ArgumentConfigInterface {
    Integer getIndex();
    void setIndex(Integer index);
    String getType();
    void setType(String type);
    void setCallback(Boolean callback);
    Boolean isCallback();
}