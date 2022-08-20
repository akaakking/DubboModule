package org.apache.dubbo.common.url.component;

import java.io.Serializable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class URLAddress implements URLAddressInterface {

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public URLAddressInterface setProtocol(StringInterface protocol) {
        return instance.setProtocol(protocol);
    }

    public StringInterface getUsername() {
        return instance.getUsername();
    }

    public URLAddressInterface setUsername(StringInterface username) {
        return instance.setUsername(username);
    }

    public StringInterface getPassword() {
        return instance.getPassword();
    }

    public URLAddressInterface setPassword(StringInterface password) {
        return instance.setPassword(password);
    }

    public StringInterface getPath() {
        return instance.getPath();
    }

    public URLAddressInterface setPath(StringInterface path) {
        return instance.setPath(path);
    }

    public StringInterface getHost() {
        return instance.getHost();
    }

    public URLAddressInterface setHost(StringInterface host) {
        return instance.setHost(host);
    }

    public int getPort() {
        return instance.getPort();
    }

    public URLAddressInterface setPort(int port) {
        return instance.setPort(port);
    }

    public StringInterface getAddress() {
        return instance.getAddress();
    }

    public URLAddressInterface setAddress(StringInterface host, int port) {
        return instance.setAddress(host, port);
    }

    public StringInterface getIp() {
        return instance.getIp();
    }

    public StringInterface getRawAddress() {
        return instance.getRawAddress();
    }

    public long getTimestamp() {
        return instance.getTimestamp();
    }

    public void setTimestamp(long timestamp) {
        instance.setTimestamp(timestamp);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public boolean equals(ObjectInterface obj) {
        return instance.equals(obj);
    }

    public StringInterface toString() {
        return instance.toString();
    }

    protected URLAddressInterface instance;

    public static URLAddressInterface parse(StringInterface rawAddress, StringInterface defaultProtocol, boolean encoded) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(parse, String.class, String.class, boolean.class);
        return method.invoke(rawAddress, defaultProtocol, encoded);
    }

    public URLAddress(String host, int port) {
        Class[] params = new Class[]{String.class, int.class};
        Object[] args = new Object[]{host, port};
        instance = (URLAddressInterface) DubboClassLoader.getInstance(URLAddress.class.getName(), params, args);
    }

    public URLAddress(String host, int port, String rawAddress) {
        Class[] params = new Class[]{String.class, int.class, String.class};
        Object[] args = new Object[]{host, port, rawAddress};
        instance = (URLAddressInterface) DubboClassLoader.getInstance(URLAddress.class.getName(), params, args);
    }
}
