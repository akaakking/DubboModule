package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface AbstractServiceBuilderInterface<T>{
    BInterface version(String version);
    BInterface group(String group);
    BInterface deprecated(Boolean deprecated);
    BInterface delay(Integer delay);
    BInterface export(Boolean export);
    BInterface weight(Integer weight);
    BInterface document(String document);
    BInterface dynamic(Boolean dynamic);
    BInterface token(String token);
    BInterface token(Boolean token);
    BInterface accesslog(String accesslog);
    BInterface accesslog(Boolean accesslog);
    BInterface addProtocols(List protocols);
    BInterface addProtocol(ProtocolConfigInterface protocol);
    BInterface protocolIds(String protocolIds);
    BInterface executes(Integer executes);
    BInterface register(Boolean register);
    BInterface warmup(Integer warmup);
    BInterface serialization(String serialization);
    void build(TInterface instance);

}