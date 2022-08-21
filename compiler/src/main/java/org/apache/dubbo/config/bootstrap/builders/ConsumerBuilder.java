package org.apache.dubbo.config.bootstrap.builders;

import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractReferenceBuilder;

public class ConsumerBuilder extends AbstractReferenceBuilder<ConsumerConfig, ConsumerBuilder> implements ConsumerBuilderInterface {

    public ConsumerBuilderInterface isDefault(Boolean isDefault) {
        return instance.isDefault(isDefault);
    }

    public ConsumerBuilderInterface client(String client) {
        return instance.client(client);
    }

    public ConsumerBuilderInterface threadPool(String threadPool) {
        return instance.threadPool(threadPool);
    }

    public ConsumerBuilderInterface coreThreads(Integer coreThreads) {
        return instance.coreThreads(coreThreads);
    }

    public ConsumerBuilderInterface threads(Integer threads) {
        return instance.threads(threads);
    }

    public ConsumerBuilderInterface queues(Integer queues) {
        return instance.queues(queues);
    }

    public ConsumerBuilderInterface shareConnections(Integer shareConnections) {
        return instance.shareConnections(shareConnections);
    }

    public ConsumerBuilderInterface urlMergeProcessor(String urlMergeProcessor) {
        return instance.urlMergeProcessor(urlMergeProcessor);
    }

    public ConsumerConfigInterface build() {
        return instance.build();
    }

    protected ConsumerBuilderInterface instance;

    public ConsumerBuilderInterface getInternalInstance() {
        return instance;
    }

    protected ConsumerBuilder() {
        instance = (ConsumerBuilderInterface) DubboClassLoader.getInstance(ConsumerBuilder.class.getName());
        super.instance = this.instance;
    }
}
