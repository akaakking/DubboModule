package org.apache.dubbo.Interface;

import java.util.List;

public interface AbstractServiceBuilderInterface<T><B> {
    B version(String version);
    B group(String group);
    B deprecated(Boolean deprecated);
    B delay(Integer delay);
    B export(Boolean export);
    B weight(Integer weight);
    B document(String document);
    B dynamic(Boolean dynamic);
    B token(String token);
    B token(Boolean token);
    B accesslog(String accesslog);
    B accesslog(Boolean accesslog);
    B addProtocols(List protocols);
    B addProtocol(ProtocolConfigInterface protocol);
    B protocolIds(String protocolIds);
    B executes(Integer executes);
    B register(Boolean register);
    B warmup(Integer warmup);
    B serialization(String serialization);
    void build(T instance);
}