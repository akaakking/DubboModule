package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractReferenceConfig;

public class ConsumerConfig extends AbstractReferenceConfig implements ConsumerConfigInterface {

    public void setTimeout(Integer timeout) {
        instance.setTimeout(timeout);
    }

    public String getClient() {
        return instance.getClient();
    }

    public void setClient(String client) {
        instance.setClient(client);
    }

    public String getThreadpool() {
        return instance.getThreadpool();
    }

    public void setThreadpool(String threadpool) {
        instance.setThreadpool(threadpool);
    }

    public Integer getCorethreads() {
        return instance.getCorethreads();
    }

    public void setCorethreads(Integer corethreads) {
        instance.setCorethreads(corethreads);
    }

    public Integer getThreads() {
        return instance.getThreads();
    }

    public void setThreads(Integer threads) {
        instance.setThreads(threads);
    }

    public Integer getQueues() {
        return instance.getQueues();
    }

    public void setQueues(Integer queues) {
        instance.setQueues(queues);
    }

    public Integer getShareconnections() {
        return instance.getShareconnections();
    }

    public void setShareconnections(Integer shareconnections) {
        instance.setShareconnections(shareconnections);
    }

    public String getUrlMergeProcessor() {
        return instance.getUrlMergeProcessor();
    }

    public void setUrlMergeProcessor(String urlMergeProcessor) {
        instance.setUrlMergeProcessor(urlMergeProcessor);
    }

    public Integer getReferThreadNum() {
        return instance.getReferThreadNum();
    }

    public void setReferThreadNum(Integer referThreadNum) {
        instance.setReferThreadNum(referThreadNum);
    }

    public Boolean getReferBackground() {
        return instance.getReferBackground();
    }

    public void setReferBackground(Boolean referBackground) {
        instance.setReferBackground(referBackground);
    }

    public ConsumerConfigInterface getInternalInstance() {
        return instance;
    }

    public protected ConsumerConfig() {
        instance = (ConsumerConfigInterface) DubboClassLoader.getInstance(ConsumerConfig.class.getName());
        super.instance = instance;
    }

    public ConsumerConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ConsumerConfigInterface) DubboClassLoader.getInstance(ConsumerConfig.class.getName(), params, args);
        super.instance = instance;
    }
}
