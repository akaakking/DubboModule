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

import org.apache.dubbo.common.config.CompositeConfiguration;
import org.apache.dubbo.common.config.ConfigurationUtils;
import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.common.config.PropertiesConfiguration;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.context.LifecycleAdapter;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.ConcurrentHashSet;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigKeys;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfigBase;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.emptyMap;
import static java.util.Optional.ofNullable;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO;
import static org.apache.dubbo.config.AbstractConfig.getTagName;

public abstract class AbstractConfigManagerInterface extends LifecycleAdapter {

    static {
        // init unique config types
        // unique config in application
        uniqueConfigTypes.add(ApplicationConfig.class);
        uniqueConfigTypes.add(MonitorConfig.class);
        uniqueConfigTypes.add(MetricsConfig.class);
        uniqueConfigTypes.add(SslConfig.class);
        // unique config in each module
        uniqueConfigTypes.add(ModuleConfig.class);
    }

    @Override
    public void initialize() throws IllegalStateException;

    /**
     * Add the dubbo {@link AbstractConfig config}
     *
     * @param config the dubbo {@link AbstractConfig config}
     */
    public final <T extends AbstractConfig> T addConfig(AbstractConfig config);

    public <C extends AbstractConfig> Map<String,C> getConfigsMap(Class<C> cls);

    public <C extends AbstractConfig> Collection<C> getConfigs(Class<C> configType);

    /**
     * Get config instance by id or by name
     *
     * @param cls      Config type
     * @param idOrName the id or name of the config
     * @return
     */
    public <T extends AbstractConfig> Optional<T> getConfig(Class<T> cls, String idOrName);

    public <C extends AbstractConfig> List<C> getDefaultConfigs(Class<C> cls);

    public abstract void loadConfigs();

    public <T extends AbstractConfig> List<T> loadConfigsOfTypeFromProps(Class<T> cls);

    public void refreshAll();

    /**
     * In some scenario,  we may need to add and remove ServiceConfig or ReferenceConfig dynamically.
     *
     * @param config the config instance to remove.
     * @return
     */
    public boolean removeConfig(AbstractConfig config);

    @Override
    public void destroy() throws IllegalStateException;

    public void clear();

    public boolean isInitialized();
}
