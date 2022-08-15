package org.apache.dubbo.Interface;


public interface ConsumerBuilderInterface extends AbstractReferenceBuilder{
    ConsumerBuilderInterface isDefault(Boolean isDefault);
    ConsumerBuilderInterface client(String client);
    ConsumerBuilderInterface threadPool(String threadPool);
    ConsumerBuilderInterface coreThreads(Integer coreThreads);
    ConsumerBuilderInterface threads(Integer threads);
    ConsumerBuilderInterface queues(Integer queues);
    ConsumerBuilderInterface shareConnections(Integer shareConnections);
    ConsumerBuilderInterface urlMergeProcessor(String urlMergeProcessor);
    ConsumerConfigInterface build();
}