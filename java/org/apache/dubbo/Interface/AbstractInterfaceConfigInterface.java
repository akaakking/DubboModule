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
import org.apache.dubbo.common.Version;
import org.apache.dubbo.common.config.ConfigurationUtils;
import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.common.config.InmemoryConfiguration;
import org.apache.dubbo.common.utils.Assert;
import org.apache.dubbo.common.utils.ClassUtils;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.ConfigUtils;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
import org.apache.dubbo.rpc.model.ServiceMetadata;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.apache.dubbo.common.constants.CommonConstants.COMMA_SPLIT_PATTERN;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO_VERSION_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.INVOKER_LISTENER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.NATIVE;
import static org.apache.dubbo.common.constants.CommonConstants.PID_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REFERENCE_FILTER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.RELEASE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.TAG_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.TIMESTAMP_KEY;
import static org.apache.dubbo.common.constants.MetricsConstants.PROTOCOL_PROMETHEUS;

/**
 * AbstractDefaultConfig
 *
 * @export
 */
public abstract class AbstractInterfaceConfig extends AbstractMethodConfig {

    public List<URL> getExportedUrls();

    public URL toUrl();

    public List<URL> toUrls();

    @Override
    protected void postProcessAfterScopeModelChanged(ScopeModel oldScopeModel, ScopeModel newScopeModel);

    /**
     * Check whether the registry config is exists, and then conversion it to {@link RegistryConfig}
     */
    protected void checkRegistry();

    public static void appendRuntimeParameters(Map<String, String> map);

    /**
     * @deprecated After metrics config is refactored.
     * This method should no longer use and will be deleted in the future.
     */
    @Deprecated
    protected void appendMetricsCompatible(Map<String, String> map);

    /**
     * To obtain the method list in the port, use reflection when in native mode and javassist otherwise.
     * @param interfaceClass
     * @return
     */
    protected String[] methods(Class<?> interfaceClass);

    protected Environment getEnvironment();

    @Override
    protected void processExtraRefresh(String preferredPrefix, InmemoryConfiguration subPropsConfiguration);

    private boolean verifyMethodConfig(MethodConfig methodConfig, Class<?> interfaceClass, boolean ignoreInvalidMethodConfig);

    private ArgumentConfig getArgumentByIndex(MethodConfig methodConfig, int argIndex);

    private boolean hasArgumentConfigProps(Map<String, String> configProperties, String methodName, int argIndex);

    protected MethodConfig getMethodByName(String name);

    /**
     * Legitimacy check of stub, note that: the local will deprecated, and replace with <code>stub</code>
     *
     * @param interfaceClass for provider side, it is the {@link Class} of the service that will be exported; for consumer
     *                       side, it is the {@link Class} of the remote service interface
     */
    protected void checkStubAndLocal(Class<?> interfaceClass);

    private void verifyStubAndLocal(String className, String label, Class<?> interfaceClass);

    private void verify(Class<?> interfaceClass, Class<?> localClass);

    private void convertRegistryIdsToRegistries();

    protected boolean notHasSelfRegistryProperty();

    protected void completeCompoundConfigs(AbstractInterfaceConfig interfaceConfig);

    protected void computeValidRegistryIds();

    /**
     * @return local
     * @deprecated Replace to <code>getStub()</code>
     */
    @Deprecated
    public String getLocal();

    /**
     * @param local
     * @deprecated Replace to <code>setStub(Boolean)</code>
     */
    @Deprecated
    public void setLocal(Boolean local);

    /**
     * @param local
     * @deprecated Replace to <code>setStub(String)</code>
     */
    @Deprecated
    public void setLocal(String local);

    public String getStub();

    public void setStub(Boolean stub);

    public void setStub(String stub);

    public String getCluster();

    public void setCluster(String cluster);

    public String getProxy();

    public void setProxy(String proxy);

    public Integer getConnections();

    public void setConnections(Integer connections);

