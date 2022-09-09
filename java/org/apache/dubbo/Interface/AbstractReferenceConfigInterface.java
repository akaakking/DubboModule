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
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.support.ProtocolUtils;
import static org.apache.dubbo.common.constants.CommonConstants.INVOKER_LISTENER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REFERENCE_FILTER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REFER_ASYNC_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.ROUTER_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.STUB_EVENT_KEY;
import static org.apache.dubbo.common.constants.RegistryConstants.PROVIDED_BY;
import static org.apache.dubbo.common.constants.RegistryConstants.PROVIDER_PORT;

/**
 * AbstractConsumerConfig
 *
 * @export
 * @see ReferenceConfigBase
 */
public abstract class AbstractReferenceConfig extends AbstractInterfaceConfig {

    // ======== Reference config default values, will take effect if reference's attribute is not set  ========
    /**
     * Whether to support event in stub.
     */
    // TODO solve merge problem
    @Override
    protected void checkDefault();

    public Boolean isCheck();

    public void setCheck(Boolean check);

    public Boolean isInit();

    public void setInit(Boolean init);

    /**
     * @deprecated Replace to {@link AbstractReferenceConfig#getGeneric()}
     */
    @Deprecated
    @Parameter(excluded = true, attribute = false)
    public Boolean isGeneric();

    /**
     * @deprecated Replace to {@link AbstractReferenceConfig#setGeneric(String)}
     */
    @Deprecated
    public void setGeneric(Boolean generic);

    public String getGeneric();

    public void setGeneric(String generic);

    /**
     * @return
     * @deprecated instead, use the parameter <b>scope</> to judge if it's in jvm, scope=local
     */
    @Deprecated
    public Boolean isInjvm();

    /**
     * @param injvm
     * @deprecated instead, use the parameter <b>scope</b> to judge if it's in jvm, scope=local
     */
    @Deprecated
    public void setInjvm(Boolean injvm);

    @Override
    @Parameter(key = REFERENCE_FILTER_KEY, append = true)
    public String getFilter();

    @Override
    @Parameter(key = INVOKER_LISTENER_KEY, append = true)
    public String getListener();

    @Override
    public void setListener(String listener);

    public Boolean getLazy();

    public void setLazy(Boolean lazy);

    @Override
    public void setOnconnect(String onconnect);

    @Override
    public void setOndisconnect(String ondisconnect);

    @Parameter(key = STUB_EVENT_KEY)
    public Boolean getStubevent();

    public String getReconnect();

    public void setReconnect(String reconnect);

    public Boolean getSticky();

    public void setSticky(Boolean sticky);

    @Parameter(key = PROVIDED_BY)
    public String getProvidedBy();

    public void setProvidedBy(String providedBy);

    @Parameter(key = PROVIDER_PORT)
    public Integer getProviderPort();

    public void setProviderPort(Integer providerPort);

    @Parameter(key = ROUTER_KEY, append = true)
    public String getRouter();

    public void setRouter(String router);

    @Deprecated
    @Parameter(key = REFER_ASYNC_KEY)
    public Boolean getReferAsync();

    @Deprecated
    public void setReferAsync(Boolean referAsync);

    public String getClient();

    public void setClient(String client);

    public String getProtocol();

    public void setProtocol(String protocol);
}
