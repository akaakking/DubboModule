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
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The module info
 *
 * @export
 */
public class ModuleConfig extends AbstractConfig {

    @Override
    protected void checkDefault();

    @Override
    protected void checkScopeModel(ScopeModel scopeModel);

    @Parameter(key = "module")
    public String getName();

    public void setName(String name);

    @Parameter(key = "module.version")
    public String getVersion();

    public void setVersion(String version);

    @Parameter(key = "module.owner")
    public String getOwner();

    public void setOwner(String owner);

    @Parameter(key = "module.organization")
    public String getOrganization();

    public void setOrganization(String organization);

    public RegistryConfig getRegistry();

    public void setRegistry(RegistryConfig registry);

    public List<RegistryConfig> getRegistries();

    @SuppressWarnings({ "unchecked" })
    public void setRegistries(List<? extends RegistryConfig> registries);

    public MonitorConfig getMonitor();

    public void setMonitor(MonitorConfig monitor);

    public void setMonitor(String monitor);

    public Boolean getBackground();

    /**
     * Whether start module in background.
     * If start in backgound, do not await finish on Spring ContextRefreshedEvent.
     *
     * @see org.apache.dubbo.config.spring.context.DubboDeployApplicationListener
     */
    public void setBackground(Boolean background);

    public Integer getReferThreadNum();

    public void setReferThreadNum(Integer referThreadNum);

    public Integer getExportThreadNum();

    public void setExportThreadNum(Integer exportThreadNum);

    public Boolean getReferAsync();

    public void setReferAsync(Boolean referAsync);

    public Boolean getExportAsync();

    public void setExportAsync(Boolean exportAsync);
}
