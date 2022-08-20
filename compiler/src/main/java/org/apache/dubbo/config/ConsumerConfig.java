package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractReferenceConfig;

public class ConsumerConfig extends AbstractReferenceConfig implements ConsumerConfigInterface {

    public void setTimeout(IntegerInterface timeout) {
        instance.setTimeout(timeout);
    }

    public StringInterface getClient() {
        return instance.getClient();
    }

    public void setClient(StringInterface client) {
        instance.setClient(client);
    }

    public StringInterface getThreadpool() {
        return instance.getThreadpool();
    }

    public void setThreadpool(StringInterface threadpool) {
        instance.setThreadpool(threadpool);
    }

    public IntegerInterface getCorethreads() {
        return instance.getCorethreads();
    }

    public void setCorethreads(IntegerInterface corethreads) {
        instance.setCorethreads(corethreads);
    }

    public IntegerInterface getThreads() {
        return instance.getThreads();
    }

    public void setThreads(IntegerInterface threads) {
        instance.setThreads(threads);
    }

    public IntegerInterface getQueues() {
        return instance.getQueues();
    }

    public void setQueues(IntegerInterface queues) {
        instance.setQueues(queues);
    }

    public IntegerInterface getShareconnections() {
        return instance.getShareconnections();
    }

    public void setShareconnections(IntegerInterface shareconnections) {
        instance.setShareconnections(shareconnections);
    }

    public StringInterface getUrlMergeProcessor() {
        return instance.getUrlMergeProcessor();
    }

    public void setUrlMergeProcessor(StringInterface urlMergeProcessor) {
        instance.setUrlMergeProcessor(urlMergeProcessor);
    }

    public IntegerInterface getReferThreadNum() {
        return instance.getReferThreadNum();
    }

    public void setReferThreadNum(IntegerInterface referThreadNum) {
        instance.setReferThreadNum(referThreadNum);
    }

    public BooleanInterface getReferBackground() {
        return instance.getReferBackground();
    }

    public void setReferBackground(BooleanInterface referBackground) {
        instance.setReferBackground(referBackground);
    }

    public ConsumerConfig() {
        instance = (ConsumerConfigInterface) DubboClassLoader.getInstance(ConsumerConfig.class.getName());
    }

    public ConsumerConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ConsumerConfigInterface) DubboClassLoader.getInstance(ConsumerConfig.class.getName(), params, args);
    }
}
