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
import org.apache.dubbo.common.utils.ClassUtils;
import org.apache.dubbo.common.utils.RegexProperties;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ServiceMetadata;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.dubbo.rpc.support.ProtocolUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO;
import static org.apache.dubbo.common.constants.CommonConstants.UNLOAD_CLUSTER_RELATED;

/**
 * ReferenceConfig
 *
 * @export
 */
public abstract class ReferenceConfigBase<T> extends AbstractReferenceConfig {

    public boolean shouldCheck();

    public boolean shouldInit();

    @Override
    protected void preProcessRefresh();

    @Override
    @Parameter(excluded = true, attribute = false)
    public List<String> getPrefixes();

    @Override
    public Map<String, String> getMetaData();

    @Override
    public Map<String, String> getMetaData(String prefix);

    /**
     * Get service interface class of this reference.
     * The actual service type of remote provider.
     * @return
     */
    public Class<?> getServiceInterfaceClass();

    /**
     * Get proxy interface class of this reference.
     * The proxy interface class is used to create proxy instance.
     * @return
     */
    public Class<?> getInterfaceClass();

    /**
     * Determine the interface of the proxy class
     * @param generic
     * @param interfaceName
     * @return
     */
    public static Class<?> determineInterfaceClass(String generic, String interfaceName);

    public static Class<?> determineInterfaceClass(String generic, String interfaceName, ClassLoader classLoader);

    @Override
    protected void postProcessAfterScopeModelChanged(ScopeModel oldScopeModel, ScopeModel newScopeModel);

    public void setInterface(Class<?> interfaceClass);

    @Parameter(excluded = true)
    public String getUrl();

    public void setUrl(String url);

    public ConsumerConfig getConsumer();

    public void setConsumer(ConsumerConfig consumer);

    @Parameter(key = UNLOAD_CLUSTER_RELATED)
    public Boolean getUnloadClusterRelated();

    public void setUnloadClusterRelated(Boolean unloadClusterRelated);

    public ServiceMetadata getServiceMetadata();

    protected void resolveFile();

    @Override
    protected void computeValidRegistryIds();

    @Parameter(excluded = true, attribute = false)
    public String getUniqueServiceName();

    @Override
    public String getVersion();

    @Override
    public String getGroup();

    public Boolean shouldReferAsync();

    public abstract T get();

    public void destroy();
}
