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

import org.apache.dubbo.config.MonitorConfig;
import java.util.Map;

/**
 * This is a builder for build {@link MonitorConfig}.
 *
 * @since 2.7
 */
public class MonitorBuilder extends AbstractBuilder<MonitorConfig, MonitorBuilder> {

    public MonitorBuilder protocol(String protocol);

    public MonitorBuilder address(String address);

    public MonitorBuilder username(String username);

    public MonitorBuilder password(String password);

    public MonitorBuilder group(String group);

    public MonitorBuilder version(String version);

    public MonitorBuilder interval(String interval);

    public MonitorBuilder isDefault(Boolean isDefault);

    public MonitorBuilder appendParameter(String key, String value);

    public MonitorBuilder appendParameters(Map<String, String> appendParameters);

    public MonitorConfig build();

    @Override
    protected MonitorBuilder getThis();
}
