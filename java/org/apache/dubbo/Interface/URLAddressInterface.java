package org.apache.dubbo.Interface;

import java.io.Serializable;
import org.apache.dubbo.Interface.URLAddressInterface;
import java.lang.String;
import java.lang.Object;

public interface URLAddressInterface extends Serializable {

    String getProtocol();

    URLAddressInterface setProtocol(String protocol);

    String getUsername();

    URLAddressInterface setUsername(String username);

    String getPassword();

    URLAddressInterface setPassword(String password);

    String getPath();

    URLAddressInterface setPath(String path);

    String getHost();

    URLAddressInterface setHost(String host);

    int getPort();

    URLAddressInterface setPort(int port);

    String getAddress();

    URLAddressInterface setAddress(String host, int port);

    String getIp();

    String getRawAddress();

    long getTimestamp();

    void setTimestamp(long timestamp);

    int hashCode();

    boolean equals(Object obj);

    String toString();
}
