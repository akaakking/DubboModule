package org.apache.dubbo.Interface

import org.apache.dubbo.remoting.zookeeper
import java.lang
import java.util
import java.util.concurrent
import org.apache.dubbo.common.config.configcenter
import org.apache.dubbo.common

public interface AbstractZookeeperClientInterface<T>{
    URL getUrl();
    void delete(String path);
    void create(String path, boolean ephemeral);
    void addStateListener(StateListener listener);
    void removeStateListener(StateListener listener);
    Set getSessionListeners();
    List addChildListener(String path, ChildListener listener);
    void addDataListener(String path, DataListener listener);
    void addDataListener(String path, DataListener listener, Executor executor);
    void removeDataListener(String path, DataListener listener);
    void removeChildListener(String path, ChildListener listener);
    void close();
    void create(String path, String content, boolean ephemeral);
    void createOrUpdate(String path, String content, boolean ephemeral, int version);
    String getContent(String path);
    ConfigItem getConfigItem(String path);
    boolean checkExists(String path);

}