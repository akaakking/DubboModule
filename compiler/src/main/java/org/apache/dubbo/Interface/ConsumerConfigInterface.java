package org.apache.dubbo.Interface;

import java.lang;

public interface ConsumerConfigInterface{
    void setTimeout(Integer timeout);
    String getClient();
    void setClient(String client);
    String getThreadpool();
    void setThreadpool(String threadpool);
    Integer getCorethreads();
    void setCorethreads(Integer corethreads);
    Integer getThreads();
    void setThreads(Integer threads);
    Integer getQueues();
    void setQueues(Integer queues);
    Integer getShareconnections();
    void setShareconnections(Integer shareconnections);
    String getUrlMergeProcessor();
    void setUrlMergeProcessor(String urlMergeProcessor);
    Integer getReferThreadNum();
    void setReferThreadNum(Integer referThreadNum);
    Boolean getReferBackground();
    void setReferBackground(Boolean referBackground);

}