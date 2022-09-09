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
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.common.utils.UrlUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.apache.dubbo.common.constants.CommonConstants.ANYHOST_VALUE;
import static org.apache.dubbo.common.constants.CommonConstants.CONFIG_CONFIGFILE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.CONFIG_ENABLE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.PATH_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.PROTOCOL_KEY;
import static org.apache.dubbo.common.constants.RemotingConstants.BACKUP_KEY;
import static org.apache.dubbo.common.utils.PojoUtils.updatePropertyIfAbsent;
import static org.apache.dubbo.config.Constants.CONFIG_APP_CONFIGFILE_KEY;
import static org.apache.dubbo.config.Constants.ZOOKEEPER_PROTOCOL;

/**
 * ConfigCenterConfig
 */
public class ConfigCenterConfig extends AbstractConfig {

    @Override
    protected void checkDefault();

    public URL toUrl();

    public boolean checkOrUpdateInitialized(boolean update);

    public void setInitialized(boolean val);

    public Map<String, String> getExternalConfiguration();

    public Map<String, String> getAppExternalConfiguration();

    public void setExternalConfig(Map<String, String> externalConfiguration);

    public void setAppExternalConfig(Map<String, String> appExternalConfiguration);

    public String getProtocol();

    public void setProtocol(String protocol);

    @Parameter(excluded = true)
    public String getAddress();

    public void setAddress(String address);

    public Integer getPort();

    public void setPort(Integer port);

    public String getCluster();

    public void setCluster(String cluster);

    public String getNamespace();

    public void setNamespace(String namespace);

    public String getGroup();

    public void setGroup(String group);

    public Boolean isCheck();

    public void setCheck(Boolean check);

    @Deprecated
    @Parameter(key = CONFIG_ENABLE_KEY)
    public Boolean isHighestPriority();

    @Deprecated
    public void setHighestPriority(Boolean highestPriority);

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    public Long getTimeout();

    public void setTimeout(Long timeout);

    @Parameter(key = CONFIG_CONFIGFILE_KEY)
    public String getConfigFile();

    public void setConfigFile(String configFile);

    @Parameter(excluded = true, key = CONFIG_APP_CONFIGFILE_KEY)
    public String getAppConfigFile();

    public void setAppConfigFile(String appConfigFile);

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();

    public void updateParameters(Map<String, String> parameters);
}
