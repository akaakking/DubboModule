package org.apache.dubbo.Interface;

import java.io.InputStream;

public interface SslConfigInterface extends AbstractConfig{
    String getServerKeyCertChainPath();
    void setServerKeyCertChainPath(String serverKeyCertChainPath);
    String getServerPrivateKeyPath();
    void setServerPrivateKeyPath(String serverPrivateKeyPath);
    String getServerKeyPassword();
    void setServerKeyPassword(String serverKeyPassword);
    String getServerTrustCertCollectionPath();
    void setServerTrustCertCollectionPath(String serverTrustCertCollectionPath);
    String getClientKeyCertChainPath();
    void setClientKeyCertChainPath(String clientKeyCertChainPath);
    String getClientPrivateKeyPath();
    void setClientPrivateKeyPath(String clientPrivateKeyPath);
    String getClientKeyPassword();
    void setClientKeyPassword(String clientKeyPassword);
    String getClientTrustCertCollectionPath();
    void setClientTrustCertCollectionPath(String clientTrustCertCollectionPath);
    InputStream getServerKeyCertChainPathStream();
    void setServerKeyCertChainPathStream(InputStream serverKeyCertChainPathStream);
    InputStream getServerPrivateKeyPathStream();
    void setServerPrivateKeyPathStream(InputStream serverPrivateKeyPathStream);
    InputStream getServerTrustCertCollectionPathStream();
    void setServerTrustCertCollectionPathStream(InputStream serverTrustCertCollectionPathStream);
    InputStream getClientKeyCertChainPathStream();
    void setClientKeyCertChainPathStream(InputStream clientKeyCertChainPathStream);
    InputStream getClientPrivateKeyPathStream();
    void setClientPrivateKeyPathStream(InputStream clientPrivateKeyPathStream);
    InputStream getClientTrustCertCollectionPathStream();
    void setClientTrustCertCollectionPathStream(InputStream clientTrustCertCollectionPathStream);
}