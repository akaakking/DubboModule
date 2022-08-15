package org.apache.dubbo.Interface;

import java.util.Map;

public interface ProtocolBuilderInterface {
    ProtocolBuilderInterface newBuilder();
    ProtocolBuilderInterface id(String id);
    ProtocolBuilderInterface name(String name);
    ProtocolBuilderInterface host(String host);
    ProtocolBuilderInterface port(Integer port);
    ProtocolBuilderInterface contextpath(String contextpath);
    ProtocolBuilderInterface path(String path);
    ProtocolBuilderInterface threadpool(String threadpool);
    ProtocolBuilderInterface corethreads(Integer corethreads);
    ProtocolBuilderInterface threads(Integer threads);
    ProtocolBuilderInterface iothreads(Integer iothreads);
    ProtocolBuilderInterface queues(Integer queues);
    ProtocolBuilderInterface accepts(Integer accepts);
    ProtocolBuilderInterface codec(String codec);
    ProtocolBuilderInterface serialization(String serialization);
    ProtocolBuilderInterface charset(String charset);
    ProtocolBuilderInterface payload(Integer payload);
    ProtocolBuilderInterface buffer(Integer buffer);
    ProtocolBuilderInterface heartbeat(Integer heartbeat);
    ProtocolBuilderInterface accesslog(String accesslog);
    ProtocolBuilderInterface transporter(String transporter);
    ProtocolBuilderInterface exchanger(String exchanger);
    ProtocolBuilderInterface dispatcher(String dispatcher);
    ProtocolBuilderInterface dispather(String dispather);
    ProtocolBuilderInterface networker(String networker);
    ProtocolBuilderInterface server(String server);
    ProtocolBuilderInterface client(String client);
    ProtocolBuilderInterface telnet(String telnet);
    ProtocolBuilderInterface prompt(String prompt);
    ProtocolBuilderInterface status(String status);
    ProtocolBuilderInterface register(Boolean register);
    ProtocolBuilderInterface keepAlive(Boolean keepAlive);
    ProtocolBuilderInterface optimizer(String optimizer);
    ProtocolBuilderInterface extension(String extension);
    ProtocolBuilderInterface appendParameter(String key, String value);
    ProtocolBuilderInterface appendParameters(Map appendParameters);
    ProtocolBuilderInterface isDefault(Boolean isDefault);
    ProtocolConfigInterface build();
}