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

import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.apache.dubbo.common.constants.CommonConstants.EXPORTER_LISTENER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.EXPORT_ASYNC_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SERVICE_FILTER_KEY;

/**
 * AbstractServiceConfig
 *
 * @export
 */
public abstract class AbstractServiceConfig extends AbstractInterfaceConfig {

    /**
     * whether the service is deprecated
     */
    /**
     * Whether to register as a dynamic service or not on register center, the value is true, the status will be enabled
     * after the service registered,and it needs to be disabled manually; if you want to disable the service, you also need
     * manual processing
     */
    @Override
    protected void checkDefault();

    @Override
    public String getVersion();

    @Override
    public void setVersion(String version);

    @Override
    public String getGroup();

    @Override
    public void setGroup(String group);

    public Integer getDelay();

    public void setDelay(Integer delay);

    public Boolean getExport();

    public void setExport(Boolean export);

    public Integer getWeight();

    public void setWeight(Integer weight);

    @Parameter(escaped = true)
    public String getDocument();

    public void setDocument(String document);

    public String getToken();

    public void setToken(Boolean token);

    public void setToken(String token);

    public Boolean isDeprecated();

    public void setDeprecated(Boolean deprecated);

    public Boolean isDynamic();

    public void setDynamic(Boolean dynamic);

    public List<ProtocolConfig> getProtocols();

    @SuppressWarnings({ "unchecked" })
    public void setProtocols(List<? extends ProtocolConfig> protocols);

    public ProtocolConfig getProtocol();

    public void setProtocol(ProtocolConfig protocol);

    @Parameter(excluded = true)
    public String getProtocolIds();

    public void setProtocolIds(String protocolIds);

    public String getAccesslog();

    public void setAccesslog(Boolean accesslog);

    public void setAccesslog(String accesslog);

    public Integer getExecutes();

    public void setExecutes(Integer executes);

    @Override
    @Parameter(key = SERVICE_FILTER_KEY, append = true)
    public String getFilter();

    @Override
    @Parameter(key = EXPORTER_LISTENER_KEY, append = true)
    public String getListener();

    @Override
    public void setListener(String listener);

    public Boolean isRegister();

    public void setRegister(Boolean register);

    public Integer getWarmup();

    public void setWarmup(Integer warmup);

    public String getSerialization();

    public void setSerialization(String serialization);

    @Deprecated
    @Parameter(key = EXPORT_ASYNC_KEY)
    public Boolean getExportAsync();

    @Deprecated
    public void setExportAsync(Boolean exportAsync);
}
