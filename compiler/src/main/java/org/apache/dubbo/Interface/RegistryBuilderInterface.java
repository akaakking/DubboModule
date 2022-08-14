package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface RegistryBuilderInterface{
    RegistryBuilderInterface newBuilder();
    RegistryBuilderInterface id(String id);
    RegistryBuilderInterface address(String address);
    RegistryBuilderInterface username(String username);
    RegistryBuilderInterface password(String password);
    RegistryBuilderInterface port(Integer port);
    RegistryBuilderInterface protocol(String protocol);
    RegistryBuilderInterface transporter(String transporter);
    RegistryBuilderInterface transport(String transport);
    RegistryBuilderInterface server(String server);
    RegistryBuilderInterface client(String client);
    RegistryBuilderInterface cluster(String cluster);
    RegistryBuilderInterface group(String group);
    RegistryBuilderInterface version(String version);
    RegistryBuilderInterface timeout(Integer timeout);
    RegistryBuilderInterface session(Integer session);
    RegistryBuilderInterface file(String file);
    RegistryBuilderInterface wait(Integer wait);
    RegistryBuilderInterface isCheck(Boolean check);
    RegistryBuilderInterface isDynamic(Boolean dynamic);
    RegistryBuilderInterface register(Boolean register);
    RegistryBuilderInterface subscribe(Boolean subscribe);
    RegistryBuilderInterface appendParameter(String key, String value);
    RegistryBuilderInterface parameter(String name, String value);
    RegistryBuilderInterface appendParameters(Map appendParameters);
    RegistryBuilderInterface isDefault(Boolean isDefault);
    RegistryBuilderInterface simplified(Boolean simplified);
    RegistryBuilderInterface extraKeys(String extraKeys);
    RegistryBuilderInterface useAsConfigCenter(Boolean useAsConfigCenter);
    RegistryBuilderInterface useAsMetadataCenter(Boolean useAsMetadataCenter);
    RegistryBuilderInterface preferred(Boolean preferred);
    RegistryBuilderInterface accepts(String accepts);
    RegistryBuilderInterface weight(Integer weight);
    RegistryConfigInterface build();

}