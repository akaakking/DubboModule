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

import org.apache.dubbo.common.config.ConfigurationUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import java.util.HashMap;
import java.util.Map;

/**
 * Starting from 2.7.0+, export and refer will only be executed when Spring is fully initialized.
 * <p>
 * Each Config bean will get refreshed on the start of the exporting and referring process.
 * <p>
 * So it's ok for this bean not to be the first Dubbo Config bean being initialized.
 * <p>
 */
public class ConfigCenterBean extends ConfigCenterConfig implements ApplicationContextAware, DisposableBean, EnvironmentAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext);

    @Override
    public void destroy() throws Exception;

    @Override
    public void setEnvironment(Environment environment);

    private Map<String, String> getConfigurations(String key, Environment environment);

    public ApplicationContext getApplicationContext();

    public Boolean getIncludeSpringEnv();

    public void setIncludeSpringEnv(Boolean includeSpringEnv);
}
