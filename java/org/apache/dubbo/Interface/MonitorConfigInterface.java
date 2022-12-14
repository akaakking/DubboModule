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

import org.apache.dubbo.common.constants.RegistryConstants;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Map;

/**
 * MonitorConfig
 *
 * @export
 */
public class MonitorConfig extends AbstractConfig {

    @Parameter(excluded = true)
    public String getAddress();

    public void setAddress(String address);

    @Parameter(excluded = true)
    public String getProtocol();

    public void setProtocol(String protocol);

    @Parameter(excluded = true)
    public String getUsername();

    public void setUsername(String username);

    @Parameter(excluded = true)
    public String getPassword();

    public void setPassword(String password);

    public String getGroup();

    public void setGroup(String group);

    public String getVersion();

    public void setVersion(String version);

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);

    public String getInterval();

    public void setInterval(String interval);

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();
}
