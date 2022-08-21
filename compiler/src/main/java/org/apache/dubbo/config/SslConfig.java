package org.apache.dubbo.config;

import java.io.InputStream;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class SslConfig extends AbstractConfig implements SslConfigInterface {

    public String getServerKeyCertChainPath() {
        return instance.getServerKeyCertChainPath();
    }

    public void setServerKeyCertChainPath(String serverKeyCertChainPath) {
        instance.setServerKeyCertChainPath(serverKeyCertChainPath);
    }

    public String getServerPrivateKeyPath() {
        return instance.getServerPrivateKeyPath();
    }

    public void setServerPrivateKeyPath(String serverPrivateKeyPath) {
        instance.setServerPrivateKeyPath(serverPrivateKeyPath);
    }

    public String getServerKeyPassword() {
        return instance.getServerKeyPassword();
    }

    public void setServerKeyPassword(String serverKeyPassword) {
        instance.setServerKeyPassword(serverKeyPassword);
    }

    public String getServerTrustCertCollectionPath() {
        return instance.getServerTrustCertCollectionPath();
    }

    public void setServerTrustCertCollectionPath(String serverTrustCertCollectionPath) {
        instance.setServerTrustCertCollectionPath(serverTrustCertCollectionPath);
    }

    public String getClientKeyCertChainPath() {
        return instance.getClientKeyCertChainPath();
    }

    public void setClientKeyCertChainPath(String clientKeyCertChainPath) {
        instance.setClientKeyCertChainPath(clientKeyCertChainPath);
    }

    public String getClientPrivateKeyPath() {
        return instance.getClientPrivateKeyPath();
    }

    public void setClientPrivateKeyPath(String clientPrivateKeyPath) {
        instance.setClientPrivateKeyPath(clientPrivateKeyPath);
    }

    public String getClientKeyPassword() {
        return instance.getClientKeyPassword();
    }

    public void setClientKeyPassword(String clientKeyPassword) {
        instance.setClientKeyPassword(clientKeyPassword);
    }

    public String getClientTrustCertCollectionPath() {
        return instance.getClientTrustCertCollectionPath();
    }

    public void setClientTrustCertCollectionPath(String clientTrustCertCollectionPath) {
        instance.setClientTrustCertCollectionPath(clientTrustCertCollectionPath);
    }

    public InputStream getServerKeyCertChainPathStream() {
        return instance.getServerKeyCertChainPathStream();
    }

    public void setServerKeyCertChainPathStream(InputStream serverKeyCertChainPathStream) {
        instance.setServerKeyCertChainPathStream(serverKeyCertChainPathStream);
    }

    public InputStream getServerPrivateKeyPathStream() {
        return instance.getServerPrivateKeyPathStream();
    }

    public void setServerPrivateKeyPathStream(InputStream serverPrivateKeyPathStream) {
        instance.setServerPrivateKeyPathStream(serverPrivateKeyPathStream);
    }

    public InputStream getServerTrustCertCollectionPathStream() {
        return instance.getServerTrustCertCollectionPathStream();
    }

    public void setServerTrustCertCollectionPathStream(InputStream serverTrustCertCollectionPathStream) {
        instance.setServerTrustCertCollectionPathStream(serverTrustCertCollectionPathStream);
    }

    public InputStream getClientKeyCertChainPathStream() {
        return instance.getClientKeyCertChainPathStream();
    }

    public void setClientKeyCertChainPathStream(InputStream clientKeyCertChainPathStream) {
        instance.setClientKeyCertChainPathStream(clientKeyCertChainPathStream);
    }

    public InputStream getClientPrivateKeyPathStream() {
        return instance.getClientPrivateKeyPathStream();
    }

    public void setClientPrivateKeyPathStream(InputStream clientPrivateKeyPathStream) {
        instance.setClientPrivateKeyPathStream(clientPrivateKeyPathStream);
    }

    public InputStream getClientTrustCertCollectionPathStream() {
        return instance.getClientTrustCertCollectionPathStream();
    }

    public void setClientTrustCertCollectionPathStream(InputStream clientTrustCertCollectionPathStream) {
        instance.setClientTrustCertCollectionPathStream(clientTrustCertCollectionPathStream);
    }

    public SslConfigInterface getInternalInstance() {
        return instance;
    }

    public protected SslConfig() {
        instance = (SslConfigInterface) DubboClassLoader.getInstance(SslConfig.class.getName());
        super.instance = instance;
    }

    public SslConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (SslConfigInterface) DubboClassLoader.getInstance(SslConfig.class.getName(), params, args);
        super.instance = instance;
    }
}
