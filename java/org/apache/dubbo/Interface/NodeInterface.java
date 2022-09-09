package org.apache.dubbo.Interface;

public interface NodeInterface {

    URLInterface getUrl();

    boolean isAvailable();

    void destroy();
}
