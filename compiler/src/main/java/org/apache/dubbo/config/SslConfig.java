package org.apache.dubbo.config;

import java.io.InputStream;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class SslConfig extends AbstractConfig implements SslConfigInterface {

    public StringInterface getServerKeyCertChainPath() {
        return instance.getServerKeyCertChainPath();
    }

    public void setServerKeyCertChainPath(StringInterface serverKeyCertChainPath) {
        instance.setServerKeyCertChainPath(serverKeyCertChainPath);
    }

    public StringInterface getServerPrivateKeyPath() {
        return instance.getServerPrivateKeyPath();
    }

    public void setServerPrivateKeyPath(StringInterface serverPrivateKeyPath) {
        instance.setServerPrivateKeyPath(serverPrivateKeyPath);
    }

    public StringInterface getServerKeyPassword() {
        return instance.getServerKeyPassword();
    }

    public void setServerKeyPassword(StringInterface serverKeyPassword) {
        instance.setServerKeyPassword(serverKeyPassword);
    }

    public StringInterface getServerTrustCertCollectionPath() {
        return instance.getServerTrustCertCollectionPath();
    }

    public void setServerTrustCertCollectionPath(StringInterface serverTrustCertCollectionPath) {
        instance.setServerTrustCertCollectionPath(serverTrustCertCollectionPath);
    }

    public StringInterface getClientKeyCertChainPath() {
        return instance.getClientKeyCertChainPath();
    }

    public void setClientKeyCertChainPath(StringInterface clientKeyCertChainPath) {
        instance.setClientKeyCertChainPath(clientKeyCertChainPath);
    }

    public StringInterface getClientPrivateKeyPath() {
        return instance.getClientPrivateKeyPath();
    }

    public void setClientPrivateKeyPath(StringInterface clientPrivateKeyPath) {
        instance.setClientPrivateKeyPath(clientPrivateKeyPath);
    }

    public StringInterface getClientKeyPassword() {
        return instance.getClientKeyPassword();
    }

    public void setClientKeyPassword(StringInterface clientKeyPassword) {
        instance.setClientKeyPassword(clientKeyPassword);
    }

    public StringInterface getClientTrustCertCollectionPath() {
        return instance.getClientTrustCertCollectionPath();
    }

    public void setClientTrustCertCollectionPath(StringInterface clientTrustCertCollectionPath) {
        instance.setClientTrustCertCollectionPath(clientTrustCertCollectionPath);
    }

    public InputStreamInterface getServerKeyCertChainPathStream() {
        return instance.getServerKeyCertChainPathStream();
    }

    public void setServerKeyCertChainPathStream(InputStreamInterface serverKeyCertChainPathStream) {
        instance.setServerKeyCertChainPathStream(serverKeyCertChainPathStream);
    }

    public InputStreamInterface getServerPrivateKeyPathStream() {
        return instance.getServerPrivateKeyPathStream();
    }

    public void setServerPrivateKeyPathStream(InputStreamInterface serverPrivateKeyPathStream) {
        instance.setServerPrivateKeyPathStream(serverPrivateKeyPathStream);
    }

    public InputStreamInterface getServerTrustCertCollectionPathStream() {
        return instance.getServerTrustCertCollectionPathStream();
    }

    public void setServerTrustCertCollectionPathStream(InputStreamInterface serverTrustCertCollectionPathStream) {
        instance.setServerTrustCertCollectionPathStream(serverTrustCertCollectionPathStream);
    }

    public InputStreamInterface getClientKeyCertChainPathStream() {
        return instance.getClientKeyCertChainPathStream();
    }

    public void setClientKeyCertChainPathStream(InputStreamInterface clientKeyCertChainPathStream) {
        instance.setClientKeyCertChainPathStream(clientKeyCertChainPathStream);
    }

    public InputStreamInterface getClientPrivateKeyPathStream() {
        return instance.getClientPrivateKeyPathStream();
    }

    public void setClientPrivateKeyPathStream(InputStreamInterface clientPrivateKeyPathStream) {
        instance.setClientPrivateKeyPathStream(clientPrivateKeyPathStream);
    }

    public InputStreamInterface getClientTrustCertCollectionPathStream() {
        return instance.getClientTrustCertCollectionPathStream();
    }

    public void setClientTrustCertCollectionPathStream(InputStreamInterface clientTrustCertCollectionPathStream) {
        instance.setClientTrustCertCollectionPathStream(clientTrustCertCollectionPathStream);
    }

    public SslConfig() {
        instance = (SslConfigInterface) DubboClassLoader.getInstance(SslConfig.class.getName());
    }

    public SslConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (SslConfigInterface) DubboClassLoader.getInstance(SslConfig.class.getName(), params, args);
    }
}
