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

import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.AbstractInterfaceConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBuilder
 *
 * @since 2.7
 */
public abstract class AbstractInterfaceBuilder<T extends AbstractInterfaceConfig, B extends AbstractInterfaceBuilder<T, B>> extends AbstractMethodBuilder<T, B> {

    /**
     * @param local
     * @see AbstractInterfaceBuilder#stub(String)
     * @deprecated Replace to <code>stub(String)</code>
     */
    @Deprecated
    public B local(String local);

    /**
     * @param local
     * @see AbstractInterfaceBuilder#stub(Boolean)
     * @deprecated Replace to <code>stub(Boolean)</code>
     */
    @Deprecated
    public B local(Boolean local);

    public B stub(String stub);

    public B stub(Boolean stub);

    public B monitor(MonitorConfig monitor);

    public B monitor(String monitor);

    public B proxy(String proxy);

    public B cluster(String cluster);

    public B filter(String filter);

    public B listener(String listener);

    public B owner(String owner);

    public B connections(Integer connections);

    public B layer(String layer);

    public B application(ApplicationConfig application);

    public B module(ModuleConfig module);

    public B addRegistries(List<RegistryConfig> registries);

    public B addRegistry(RegistryConfig registry);

    public B registryIds(String registryIds);

    public B onconnect(String onconnect);

    public B ondisconnect(String ondisconnect);

    public B metadataReportConfig(MetadataReportConfig metadataReportConfig);

    public B configCenter(ConfigCenterConfig configCenter);

    public B callbacks(Integer callbacks);

    public B scope(String scope);

    public B tag(String tag);

    @Override
    public void build(T instance);
}
