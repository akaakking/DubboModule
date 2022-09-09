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

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Map;
import static org.apache.dubbo.common.constants.CommonConstants.EXTRA_KEYS_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SHUTDOWN_WAIT_KEY;
import static org.apache.dubbo.common.constants.RegistryConstants.ENABLE_EMPTY_PROTECTION_KEY;
import static org.apache.dubbo.common.constants.RegistryConstants.REGISTER_MODE_KEY;
import static org.apache.dubbo.common.constants.RegistryConstants.REGISTRY_CLUSTER_KEY;
import static org.apache.dubbo.common.constants.RemotingConstants.BACKUP_KEY;
import static org.apache.dubbo.common.utils.PojoUtils.updatePropertyIfAbsent;

/**
 * RegistryConfig
 *
 * @export
 */
public class RegistryConfig extends AbstractConfig {

    @Override
    @Parameter(key = REGISTRY_CLUSTER_KEY)
    public String getId();

    public String getProtocol();

    public void setProtocol(String protocol);

    @Parameter(excluded = true)
    public String getAddress();

    public void setAddress(String address);

    public Integer getPort();

    public void setPort(Integer port);

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    /**
     * @return wait
     * @see org.apache.dubbo.config.ProviderConfig#getWait()
     * @deprecated
     */
    @Deprecated
    public Integer getWait();

    /**
     * @param wait
     * @see org.apache.dubbo.config.ProviderConfig#setWait(Integer)
     * @deprecated
     */
    @Deprecated
    public void setWait(Integer wait);

    public Boolean isCheck();

    public void setCheck(Boolean check);

    public String getFile();

    public void setFile(String file);

    /**
     * @return transport
     * @see #getTransporter()
     * @deprecated
     */
    @Deprecated
    @Parameter(excluded = true, attribute = false)
    public String getTransport();

    /**
     * @param transport
     * @see #setTransporter(String)
     * @deprecated
     */
    @Deprecated
    public void setTransport(String transport);

    public String getTransporter();

    public void setTransporter(String transporter);

    public String getServer();

    public void setServer(String server);

    public String getClient();

    public void setClient(String client);

    public Integer getTimeout();

    public void setTimeout(Integer timeout);

    public Integer getSession();

    public void setSession(Integer session);

    public Boolean isDynamic();

    public void setDynamic(Boolean dynamic);

    public Boolean isRegister();

    public void setRegister(Boolean register);

    public Boolean isSubscribe();

    public void setSubscribe(Boolean subscribe);

    public String getCluster();

    public void setCluster(String cluster);

    public String getZone();

    public void setZone(String zone);

    public String getGroup();

    public void setGroup(String group);

    public String getVersion();

    public void setVersion(String version);

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);

    public void updateParameters(Map<String, String> parameters);

    public Boolean getSimplified();

    public void setSimplified(Boolean simplified);

    @Parameter(key = EXTRA_KEYS_KEY)
    public String getExtraKeys();

    public void setExtraKeys(String extraKeys);

    @Parameter(excluded = true)
    public Boolean getUseAsConfigCenter();

    public void setUseAsConfigCenter(Boolean useAsConfigCenter);

    @Parameter(excluded = true)
    public Boolean getUseAsMetadataCenter();

    public void setUseAsMetadataCenter(Boolean useAsMetadataCenter);

    public String getAccepts();

    public void setAccepts(String accepts);

    public Boolean getPreferred();

    public void setPreferred(Boolean preferred);

    public Integer getWeight();

    public void setWeight(Integer weight);

    @Parameter(key = REGISTER_MODE_KEY)
    public String getRegisterMode();

    public void setRegisterMode(String registerMode);

    @Parameter(key = ENABLE_EMPTY_PROTECTION_KEY)
    public Boolean getEnableEmptyProtection();

    public void setEnableEmptyProtection(Boolean enableEmptyProtection);

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();
}
