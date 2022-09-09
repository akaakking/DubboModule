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
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ServiceMetadata;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.dubbo.rpc.support.ProtocolUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static org.apache.dubbo.common.constants.CommonConstants.COMMA_SPLIT_PATTERN;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO;

/**
 * ServiceConfig
 *
 * @export
 */
public abstract class ServiceConfigBase<T> extends AbstractServiceConfig {

    @Override
    protected void postProcessAfterScopeModelChanged(ScopeModel oldScopeModel, ScopeModel newScopeModel);

    public boolean shouldExport();

    @Override
    public Boolean getExport();

    public boolean shouldDelay();

    @Override
    public Integer getDelay();

    protected void checkRef();

    private String getClassDesc(Class clazz);

    public Optional<String> getContextPath(ProtocolConfig protocolConfig);

    protected Class getServiceClass(T ref);

    @Override
    protected void preProcessRefresh();

    @Override
    public Map<String, String> getMetaData();

    @Override
    public Map<String, String> getMetaData(String prefix);

    protected void checkProtocol();

    private boolean notHasSelfProtocolProperty();

    protected void completeCompoundConfigs();

    protected void convertProviderIdToProvider();

    protected void convertProtocolIdsToProtocols();

    public Class<?> getInterfaceClass();

    /**
     * @param interfaceClass
     * @see #setInterface(Class)
     * @deprecated
     */
    public void setInterfaceClass(Class<?> interfaceClass);

    public void setInterface(Class<?> interfaceClass);

    public T getRef();

    public void setRef(T ref);

    @Parameter(excluded = true)
    public String getPath();

    public void setPath(String path);

    public ProviderConfig getProvider();

    public void setProvider(ProviderConfig provider);

    @Parameter(excluded = true)
    public String getProviderIds();

    public void setProviderIds(String providerIds);

    public String getGeneric();

    public void setGeneric(String generic);

    public ServiceMetadata getServiceMetadata();

    @Override
    @Parameter(excluded = true, attribute = false)
    public List<String> getPrefixes();

    @Parameter(excluded = true, attribute = false)
    public String getUniqueServiceName();

    @Override
    public String getGroup();

    @Override
    public String getVersion();

    @Override
    protected void computeValidRegistryIds();

    public Boolean shouldExportAsync();

    /**
     * export service and auto start application instance
     */
    public abstract void export();

    public abstract void unexport();

    public abstract boolean isExported();

    public abstract boolean isUnexported();
}