    @Parameter(key = REFERENCE_FILTER_KEY, append = true)
    public String getFilter();

    public void setFilter(String filter);

    @Parameter(key = INVOKER_LISTENER_KEY, append = true)
    public String getListener();

    public void setListener(String listener);

    public String getLayer();

    public void setLayer(String layer);

    /**
     * Always use the global ApplicationConfig
     */
    public ApplicationConfig getApplication();

    /**
     * @deprecated Use {@link AbstractInterfaceConfig#setScopeModel(ScopeModel)}
     * @param application
     */
    @Deprecated
    public void setApplication(ApplicationConfig application);

    public ModuleConfig getModule();

    /**
     * @deprecated Use {@link AbstractInterfaceConfig#setScopeModel(ScopeModel)}
     * @param module
     */
    @Deprecated
    public void setModule(ModuleConfig module);

    public RegistryConfig getRegistry();

    public void setRegistry(RegistryConfig registry);

    public List<RegistryConfig> getRegistries();

    @SuppressWarnings({ "unchecked" })
    public void setRegistries(List<? extends RegistryConfig> registries);

    @Parameter(excluded = true)
    public String getRegistryIds();

    public void setRegistryIds(String registryIds);

    public List<MethodConfig> getMethods();

    @SuppressWarnings("unchecked")
    public void setMethods(List<? extends MethodConfig> methods);

    public void addMethod(MethodConfig methodConfig);

    public MonitorConfig getMonitor();

    /**
     * @deprecated Use {@link org.apache.dubbo.config.context.ConfigManager#setMonitor(MonitorConfig)}
     */
    @Deprecated
    public void setMonitor(String monitor);

    /**
     * @deprecated Use {@link org.apache.dubbo.config.context.ConfigManager#setMonitor(MonitorConfig)}
     */
    @Deprecated
    public void setMonitor(MonitorConfig monitor);

    public String getOwner();

    public void setOwner(String owner);

    /**
     * @deprecated Use {@link org.apache.dubbo.config.context.ConfigManager#getConfigCenter(String)}
     */
    @Deprecated
    public ConfigCenterConfig getConfigCenter();

    /**
     * @deprecated Use {@link org.apache.dubbo.config.context.ConfigManager#addConfigCenter(ConfigCenterConfig)}
     */
    @Deprecated
    public void setConfigCenter(ConfigCenterConfig configCenter);

    public Integer getCallbacks();

    public void setCallbacks(Integer callbacks);

    public String getOnconnect();

    public void setOnconnect(String onconnect);

    public String getOndisconnect();

    public void setOndisconnect(String ondisconnect);

    public String getScope();

    public void setScope(String scope);

    /**
     * @deprecated Use {@link ConfigManager#getMetadataConfigs()}
     */
    @Deprecated
    public MetadataReportConfig getMetadataReportConfig();

    /**
     * @deprecated Use {@link ConfigManager#addMetadataReport(MetadataReportConfig)}
     */
    @Deprecated
    public void setMetadataReportConfig(MetadataReportConfig metadataReportConfig);

    @Parameter(key = TAG_KEY)
    public String getTag();

    public void setTag(String tag);

    public Boolean getAuth();

    public void setAuth(Boolean auth);

    public SslConfig getSslConfig();

    public Boolean getSingleton();

    public void setSingleton(Boolean singleton);

    protected void initServiceMetadata(AbstractInterfaceConfig interfaceConfig);

    public String getGroup(AbstractInterfaceConfig interfaceConfig);

    public String getVersion(AbstractInterfaceConfig interfaceConfig);

    public String getVersion();

    public void setVersion(String version);

    public String getGroup();

    public void setGroup(String group);

    public String getInterface();

    public void setInterface(String interfaceName);

    public ClassLoader getInterfaceClassLoader();

    public void setInterfaceClassLoader(ClassLoader interfaceClassLoader);
}
