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

import org.apache.dubbo.config.ConfigCenterConfig;
import java.util.Map;

/**
 * This is a builder for build {@link ConfigCenterConfig}.
 *
 * @since 2.7
 */
public class ConfigCenterBuilder extends AbstractBuilder<ConfigCenterConfig, ConfigCenterBuilder> {

    public ConfigCenterBuilder protocol(String protocol);

    public ConfigCenterBuilder address(String address);

    public ConfigCenterBuilder cluster(String cluster);

    public ConfigCenterBuilder namespace(String namespace);

    public ConfigCenterBuilder group(String group);

    public ConfigCenterBuilder username(String username);

    public ConfigCenterBuilder password(String password);

    public ConfigCenterBuilder timeout(Long timeout);

    public ConfigCenterBuilder highestPriority(Boolean highestPriority);

    public ConfigCenterBuilder check(Boolean check);

    public ConfigCenterBuilder configFile(String configFile);

    public ConfigCenterBuilder appConfigFile(String appConfigFile);

    public ConfigCenterBuilder appendParameters(Map<String, String> appendParameters);

    public ConfigCenterBuilder appendParameter(String key, String value);

    public ConfigCenterConfig build();

    @Override
    protected ConfigCenterBuilder getThis();
}
