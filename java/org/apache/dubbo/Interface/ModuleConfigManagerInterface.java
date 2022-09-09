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

import org.apache.dubbo.common.context.ModuleExt;
import org.apache.dubbo.common.extension.DisableInject;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.AbstractInterfaceConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfigBase;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import static java.util.Optional.ofNullable;
import static org.apache.dubbo.config.AbstractConfig.getTagName;

/**
 * Manage configs of module
 */
public class ModuleConfigManagerInterface extends AbstractConfigManager implements ModuleExt {

    // ModuleConfig correlative methods
    @DisableInject
    public void setModule(ModuleConfig module);

    public Optional<ModuleConfigInterface> getModule();

    // ServiceConfig correlative methods
    public void addService(ServiceConfigBase<?> serviceConfig);

    public void addServices(Iterable<ServiceConfigBase<?>> serviceConfigs);

    public Collection<ServiceConfigBaseInterface> getServices();

    public <T> ServiceConfigBaseInterface<T> getService(String id);

    // ReferenceConfig correlative methods
    public void addReference(ReferenceConfigBase<?> referenceConfig);

    public void addReferences(Iterable<ReferenceConfigBase<?>> referenceConfigs);

    public Collection<ReferenceConfigBaseInterface<?>> getReferences();

    public <T> ReferenceConfigBaseInterface<T> getReference(String id);

    public void addProvider(ProviderConfig providerConfig);

    public void addProviders(Iterable<ProviderConfig> providerConfigs);

    public Optional<ProviderConfigInterface> getProvider(String id);

    /**
     * Only allows one default ProviderConfig
     */
    public Optional<ProviderConfigInterface> getDefaultProvider();

    public Collection<ProviderConfigInterface> getProviders();

    // ConsumerConfig correlative methods
    public void addConsumer(ConsumerConfig consumerConfig);

    public void addConsumers(Iterable<ConsumerConfig> consumerConfigs);

    public Optional<ConsumerConfigInterface> getConsumer(String id);

    /**
     * Only allows one default ConsumerConfig
     */
    public Optional<ConsumerConfigInterface> getDefaultConsumer();

    public Collection<ConsumerConfigInterface> getConsumers();

    @Override
    public void refreshAll();

    @Override
    public void clear();

    @Override
    public void loadConfigs();

    // 
    // Delegate read application configs
    // 
    @Override
    public <C extends AbstractConfig> Map<String,C> getConfigsMap(Class<C> cls);

    @Override
    public <C extends AbstractConfig> Collection<C> getConfigs(Class<C> configType);

    @Override
    public <T extends AbstractConfig> Optional<T> getConfig(Class<T> cls, String idOrName);

    @Override
    public <C extends AbstractConfig> List<C> getDefaultConfigs(Class<C> cls);

    public Optional<ApplicationConfigInterface> getApplication();

    public Optional<MonitorConfigInterface> getMonitor();

    public Optional<MetricsConfigInterface> getMetrics();

    public Optional<SslConfigInterface> getSsl();

    public Optional<Collection<ConfigCenterConfigInterface>> getDefaultConfigCenter();

    public Optional<ConfigCenterConfigInterface> getConfigCenter(String id);

    public Collection<ConfigCenterConfigInterface> getConfigCenters();

    public Collection<MetadataReportConfigInterface> getMetadataConfigs();

    public Collection<MetadataReportConfigInterface> getDefaultMetadataConfigs();

    public Optional<ProtocolConfigInterface> getProtocol(String idOrName);

    public List<ProtocolConfigInterface> getDefaultProtocols();

    public Collection<ProtocolConfigInterface> getProtocols();

    public Optional<RegistryConfigInterface> getRegistry(String id);

    public List<RegistryConfigInterface> getDefaultRegistries();

    public Collection<RegistryConfigInterface> getRegistries();
}
