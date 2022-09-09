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

import org.apache.dubbo.common.context.ApplicationExt;
import org.apache.dubbo.common.extension.DisableInject;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.ConfigKeys;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import static org.apache.dubbo.config.AbstractConfig.getTagName;

/**
 * A lock-free config manager (through ConcurrentHashMap), for fast read operation.
 * The Write operation lock with sub configs map of config type, for safely check and add new config.
 */
public class ConfigManager extends AbstractConfigManager implements ApplicationExt {

    // ApplicationConfig correlative methods
    /**
     * Set application config
     *
     * @param application
     * @return current application config instance
     */
    @DisableInject
    public void setApplication(ApplicationConfig application);

    public Optional<ApplicationConfig> getApplication();

    public ApplicationConfig getApplicationOrElseThrow();

    // MonitorConfig correlative methods
    @DisableInject
    public void setMonitor(MonitorConfig monitor);

    public Optional<MonitorConfig> getMonitor();

    @DisableInject
    public void setMetrics(MetricsConfig metrics);

    public Optional<MetricsConfig> getMetrics();

    @DisableInject
    public void setSsl(SslConfig sslConfig);

    public Optional<SslConfig> getSsl();

    // ConfigCenterConfig correlative methods
    public void addConfigCenter(ConfigCenterConfig configCenter);

    public void addConfigCenters(Iterable<ConfigCenterConfig> configCenters);

    public Optional<Collection<ConfigCenterConfig>> getDefaultConfigCenter();

    public Optional<ConfigCenterConfig> getConfigCenter(String id);

    public Collection<ConfigCenterConfig> getConfigCenters();

    // MetadataReportConfig correlative methods
    public void addMetadataReport(MetadataReportConfig metadataReportConfig);

    public void addMetadataReports(Iterable<MetadataReportConfig> metadataReportConfigs);

    public Collection<MetadataReportConfig> getMetadataConfigs();

    public Collection<MetadataReportConfig> getDefaultMetadataConfigs();

    // ProtocolConfig correlative methods
    public void addProtocol(ProtocolConfig protocolConfig);

    public void addProtocols(Iterable<ProtocolConfig> protocolConfigs);

    public Optional<ProtocolConfig> getProtocol(String idOrName);

    public List<ProtocolConfig> getDefaultProtocols();

    @Override
    public <C extends AbstractConfig> List<C> getDefaultConfigs(Class<C> cls);

    public Collection<ProtocolConfig> getProtocols();

    // RegistryConfig correlative methods
    public void addRegistry(RegistryConfig registryConfig);

    public void addRegistries(Iterable<RegistryConfig> registryConfigs);

    public Optional<RegistryConfig> getRegistry(String id);

    public List<RegistryConfig> getDefaultRegistries();

    public Collection<RegistryConfig> getRegistries();

    @Override
    public void refreshAll();

    @Override
    public void loadConfigs();

    private void checkConfigs();

    public ConfigMode getConfigMode();
}
