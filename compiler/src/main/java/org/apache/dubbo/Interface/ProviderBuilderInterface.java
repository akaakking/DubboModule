package org.apache.dubbo.Interface;

import java.lang;

public interface ProviderBuilderInterface{
    ProviderBuilderInterface host(String host);
    ProviderBuilderInterface port(Integer port);
    ProviderBuilderInterface contextPath(String contextPath);
    ProviderBuilderInterface threadPool(String threadPool);
    ProviderBuilderInterface threads(Integer threads);
    ProviderBuilderInterface ioThreads(Integer ioThreads);
    ProviderBuilderInterface queues(Integer queues);
    ProviderBuilderInterface accepts(Integer accepts);
    ProviderBuilderInterface codec(String codec);
    ProviderBuilderInterface charset(String charset);
    ProviderBuilderInterface payload(Integer payload);
    ProviderBuilderInterface buffer(Integer buffer);
    ProviderBuilderInterface transporter(String transporter);
    ProviderBuilderInterface exchanger(String exchanger);
    ProviderBuilderInterface dispatcher(String dispatcher);
    ProviderBuilderInterface networker(String networker);
    ProviderBuilderInterface server(String server);
    ProviderBuilderInterface client(String client);
    ProviderBuilderInterface telnet(String telnet);
    ProviderBuilderInterface prompt(String prompt);
    ProviderBuilderInterface status(String status);
    ProviderBuilderInterface wait(Integer wait);
    ProviderBuilderInterface isDefault(Boolean isDefault);
    ProviderConfigInterface build();

}