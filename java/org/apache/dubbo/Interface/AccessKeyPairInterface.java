package org.apache.dubbo.Interface;

import java.lang.String;

public interface AccessKeyPairInterface {

    String getAccessKey();

    void setAccessKey(String accessKey);

    String getSecretKey();

    void setSecretKey(String secretKey);

    String getConsumerSide();

    void setConsumerSide(String consumerSide);

    String getProviderSide();

    void setProviderSide(String providerSide);

    String getCreator();

    void setCreator(String creator);

    String getOptions();

    void setOptions(String options);

    String toString();
}
