package org.apache.dubbo.common.url.component;

import java.io.Serializable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class URLAddress implements URLAddressInterface {

    public String getProtocol() {
        return instance.getProtocol();
    }

    public URLAddressInterface setProtocol(String protocol) {
        return instance.setProtocol(protocol);
    }

    public String getUsername() {
        return instance.getUsername();
    }

    public URLAddressInterface setUsername(String username) {
        return instance.setUsername(username);
    }

    public String getPassword() {
        return instance.getPassword();
    }

    public URLAddressInterface setPassword(String password) {
        return instance.setPassword(password);
    }

    public String getPath() {
        return instance.getPath();
    }

    public URLAddressInterface setPath(String path) {
        return instance.setPath(path);
    }

    public String getHost() {
        return instance.getHost();
    }

    public URLAddressInterface setHost(String host) {
        return instance.setHost(host);
    }

    public int getPort() {
        return instance.getPort();
    }

    public URLAddressInterface setPort(int port) {
        return instance.setPort(port);
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public URLAddressInterface setAddress(String host, int port) {
        return instance.setAddress(host, port);
    }

    public String getIp() {
        return instance.getIp();
    }

    public String getRawAddress() {
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

    public boolean equals(Object obj) {
        return instance.equals(obj);
    }

    public String toString() {
        return instance.toString();
    }

    protected URLAddressInterface instance;

    public static URLAddressInterface parse(String rawAddress, String defaultProtocol, boolean encoded) {
        Class klass = DubboClassLoader.getKlass(URLAddress.class.getName());
        Method method = klass.getMethod("parse", String.class, String.class, boolean.class);
        return method.invoke(rawAddress, defaultProtocol, encoded);
    }

    public URLAddressInterface getInternalInstance() {
        return instance;
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

    protected URLAddress() {
        instance = (URLAddressInterface) DubboClassLoader.getInstance(URLAddress.class.getName());
    }
}
