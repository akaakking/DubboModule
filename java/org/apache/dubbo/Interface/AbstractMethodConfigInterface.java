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

import org.apache.dubbo.config.context.ModuleConfigManager;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.util.Map;

/**
 * AbstractMethodConfig
 *
 * @export
 */
public abstract class AbstractMethodConfigInterface extends AbstractConfig {

    public Integer getForks();

    public void setForks(Integer forks);

    public Integer getTimeout();

    public void setTimeout(Integer timeout);

    public Integer getRetries();

    public void setRetries(Integer retries);

    public String getLoadbalance();

    public void setLoadbalance(String loadbalance);

    public Boolean isAsync();

    public void setAsync(Boolean async);

    public Integer getActives();

    public void setActives(Integer actives);

    public Boolean getSent();

    public void setSent(Boolean sent);

    @Parameter(escaped = true)
    public String getMock();

    public void setMock(String mock);

    /**
     * Set the property "mock"
     *
     * @param mock the value of mock
     * @since 2.7.6
     * @deprecated use {@link #setMock(String)} instead
     */
    @Deprecated
    public void setMock(Object mock);

    public String getMerger();

    public void setMerger(String merger);

    public String getCache();

    public void setCache(String cache);

    public String getValidation();

    public void setValidation(String validation);

    public Map<String,String> getParameters();

    public void setParameters(Map<String, String> parameters);
}
