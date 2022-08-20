package org.apache.dubbo.config.bootstrap.builders;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractReferenceBuilder;

public class ConsumerBuilder extends AbstractReferenceBuilder<ConsumerConfig, ConsumerBuilder> implements ConsumerBuilderInterface {

    public ConsumerBuilderInterface isDefault(BooleanInterface isDefault) {
        return instance.isDefault(isDefault);
    }

    public ConsumerBuilderInterface client(StringInterface client) {
        return instance.client(client);
    }

    public ConsumerBuilderInterface threadPool(StringInterface threadPool) {
        return instance.threadPool(threadPool);
    }

    public ConsumerBuilderInterface coreThreads(IntegerInterface coreThreads) {
        return instance.coreThreads(coreThreads);
    }

    public ConsumerBuilderInterface threads(IntegerInterface threads) {
        return instance.threads(threads);
    }

    public ConsumerBuilderInterface queues(IntegerInterface queues) {
        return instance.queues(queues);
    }

    public ConsumerBuilderInterface shareConnections(IntegerInterface shareConnections) {
        return instance.shareConnections(shareConnections);
    }

    public ConsumerBuilderInterface urlMergeProcessor(StringInterface urlMergeProcessor) {
        return instance.urlMergeProcessor(urlMergeProcessor);
    }

    public ConsumerConfigInterface build() {
        return instance.build();
    }
}
