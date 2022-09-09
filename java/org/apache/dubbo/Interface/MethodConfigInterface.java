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

import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.common.config.InmemoryConfiguration;
import org.apache.dubbo.common.utils.ClassUtils;
import org.apache.dubbo.common.utils.MethodUtils;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.AsyncMethodInfo;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.apache.dubbo.config.Constants.ON_INVOKE_INSTANCE_PARAMETER_KEY;
import static org.apache.dubbo.config.Constants.ON_INVOKE_METHOD_PARAMETER_KEY;
import static org.apache.dubbo.config.Constants.ON_RETURN_INSTANCE_PARAMETER_KEY;
import static org.apache.dubbo.config.Constants.ON_RETURN_METHOD_PARAMETER_KEY;
import static org.apache.dubbo.config.Constants.ON_THROW_INSTANCE_PARAMETER_KEY;
import static org.apache.dubbo.config.Constants.ON_THROW_METHOD_PARAMETER_KEY;

/**
 * The method configuration
 *
 * @export
 */
public class MethodConfigInterface extends AbstractMethodConfig {

    /**
     * Get method prefixes
     *
     * @return
     */
    @Override
    @Parameter(excluded = true, attribute = false)
    public List<String> getPrefixes();

    @Parameter(excluded = true)
    public String getName();

    public void setName(String name);

    public Integer getStat();

    @Deprecated
    public void setStat(Integer stat);

    @Deprecated
    public Boolean isRetry();

    @Deprecated
    public void setRetry(Boolean retry);

    @Deprecated
    public Boolean isReliable();

    @Deprecated
    public void setReliable(Boolean reliable);

    public Integer getExecutes();

    public void setExecutes(Integer executes);

    public Boolean getDeprecated();

    public void setDeprecated(Boolean deprecated);

    @SuppressWarnings("unchecked")
    public void setArguments(List<? extends ArgumentConfig> arguments);

    public Boolean getSticky();

    public void setSticky(Boolean sticky);

    @Parameter(key = ON_RETURN_INSTANCE_PARAMETER_KEY, excluded = true, attribute = true)
    public Object getOnreturn();

    public void setOnreturn(Object onreturn);

    @Parameter(key = ON_RETURN_METHOD_PARAMETER_KEY, excluded = true, attribute = true)
    public String getOnreturnMethod();

    public void setOnreturnMethod(String onreturnMethod);

    @Parameter(key = ON_THROW_INSTANCE_PARAMETER_KEY, excluded = true, attribute = true)
    public Object getOnthrow();

    public void setOnthrow(Object onthrow);

    @Parameter(key = ON_THROW_METHOD_PARAMETER_KEY, excluded = true, attribute = true)
    public String getOnthrowMethod();

    public void setOnthrowMethod(String onthrowMethod);

    @Parameter(key = ON_INVOKE_INSTANCE_PARAMETER_KEY, excluded = true, attribute = true)
    public Object getOninvoke();

    public void setOninvoke(Object oninvoke);

    @Parameter(key = ON_INVOKE_METHOD_PARAMETER_KEY, excluded = true, attribute = true)
    public String getOninvokeMethod();

    public void setOninvokeMethod(String oninvokeMethod);

    public Boolean isReturn();

    public void setReturn(Boolean isReturn);

    @Parameter(excluded = true, attribute = false)
    public String getService();

    public void setService(String service);

    @Parameter(excluded = true, attribute = false)
    public String getServiceId();

    public void setServiceId(String serviceId);

    public void setParentPrefix(String parentPrefix);

    @Parameter(excluded = true, attribute = false)
    public String getParentPrefix();

    public void addArgument(ArgumentConfig argumentConfig);
}
