/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.Interface;

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.IOUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.io.IOException;
import java.io.InputStream;

public class SslConfigInterface extends AbstractConfig {

    @Parameter(key = SERVER_KEY_CERT_CHAIN_PATH)
    public String getServerKeyCertChainPath();

    public void setServerKeyCertChainPath(String serverKeyCertChainPath);

    @Parameter(key = SERVER_PRIVATE_KEY_PATH)
    public String getServerPrivateKeyPath();

    public void setServerPrivateKeyPath(String serverPrivateKeyPath);

    @Parameter(key = SERVER_KEY_PASSWORD)
    public String getServerKeyPassword();

    public void setServerKeyPassword(String serverKeyPassword);

    @Parameter(key = SERVER_TRUST_CERT_COLLECTION_PATH)
    public String getServerTrustCertCollectionPath();

    public void setServerTrustCertCollectionPath(String serverTrustCertCollectionPath);

    @Parameter(key = CLIENT_KEY_CERT_CHAIN_PATH)
    public String getClientKeyCertChainPath();

    public void setClientKeyCertChainPath(String clientKeyCertChainPath);

    @Parameter(key = CLIENT_PRIVATE_KEY_PATH)
    public String getClientPrivateKeyPath();

    public void setClientPrivateKeyPath(String clientPrivateKeyPath);

    @Parameter(key = CLIENT_KEY_PASSWORD)
    public String getClientKeyPassword();

    public void setClientKeyPassword(String clientKeyPassword);

    @Parameter(key = CLIENT_TRUST_CERT_COLLECTION_PATH)
    public String getClientTrustCertCollectionPath();

    public void setClientTrustCertCollectionPath(String clientTrustCertCollectionPath);

    public InputStream getServerKeyCertChainPathStream() throws IOException;

    public void setServerKeyCertChainPathStream(InputStream serverKeyCertChainPathStream);

    public InputStream getServerPrivateKeyPathStream() throws IOException;

    public void setServerPrivateKeyPathStream(InputStream serverPrivateKeyPathStream);

    public InputStream getServerTrustCertCollectionPathStream() throws IOException;

    public void setServerTrustCertCollectionPathStream(InputStream serverTrustCertCollectionPathStream);

    public InputStream getClientKeyCertChainPathStream() throws IOException;

    public void setClientKeyCertChainPathStream(InputStream clientKeyCertChainPathStream);

    public InputStream getClientPrivateKeyPathStream() throws IOException;

    public void setClientPrivateKeyPathStream(InputStream clientPrivateKeyPathStream);

    public InputStream getClientTrustCertCollectionPathStream() throws IOException;

    public void setClientTrustCertCollectionPathStream(InputStream clientTrustCertCollectionPathStream);
}
